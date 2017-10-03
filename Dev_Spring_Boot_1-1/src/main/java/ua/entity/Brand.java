package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="brand", indexes=@Index(columnList = "name",unique=true))
public class Brand extends AbstractEntityName{

	
	@OneToMany(mappedBy="brand")
	private List<Transporter> transporters = new ArrayList<>();

	public Brand(String name) {
super(name);
	}

	public Brand() {
	}

	
}