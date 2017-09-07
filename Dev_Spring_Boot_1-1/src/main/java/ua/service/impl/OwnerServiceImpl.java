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
	owner.setCargos(request.getCargos());
	owner.setAddress(String.valueOf(request.getAddress()));
	owner.setCount(Integer.valueOf(request.getCount()));
	owner.setPhone(String.valueOf(request.getPhone()));
	owner.setName(String.valueOf(request.getName()));
	owner.setId(request.getId());
	repository.save(owner);
}

@Override
public OwnerRequest findOne(Integer id) {
	Owner owner =repository.findOneRequest(id);
	OwnerRequest request= new OwnerRequest();

	request.setCargos(owner.getCargos());
	request.setAddress(String.valueOf(owner.getAddress()));
	request.setCount(String.valueOf(owner.getCount()));
	request.setPhone(String.valueOf(owner.getPhone()));
	request.setName(String.valueOf(owner.getName()));
	request.setId(owner.getId());
	
	return request;
}

@Override
public void delete(Integer id) {
	repository.delete(id);
}

}
