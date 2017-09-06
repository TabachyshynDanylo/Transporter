package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import ua.entity.Cargo;
import ua.entity.Owner;
import ua.model.view.OwnerView;

public interface OwnerRepository extends JpaNameRepository<Owner,Integer> {
	
	@Query("SELECT c.name FROM Cargo c")
	List<String> findAllCargo();
	@Query("SELECT new ua.model.view.OwnerView(o.id, o.name, o.phone, o.count, o.address,c.name) FROM Owner o JOIN o.cargo c")
	List<OwnerView>findAllView();
}
