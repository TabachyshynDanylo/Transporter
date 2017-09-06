package ua.service;

import ua.entity.Model;

public interface ModelService extends CrudService<Model, Integer> {
	Model findByName(String name);
}
