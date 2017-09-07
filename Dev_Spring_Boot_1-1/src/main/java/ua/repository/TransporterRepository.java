package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import ua.entity.Transporter;
import ua.model.view.TransporterView;

public interface TransporterRepository extends JpaNameRepository<Transporter,Integer>{

	
	@Query("SELECT m.name FROM Model m")
	List<String> findAllModels();
	@Query("SELECT b.name FROM Brand b")
	List<String> findAllBrands();
	@Query("SELECT c.name FROM City c")
	List<String> findAllCity();
	@Query("SELECT new ua.model.view.TransporterView(t.id, t.rate, t.maxWeight, t.photoUrl, t.version, t.name, t.count, t.age, t.phone, b.name, m.name, t.carAge, cArrive.name, t.dateArrive, t.status) FROM Transporter t JOIN t.brand b JOIN t.model m JOIN t.cityArrive cArrive")
	List<TransporterView>findAllView();
	@Query("SELECT t FROM Transporter t JOIN FETCH t.brand b JOIN FETCH t.model m JOIN FETCH t.cityArrive cArrive")
	Transporter findOneRequest(Integer id);
}
