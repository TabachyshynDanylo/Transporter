package ua.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.entity.City;
import ua.entity.Goods;

public interface GoodsRepository extends JpaNameRepository<Goods,Integer>, JpaSpecificationExecutor<Goods>{

	Page<Goods> findAll(Specification<Goods> filter, Pageable pageable);

}
