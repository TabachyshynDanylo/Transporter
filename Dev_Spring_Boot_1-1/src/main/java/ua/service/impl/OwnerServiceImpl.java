package ua.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Cargo;
import ua.entity.Owner;
import ua.model.view.OwnerView;
import ua.repository.OwnerRepository;
import ua.service.OwnerService;

@Service
public class OwnerServiceImpl extends CrudServiceImpl<Owner, Integer> implements OwnerService{
	private final OwnerRepository repository;
	public OwnerServiceImpl(OwnerRepository repository) {
		super(repository);
		this.repository=repository;
	}

@Override
public List<OwnerView> findAllView() {
	return repository.findAllView();
}

@Override
public List<String> findAllCargo() {
	return repository.findAllCargo();
}

@Override
public Owner findByName(String name) {
	return repository.findByName(name);
}
@Override
public void save(Owner owner) {
	repository.save(owner);
}

@Override
public void delete(Integer id) {
	repository.delete(id);
}

}
