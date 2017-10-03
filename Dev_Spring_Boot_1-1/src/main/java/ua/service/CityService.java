package ua.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Brand;
import ua.entity.City;
import ua.model.filter.SimpleFilter;

public interface CityService extends CrudService<City, Integer>{
City findByName(City cityArrive);

Page<City> findAll(Pageable pageable, SimpleFilter filter);
}
