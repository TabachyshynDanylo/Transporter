package ua.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.entity.Brand;
import ua.entity.Owner;
import ua.model.view.OwnerView;

public interface OwnerRepository extends JpaNameRepository<Owner,Integer>, JpaSpecificationExecutor<Owner>{
	
	@Query("SELECT c.name FROM Cargo c")
	List<String> findAllCargo();

	@Query("SELECT new ua.model.view.OwnerView(o.id, o.name, o.phone, o.count, o.address,c.name) FROM Owner o JOIN o.cargo c")
	List<OwnerView>findAllView();
	
	@Query(value = "SELECT new ua.model.view.OwnerView(o.id, o.name, o.phone, o.count, o.address,c.name) FROM Owner o JOIN o.cargo c",
			countQuery="SELECT o.id FROM Owner o JOIN o.cargo c")
	Page<OwnerView>findAllView(Pageable pageable);
	
	@Query("SELECT o FROM Owner o JOIN FETCH o.cargo c")
	Owner findOneRequest(Integer id);
}
