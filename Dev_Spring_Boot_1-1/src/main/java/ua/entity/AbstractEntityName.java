package ua.entity;

import javax.persistence.MappedSuperclass;

import org.hibernate.validator.constraints.NotBlank;

import ua.validation.annotation.UniqueBrand;
import ua.validation.annotation.UniqueCity;
import ua.validation.annotation.UniqueGoods;
import ua.validation.annotation.UniqueModel;

@MappedSuperclass
public abstract class AbstractEntityName extends AbstractEntity {
@UniqueBrand(message="Такий бренд вже існує")
@UniqueCity(message="Таке місто вже існує")
@UniqueGoods(message="Такий товар вже існує")
@UniqueModel(message="Така модель вже існує")
	@NotBlank(message="Поле не може бути порожнім")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AbstractEntityName() {
	}

	public AbstractEntityName(String name) {
		this.name = name;
	}
	

}
