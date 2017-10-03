package ua.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.Brand;
import ua.model.filter.SimpleFilter;
import ua.service.CrudService;

public class CrudServiceImpl<T, ID extends Serializable> implements CrudService<T, ID> {

	private final JpaRepository<T, ID> repository;
	
	public CrudServiceImpl(JpaRepository<T, ID> repository) {
		this.repository = repository;
	}

	@Override
	public T findOne(ID id) {
		return repository.findOne(id);
	}

	

	@Override
	public void save(T entity) {
		repository.save(entity);
	}

	@Override
	public void delete(ID id) {
		repository.delete(id);
	}

	

	@Override
	public List<T> findAll() {
		return repository.findAll();
	}

}
