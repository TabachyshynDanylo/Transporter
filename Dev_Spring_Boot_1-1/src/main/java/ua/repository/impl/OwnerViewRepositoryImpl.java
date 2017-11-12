package ua.repository.impl;

import static org.springframework.data.jpa.repository.query.QueryUtils.toOrders;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import ua.entity.Owner;
import ua.model.filter.OwnerFilter;
import ua.model.view.OwnerView;
import ua.repository.OwnerViewRepository;

@Repository
public class OwnerViewRepositoryImpl implements OwnerViewRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Page<OwnerView> findAll(OwnerFilter filter, Pageable pageable) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<OwnerView> cq = cb.createQuery(OwnerView.class);
		Root<Owner> root = cq.from(Owner.class);
		cq.multiselect(root.get("id"), root.get("name"), root.get("phone"), root.get("count"), root.get("address"));
		PredicateBuilder builder = new PredicateBuilder(filter, root, cb);
		Predicate predicate = builder.toPredicate();
		if(predicate!=null) cq.where(predicate);
		cq.orderBy(toOrders(pageable.getSort(), root, cb));
		List<OwnerView> content = em.createQuery(cq)
			.setFirstResult(pageable.getPageNumber()*pageable.getPageSize())
			.setMaxResults(pageable.getPageSize())
			.getResultList();
		CriteriaBuilder cbCount = em.getCriteriaBuilder();
		CriteriaQuery<Long> cqCount = cb.createQuery(Long.class);
		Root<Owner> rootCount = cqCount.from(Owner.class);
		cqCount.select(cbCount.count(rootCount));
		PredicateBuilder countBuilder = new PredicateBuilder(filter, rootCount, cbCount);
		Predicate countPredicate = countBuilder.toPredicate();
		if(countPredicate!=null) cqCount.where(countPredicate);
		return PageableExecutionUtils.getPage(content, pageable, ()->em.createQuery(cqCount).getSingleResult()); 
	}
	
	private static class PredicateBuilder {
		
		final OwnerFilter filter;
		
		final Root<Owner> root;
		
		final CriteriaBuilder cb;
		
		final List<Predicate> predicates = new ArrayList<>();
		
		public PredicateBuilder(OwnerFilter filter, Root<Owner> root, CriteriaBuilder cb) {
			this.filter = filter;
			this.root = root;
			this.cb = cb;
		}
		
		void filterByMinCount() {
			if(!filter.getMinCount().isEmpty()) {
				predicates.add(cb.ge(root.get("count"), Integer.valueOf(filter.getMinCount())));
			}
		}

		void filterByMaxCount() {
			if(!filter.getMaxCount().isEmpty()) {
				predicates.add(cb.le(root.get("count"), Integer.valueOf(filter.getMaxCount())));
			}
		}
		
		void filterByAddress(){
			if(!filter.getAddress().isEmpty()){
				predicates.add(cb.like(root.get("address"), filter.getAddress()+"%"));
			}
		}
		
		Predicate toPredicate() {
			filterByMinCount();
			filterByMaxCount();
			filterByAddress();
			return predicates.isEmpty() ? null : cb.and(predicates.stream().toArray(Predicate[]::new));
		}
	}

}