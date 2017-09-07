package ua.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import ua.entity.Owner;
import ua.model.request.OwnerRequest;
import ua.model.view.OwnerView;
import ua.repository.OwnerRepository;
import ua.service.OwnerService;

@Service
public class OwnerServiceImpl implements OwnerService{
	private final OwnerRepository repository;
	public OwnerServiceImpl(OwnerRepository repository) {
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
public void save(OwnerRequest request) {
	Owner owner = new Owner();
	owner.setAddress(String.valueOf(request.getAddress()));
	owner.setPhone(String.valueOf(request.getPhone()));
	repository.save(owner);
}

@Override
public OwnerRequest findOne(Integer id) {
	Owner owner =repository.findOneRequest(id);
	OwnerRequest request= new OwnerRequest();

	request.setAddress(String.valueOf(owner.getAddress()));
	request.setPhone(String.valueOf(owner.getPhone()));
	
	return request;
}

@Override
public void delete(Integer id) {
	repository.delete(id);
}

}
