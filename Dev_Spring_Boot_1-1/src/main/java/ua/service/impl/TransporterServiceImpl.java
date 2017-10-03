package ua.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.entity.Transporter;
import ua.model.filter.SimpleFilter;
import ua.model.request.TransporterRequest;
import ua.model.view.TransporterView;
import ua.repository.TransporterRepository;
import ua.service.TransporterService;

@Service
public class TransporterServiceImpl implements TransporterService{

	private final TransporterRepository repository;
	
	public TransporterServiceImpl(TransporterRepository repository) {
		this.repository=repository;
	}

@Override
public List<String> findAllModels() {
	return repository.findAllModels();
}

@Override
public List<String> findAllBrands() {
	return repository.findAllBrands();
}

@Override
public List<String> findAllCity() {
	return repository.findAllCity();
}

@Override
public List<TransporterView> findAllView() {
	return repository.findAllView();
}
@Override
public void save(TransporterRequest request) {
	Transporter transporter = new Transporter();
	transporter.setBrand(request.getBrand());
	transporter.setModel(request.getModel());
	transporter.setAge(Integer.valueOf(request.getAge()));
	transporter.setCarAge(Integer.valueOf(request.getCarAge()));
	transporter.setMaxWeight(Integer.valueOf(request.getMaxWeight()));
	transporter.setPhone(String.valueOf(request.getPhone()));
	repository.save(transporter);
}

@Override
public TransporterRequest findOne(Integer id) {
	Transporter transporter = repository.findOneRequest(id);
	TransporterRequest request=new TransporterRequest();
	
	request.setBrand(transporter.getBrand());
	request.setModel(transporter.getModel());
	request.setAge(String.valueOf(transporter.getAge()));
	request.setCarAge(String.valueOf(transporter.getCarAge()));
	request.setMaxWeight(String.valueOf(transporter.getMaxWeight()));
	request.setPhone(String.valueOf(transporter.getPhone()));
	
	return request;
}

@Override
public void delete(Integer id) {
	repository.delete(id);
}



@Override
public Page<Transporter> findAllView(Pageable pageable, SimpleFilter filter) {
	return repository.findAll(filter(filter), pageable);
}

@Override
public Page<Transporter> findAllCity(Pageable pageable, SimpleFilter filter) {
	return repository.findAll(filter(filter), pageable);
}

@Override
public Page<Transporter> findAllModels(Pageable pageable, SimpleFilter filter) {
	return repository.findAll(filter(filter), pageable);}

@Override
public Page<Transporter> findAllBrands(Pageable pageable, SimpleFilter filter) {
	return repository.findAll(filter(filter), pageable);
}
private Specification<Transporter> filter(SimpleFilter filter) {
	return (root, query, cb) -> {
		if (filter.getSearch().isEmpty())
			return null;
		return cb.like(root.get("name"), filter.getSearch() + "%");
	};

}
}
