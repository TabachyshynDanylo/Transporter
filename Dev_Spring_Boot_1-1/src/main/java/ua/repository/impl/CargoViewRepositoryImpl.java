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
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import ua.entity.Cargo;
import ua.entity.City;
import ua.entity.Goods;
import ua.entity.Owner;
import ua.entity.Transporter;
import ua.model.filter.CargoFilter;
import ua.model.view.CargoView;
import ua.repository.CargoViewRepository;

@Repository
public class CargoViewRepositoryImpl implements CargoViewRepository{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Page<CargoView> findAll(CargoFilter filter, Pageable pageable) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CargoView> cq = cb.createQuery(CargoView.class);
		Root<Cargo> root = cq.from(Cargo.class);
		Join<Cargo, Goods> goodsJoin = root.join("goods");
		Join<Cargo, City> cityFromJoin = root.join("cityFrom");
		Join<Cargo, City> cityToJoin = root.join("cityTo");
		Join<Cargo, Owner> ownerJoin = root.join("owner");
		Join<Cargo, Transporter> transporterJoin = root.join("transporter",JoinType.LEFT);
		
		cq.multiselect(root.get("id"),goodsJoin.get("name"),root.get("weight"),root.get("height"),root.get("width"), root.get("length"), cityFromJoin.get("name"), cityToJoin.get("name"), ownerJoin.get("name"), transporterJoin.get("name"),  root.get("price"));
		PredicateBuilder builder = new PredicateBuilder(filter, root, cb);
		Predicate predicate = builder.toPredicate();
		
		if(predicate!=null) cq.where(predicate);
		cq.orderBy(toOrders(pageable.getSort(), root, cb));
		List<CargoView> content = em.createQuery(cq)
			.setFirstResult(pageable.getPageNumber()*pageable.getPageSize())
			.setMaxResults(pageable.getPageSize())
			.getResultList();
		CriteriaBuilder cbCount = em.getCriteriaBuilder();
		CriteriaQuery<Long> cqCount = cb.createQuery(Long.class);
		Root<Cargo> rootCount = cqCount.from(Cargo.class);
		cqCount.select(cbCount.count(rootCount));
		PredicateBuilder countBuilder = new PredicateBuilder(filter, rootCount, cbCount);
		Predicate countPredicate = countBuilder.toPredicate();
		if(countPredicate!=null) cqCount.where(countPredicate);
		return PageableExecutionUtils.getPage(content, pageable, ()->em.createQuery(cqCount).getSingleResult());
	}
	
	private static class PredicateBuilder {
		
		final CargoFilter filter;
		
		final Root<Cargo> root;
		
		final CriteriaBuilder cb;
		
		final List<Predicate> predicates = new ArrayList<>();
		
		public PredicateBuilder(CargoFilter filter, Root<Cargo> root, CriteriaBuilder cb) {
			this.filter = filter;
			this.root = root;
			this.cb = cb;
		}
		
		void filterAll(){
			predicates.add(root.get("transporter").isNull());
		}
		
		void filterByMinWeight(){
			if(!filter.getMinWeight().isEmpty()){
				predicates.add(cb.ge(root.get("weight"), Integer.valueOf(filter.getMinWeight())));
			}
		}
		
		void filterByMaxWeight(){
			if(!filter.getMaxWeight().isEmpty()){
				predicates.add(cb.le(root.get("weight"), Integer.valueOf(filter.getMaxWeight())));
			}
		}
		
		void filterByMinHeight(){
			if(!filter.getMinHeight().isEmpty()){
				predicates.add(cb.ge(root.get("height"), Integer.valueOf(filter.getMinHeight())));
			}
		}
		
		void filterByMaxHeight(){
			if(!filter.getMaxHeight().isEmpty()){
				predicates.add(cb.le(root.get("height"), Integer.valueOf(filter.getMaxHeight())));
			}
		}
		
		void filterByMinWidth(){
			if(!filter.getMinWidth().isEmpty()){
				predicates.add(cb.ge(root.get("width"), Integer.valueOf(filter.getMinWidth()))); 
			}
		}
		
		void filterByMaxWidth(){
			if(!filter.getMaxWidth().isEmpty()){
				predicates.add(cb.le(root.get("width"), Integer.valueOf(filter.getMaxWidth())));
			}
		}
		
		void filterByMinLength(){
			if(!filter.getMinLength().isEmpty()){
				predicates.add(cb.ge(root.get("length"), Integer.valueOf(filter.getMinLength())));
			}
		}
		
		void filterByMaxLength(){
			if(!filter.getMaxLength().isEmpty()){
				predicates.add(cb.le(root.get("length"), Integer.valueOf(filter.getMaxLength())));
			}
		}
		
		void findByCityFrom(){
			if(!filter.getCityFrom().isEmpty()){
				Join<Cargo, City> cityFromJoin = root.join("cityFrom");
				predicates.add(cityFromJoin.get("name").in(filter.getCityFrom()));
			}
		}
		
		void findByCityTo(){
			if(!filter.getCityTo().isEmpty()){
				Join<Cargo, City> cityToJoin = root.join("cityTo");
				predicates.add(cityToJoin.get("name").in(filter.getCityTo()));
			}
		}
		
		void filterByMinPrice() {
			if(!filter.getMinPrice().isEmpty()) {
				predicates.add(cb.ge(root.get("price"), new BigDecimal(filter.getMinPrice().replace(',', '.'))));
			}
		}

		void filterByMaxPrice() {
			if(!filter.getMaxPrice().isEmpty()) {
				predicates.add(cb.le(root.get("price"), new BigDecimal(filter.getMaxPrice().replace(',', '.'))));
			}
		}
		
		
		
		
		Predicate toPredicate() {
			filterAll();
			filterByMinWeight();
			filterByMaxWeight();
			filterByMinHeight();
			filterByMaxHeight();
			filterByMinWidth();
			filterByMinWidth();
			filterByMaxWidth();
			filterByMinLength();
			filterByMaxLength();
			findByCityFrom();
			findByCityTo();
			filterByMinPrice();
			filterByMaxPrice();
			return predicates.isEmpty() ? null : cb.and(predicates.stream().toArray(Predicate[]::new));
		}

	}

}