package ua.service;

import java.util.List;

import ua.entity.Transporter;
import ua.model.view.TransporterView;

public interface TransporterService{

	List<String> findAllModels();
	List<String> findAllBrands();
	List<String> findAllCity();
	List<TransporterView>findAllView();
	void save (Transporter transporter);
	void delete(Integer id);

}
