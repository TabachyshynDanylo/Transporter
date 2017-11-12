package ua.repository.impl;

import static org.springframework.data.jpa.repository.query.QueryUtils.toOrders;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import ua.entity.Brand;
import ua.entity.Model;
import ua.model.filter.ModelFilter;
import ua.model.view.ModelView;
import ua.repository.ModelViewRepository;

@Repository
public class ModelViewRepositoryImpl implements ModelViewRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Page<ModelView> findAll(Pageable pageable, ModelFilter filter) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ModelView> cq = cb.createQuery(ModelView.class);
		Root<Model> root = cq.from(Model.class);
		Join<Model, Brand> brandJoin = root.join("brand",JoinType.LEFT);
		cq.multiselect(root.get("id"),root.get("name"), brandJoin.get("name"));
		PredicateBuilder builder = new PredicateBuilder(filter, root, cb);
		Predicate predicate = builder.toPredicate();
		if(predicate!=null) cq.where(predicate);
		cq.orderBy(toOrders(pageable.getSort(), root, cb));
		List<ModelView> content = em.createQuery(cq)
			.setFirstResult(pageable.getPageNumber()*pageable.getPageSize())
			.setMaxResults(pageable.getPageSize())
			.getResultList();
		CriteriaBuilder cbCount = em.getCriteriaBuilder();
		CriteriaQuery<Long> cqCount = cb.createQuery(Long.class);
		Root<Model> rootCount = cqCount.from(Model.class);
		cqCount.select(cbCount.count(rootCount));
		PredicateBuilder countBuilder = new PredicateBuilder(filter, rootCount, cbCount);
		Predicate countPredicate = countBuilder.toPredicate();
		if(countPredicate!=null) cqCount.where(countPredicate);
		return PageableExecutionUtils.getPage(content, pageable, ()->em.createQuery(cqCount).getSingleResult()); 
	}
	
	private static class PredicateBuilder{
		
		final ModelFilter filter;
		
		final Root<Model> root;
		
		final CriteriaBuilder cb;
		
		final List<Predicate> predicates = new ArrayList<>();
		
		public PredicateBuilder(ModelFilter filter, Root<Model> root, CriteriaBuilder cb) {
			this.filter = filter;
			this.root = root;
			this.cb = cb;
		}
		
		void findByName(){
			if(!filter.getName().isEmpty()){
				predicates.add(cb.like(root.get("name"), filter.getName()+"%"));
			}
		}
		
		void findByBrand(){
			if(!filter.getBrands().isEmpty()){
				Join<Model, Brand> brandJoin = root.join("brand");
				predicates.add(brandJoin.get("name").in(filter.getBrands()));
			}
		}
		
		
		
		Predicate toPredicate() {
			findByName();
			findByBrand();
			return predicates.isEmpty() ? null : cb.and(predicates.stream().toArray(Predicate[]::new));
		}
	}

}