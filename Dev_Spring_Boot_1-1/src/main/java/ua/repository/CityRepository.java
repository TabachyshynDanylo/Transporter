package ua.repository;

import ua.entity.City;

public interface CityRepository extends JpaNameRepository<City,Integer>{

	City findByName(City name);

}
