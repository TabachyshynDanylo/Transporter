package ua.service;

import java.util.List;

import ua.entity.Transporter;
import ua.model.request.TransporterRequest;
import ua.model.view.TransporterView;

public interface TransporterService{

	List<String> findAllModels();
	List<String> findAllBrands();
	List<String> findAllCity();
	List<TransporterView>findAllView();
	void save (TransporterRequest request);
	void delete(Integer id);
	TransporterRequest findOne(Integer id);

}
