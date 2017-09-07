package ua.model.request;

import ua.entity.Brand;
import ua.entity.City;
import ua.entity.Model;
import ua.entity.Status;

public class TransporterRequest {
private Integer id;
	
	private String rate;
	
	private String maxWeight;
	
	private String photoUrl;
	
	private String version;
	
	private String name;
	
	private String count;
	
	private String age;
	
	private String phone;
	
	private Brand brand;
	
	private Model model;
	
	private String carAge;
	
	private City cityArrive;
	
	private String dateArrive;
	
	private Status status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(String maxWeight) {
		this.maxWeight = maxWeight;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public String getCarAge() {
		return carAge;
	}

	public void setCarAge(String carAge) {
		this.carAge = carAge;
	}

	public City getCityArrive() {
		return cityArrive;
	}

	public void setCityArrive(City cityArrive) {
		this.cityArrive = cityArrive;
	}

	public String getDateArrive() {
		return dateArrive;
	}

	public void setDateArrive(String dateArrive) {
		this.dateArrive = dateArrive;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
}
