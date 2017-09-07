package ua.service;
import java.util.List;

import ua.entity.Owner;
import ua.model.request.OwnerRequest;
import ua.model.view.OwnerView;

public interface OwnerService{

	List<OwnerView> findAllView();
	void save (OwnerRequest request);
	void delete(Integer id);
	List<String> findAllCargo();
	Owner findByName(String name);
	OwnerRequest findOne(Integer id);
}
