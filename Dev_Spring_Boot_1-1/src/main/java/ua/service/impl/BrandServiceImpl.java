package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Brand;
import ua.repository.BrandRepository;
import ua.service.BrandService;
@Service 
public class BrandServiceImpl extends CrudServiceImpl<Brand, Integer> implements BrandService{
	
	private final BrandRepository repository;
	public BrandServiceImpl(BrandRepository repository) {
		super(repository);
		this.repository=repository;
	}

@Override
public Brand findByName(String name) {
	return repository.findByName(name);
}

	

}
