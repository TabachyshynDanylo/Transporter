package ua.model.request;

import ua.entity.Brand;
import ua.entity.City;
import ua.entity.Model;
import ua.entity.Status;

public class TransporterRequest {
	
	private String email;
	
	private String name;

	private String password;
	
	private String repeatPassword;

	private String maxWeight;

	private String age;

	private String phone;

	private Brand brand;

	private Model model;

	private String carAge;


	public String getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(String maxWeight) {
		this.maxWeight = maxWeight;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
