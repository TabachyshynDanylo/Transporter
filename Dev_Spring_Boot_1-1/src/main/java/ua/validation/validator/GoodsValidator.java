package ua.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import ua.repository.GoodsRepository;
import ua.validation.annotation.UniqueGoods;
@Component
public class GoodsValidator implements ConstraintValidator<UniqueGoods, String>{

	private final GoodsRepository repository;
	
	public GoodsValidator(GoodsRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public void initialize(UniqueGoods arg0) {
	}

	@Override
	public boolean isValid(String name, ConstraintValidatorContext context) {
		return repository.findByName(name.trim())==null;	}

}
