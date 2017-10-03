package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Brand;
import ua.entity.City;
import ua.entity.Model;
import ua.entity.Transporter;
import ua.model.filter.SimpleFilter;
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
	Page<Transporter> findAllView(Pageable pageable,SimpleFilter filter);
	Page<Transporter> findAllCity(Pageable pageable,SimpleFilter filter);
	Page<Transporter> findAllModels(Pageable pageable,SimpleFilter filter);
	Page<Transporter> findAllBrands(Pageable pageable,SimpleFilter filter);

}
