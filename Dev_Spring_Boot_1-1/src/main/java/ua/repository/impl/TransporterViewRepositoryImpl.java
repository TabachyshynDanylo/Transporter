package ua.repository.impl;

import static org.springframework.data.jpa.repository.query.QueryUtils.toOrders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import ua.entity.Brand;
import ua.entity.City;
import ua.entity.Model;
import ua.entity.Transporter;
import ua.model.filter.TransporterFilter;
import ua.model.view.TransporterIndexView;
import ua.repository.TransporterViewRepository;

@Repository
public class TransporterViewRepositoryImpl implements TransporterViewRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Page<TransporterIndexView> findAll(TransporterFilter filter, Pageable pageable) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<TransporterIndexView> cq = cb.createQuery(TransporterIndexView.class);
		Root<Transporter> root = cq.from(Transporter.class);
		cq.multiselect(root.get("id"), root.get("rate"), root.get("maxWeight"), root.get("photoUrl"), root.get("version"), root.get("name"), root.get("count"));
		PredicateBuilder builder = new PredicateBuilder(filter, root, cb);
		Predicate predicate = builder.toPredicate();
		if(predicate!=null) cq.where(predicate);
		cq.orderBy(toOrders(pageable.getSort(), root, cb));
		List<TransporterIndexView> content = em.createQuery(cq)
			.setFirstResult(pageable.getPageNumber()*pageable.getPageSize())
			.setMaxResults(pageable.getPageSize())
			.getResultList();
		CriteriaBuilder cbCount = em.getCriteriaBuilder();
		CriteriaQuery<Long> cqCount = cb.createQuery(Long.class);
		Root<Transporter> rootCount = cqCount.from(Transporter.class);
		cqCount.select(cbCount.count(rootCount));
		PredicateBuilder countBuilder = new PredicateBuilder(filter, rootCount, cbCount);
		Predicate countPredicate = countBuilder.toPredicate();
		if(countPredicate!=null) cqCount.where(countPredicate);
		return PageableExecutionUtils.getPage(content, pageable, ()->em.createQuery(cqCount).getSingleResult()); 
	}
	
	private static class PredicateBuilder {
		
		final TransporterFilter filter;
		
		final Root<Transporter> root;
		
		final CriteriaBuilder cb;
		
		final List<Predicate> predicates = new ArrayList<>();
		
		Join<Transporter, Model> modelJoin;

		public PredicateBuilder(TransporterFilter filter, Root<Transporter> root, CriteriaBuilder cb) {
			this.filter = filter;
			this.root = root;
			this.cb = cb;
		}

		void filterByMinRate() {
			if(!filter.getMinRate().isEmpty()) {
				predicates.add(cb.ge(root.get("rate"), new BigDecimal(filter.getMinRate().replace(',', '.'))));
			}
		}

		void filterByMaxRate() {
			if(!filter.getMaxRate().isEmpty()) {
				predicates.add(cb.le(root.get("rate"), new BigDecimal(filter.getMaxRate().replace(',', '.'))));
			}
		}

		void filterByMinWeight() {
			if(!filter.getMinWeight().isEmpty()) {
				predicates.add(cb.ge(root.get("maxWeight"), Integer.valueOf(filter.getMinWeight())));
			}
		}

		void filterByMaxWeight() {
			if(!filter.getMaxWeight().isEmpty()) {
				predicates.add(cb.le(root.get("maxWeight"), Integer.valueOf(filter.getMaxWeight())));
			}
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
		
		void filterByMinAge() {
			if(!filter.getMinAge().isEmpty()) {
				predicates.add(cb.ge(root.get("age"), Integer.valueOf(filter.getMinAge())));
			}
		}

		void filterByMaxAge() {
			if(!filter.getMaxAge().isEmpty()) {
				predicates.add(cb.le(root.get("age"), Integer.valueOf(filter.getMaxAge())));
			}
		}
		
		
		void findByModelId() {
			if(!filter.getModelIds().isEmpty()) {
				modelJoin = root.join("model");
				predicates.add(modelJoin.get("name").in(filter.getModelIds()));
			}
		}
		
		void findByBrandId() {
			if(!filter.getBrandIds().isEmpty()) {
				if(modelJoin==null) modelJoin = root.join("model");
				Join<Model, Brand> brandJoin = modelJoin.join("brand");
				predicates.add(brandJoin.get("name").in(filter.getBrandIds()));
			}
		}
		
		void findByCitysId(){
			if(!filter.getCityId().isEmpty()){
				Join<Transporter, City> cityJoin = root.join("cityArrive");
				predicates.add(cityJoin.get("name").in(filter.getCityId()));
			}
		}
		
		Predicate toPredicate() {
			filterByMinRate();
			filterByMaxRate();
			filterByMinWeight();
			filterByMaxWeight();
			filterByMinCount();
			filterByMaxCount();
			filterByMinAge();
			filterByMaxAge();
			findByBrandId();
			findByModelId();
			findByCitysId();
			return predicates.isEmpty() ? null : cb.and(predicates.stream().toArray(Predicate[]::new));
		}
	}
	
}
