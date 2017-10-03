package ua.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.entity.Brand;
import ua.entity.City;

public interface CityRepository extends JpaNameRepository<City,Integer>, JpaSpecificationExecutor<City>{

	City findByName(City name);

}
