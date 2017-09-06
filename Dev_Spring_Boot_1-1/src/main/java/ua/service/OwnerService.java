package ua.service;
import java.util.List;

import ua.entity.Owner;
import ua.model.view.OwnerView;

public interface OwnerService{

	List<OwnerView> findAllView();
	void save (Owner owner);
	void delete(Integer id);
	List<String> findAllCargo();
	Owner findByName(String name);
}
