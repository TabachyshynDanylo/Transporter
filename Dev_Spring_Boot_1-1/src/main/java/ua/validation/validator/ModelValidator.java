package ua.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import ua.repository.ModelRepository;
import ua.validation.annotation.UniqueModel;
@Component
public class ModelValidator implements ConstraintValidator<UniqueModel, String>{

	private final ModelRepository repository;
	
	public ModelValidator(ModelRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public void initialize(UniqueModel arg0) {
	}

	@Override
	public boolean isValid(String name, ConstraintValidatorContext context) {
		return repository.findByName(name.trim())==null;
	}

}
