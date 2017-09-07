package ua.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import ua.entity.Cargo;
import ua.model.request.CargoRequest;
import ua.model.view.CargoView;
import ua.repository.CargoRepository;
import ua.service.CargoService;

@Service
public class CargoServiceImpl  implements CargoService{
	
	private final CargoRepository repository ;
	
	public CargoServiceImpl(CargoRepository repository) {
		this.repository=repository;

	}

@Override
public List<String> findAllGoods() {
	return repository.findAllGoods();
}

@Override
public List<String> findAllCity() {
	return repository.findAllCity();
}

@Override
public List<CargoView> findAllView() {
	return repository.findAllView();
}



@Override
public void save(CargoRequest request) {
	Cargo cargo = new Cargo();
	cargo.setCityFrom(request.getCityFrom());
	cargo.setCityTo(request.getCityTo());
	cargo.setGoods(request.getGoods());
	cargo.setHeight(Integer.valueOf(request.getHeight()));
	cargo.setLength(Integer.valueOf(request.getLength()));
	cargo.setWeight(Integer.valueOf(request.getWeight()));
	cargo.setWidth(Integer.valueOf(request.getWidth()));
	cargo.setPrice(new BigDecimal(request.getPrice().replace(',', '.')));
	cargo.setOwner(request.getOwner());
	cargo.setId(request.getId());
	
	repository.save(cargo);
}
@Override
public CargoRequest findOne(Integer id) {
	Cargo cargo =repository.findOneRequest(id);
	CargoRequest request = new CargoRequest();
	
	request.setCityFrom(cargo.getCityFrom());
	request.setCityTo(cargo.getCityTo());
	request.setGoods(cargo.getGoods());
	request.setHeight(String.valueOf(cargo.getHeight()));
	request.setLength(String.valueOf(cargo.getLength()));
	request.setWeight(String.valueOf(cargo.getWeight()));
	request.setWidth(String.valueOf(cargo.getWidth()));
	request.setPrice(String.valueOf(cargo.getPrice()));
	request.setOwner(cargo.getOwner());
	request.setId(cargo.getId());
	
	return request;
}
	
@Override
public void delete(Integer id) {
	repository.delete(id);
}



}
