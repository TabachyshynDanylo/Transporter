package ua.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.model.filter.ModelFilter;
import ua.model.view.ModelView;

public interface ModelViewRepository {
	
	Page<ModelView> findAll(Pageable pageable, ModelFilter filter);

}