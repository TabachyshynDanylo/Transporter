package ua.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.entity.Goods;
import ua.entity.Model;

public interface ModelRepository extends JpaNameRepository<Model,Integer>, JpaSpecificationExecutor<Model>{


}
