package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Cargo;
import ua.entity.City;
import ua.entity.Goods;
import ua.model.filter.SimpleFilter;
import ua.model.request.CargoRequest;
import ua.model.view.CargoView;


public interface CargoService{
	


void save (CargoRequest request);

void delete(Integer id);

CargoRequest findOne(Integer id);

Page<Cargo> findAllView(Pageable pageable, SimpleFilter filter);

Page<Cargo> findAllCity(Pageable pageable, SimpleFilter filter);

Page<Cargo> findAllGoods(Pageable pageable, SimpleFilter filter);



}
