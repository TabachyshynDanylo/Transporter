package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="owner", indexes=@Index(columnList = "name",unique=true))
public class Owner extends AbstractEntityName{

	public Owner(){}
	
	

	public Owner(String phone, int count, String address, List<Cargo> cargos) {
		this.phone = phone;
		this.count = count;
		this.address = address;
		this.cargos = cargos;
	}
@OneToOne
private User user;

	private String phone;
	
	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}
	@Column(name="_count")
	private int count;
	
	private String address;
	
	@OneToMany(mappedBy="owner")
	private List<Cargo> cargos = new ArrayList<>();

	

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}
}