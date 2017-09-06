package ua.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Cargo;
import ua.entity.Transporter;
import ua.model.view.TransporterView;
import ua.repository.TransporterRepository;
import ua.service.TransporterService;

@Service
public class TransporterServiceImpl extends CrudServiceImpl<Transporter, Integer> implements TransporterService{

	private final TransporterRepository repository;
	
	public TransporterServiceImpl(TransporterRepository repository) {
		super(repository);
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
public void save(Transporter transporter) {
	repository.save(transporter);
}

@Override
public void delete(Integer id) {
	repository.delete(id);
}

}
