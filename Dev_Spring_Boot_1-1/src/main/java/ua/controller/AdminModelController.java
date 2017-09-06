package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.service.ModelService;

public class AdminModelController {

private final ModelService service;
@Autowired
public AdminModelController(ModelService service) {
	this.service = service;
}


@GetMapping
public String show(Model model){
	model.addAttribute("models",service.findAll());
	return "model";}


@GetMapping("/delete/{id}")
public String delete(@PathVariable Integer id){
service.delete(id);	return "redirect:/admin/model";}
@PostMapping
public String save(@RequestParam String name){
	ua.entity.Model model = new ua.entity.Model(name);
	service.save(model);
	return "redirect:/admin/model";
}
}
