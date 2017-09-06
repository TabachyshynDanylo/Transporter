package ua.service;

import ua.entity.Brand;

public interface BrandService extends CrudService<Brand, Integer>{
	Brand findByName(String name);
}
