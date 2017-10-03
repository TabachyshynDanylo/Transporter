package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="model", indexes=@Index(columnList = "name",unique=true))
public class Model extends AbstractEntityName{

	
	@OneToMany(mappedBy="model")
	private List<Transporter> transporters = new ArrayList<>();

	public Model(String name) {
super(name);	}

	public Model() {
	}

	
}