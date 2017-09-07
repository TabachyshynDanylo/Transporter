package ua.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Transporter;
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
	transporter.setCityArrive(request.getCityArrive());
	transporter.setBrand(request.getBrand());
	transporter.setModel(request.getModel());
	transporter.setAge(Integer.valueOf(request.getAge()));
	transporter.setCarAge(Integer.valueOf(request.getCarAge()));
	transporter.setMaxWeight(Integer.valueOf(request.getMaxWeight()));
	transporter.setCount(Integer.valueOf(request.getCount()));
	transporter.setName(String.valueOf(request.getName()));
	transporter.setRate(new BigDecimal(request.getRate().replace(',', '.')));
	transporter.setPhotoUrl(String.valueOf(request.getPhotoUrl()));
	transporter.setVersion(Integer.valueOf(request.getVersion()));
	transporter.setPhone(String.valueOf(request.getPhone()));
	transporter.setStatus(request.getStatus());
	transporter.setId(request.getId());
	repository.save(transporter);
}

@Override
public TransporterRequest findOne(Integer id) {
	Transporter transporter = repository.findOneRequest(id);
	TransporterRequest request=new TransporterRequest();
	
	request.setCityArrive(transporter.getCityArrive());
	request.setBrand(transporter.getBrand());
	request.setModel(transporter.getModel());
	request.setAge(String.valueOf(transporter.getAge()));
	request.setCarAge(String.valueOf(transporter.getCarAge()));
	request.setMaxWeight(String.valueOf(transporter.getMaxWeight()));
	request.setCount(String.valueOf(transporter.getCount()));
	request.setName(String.valueOf(transporter.getName()));
	request.setRate(String.valueOf(transporter.getRate()));
	request.setPhotoUrl(String.valueOf(transporter.getPhotoUrl()));
	request.setVersion(String.valueOf(transporter.getVersion()));
	request.setPhone(String.valueOf(transporter.getPhone()));
	request.setStatus(transporter.getStatus());
	request.setDateArrive(String.valueOf(transporter.getDateArrive()));
	request.setId(transporter.getId());
	
	return request;
}

@Override
public void delete(Integer id) {
	repository.delete(id);
}

}
