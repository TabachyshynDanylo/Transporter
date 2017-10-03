package ua.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Brand;
import ua.model.filter.SimpleFilter;

public interface CrudService <T, ID extends Serializable>{
	T findOne(ID id);
	List<T> findAll();
	 void save(T entity);
	 void delete(ID id);

}
