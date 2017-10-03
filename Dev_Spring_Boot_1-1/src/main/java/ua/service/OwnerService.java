package ua.service;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Cargo;
import ua.entity.Owner;
import ua.model.filter.SimpleFilter;
import ua.model.request.OwnerRequest;
import ua.model.view.OwnerView;

public interface OwnerService{

	List<OwnerView> findAllView();
	void save (OwnerRequest request);
	void delete(Integer id);
	List<String> findAllCargo();
	Owner findByName(String name);
	OwnerRequest findOne(Integer id);
	Page<Owner> findAllView(Pageable pageable, SimpleFilter filter);
	Page<Owner> findAllCargo(Pageable pageable, SimpleFilter filter);
}
