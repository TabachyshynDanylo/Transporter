package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.entity.City;
import ua.service.CityService;

@Controller
@RequestMapping("/admin/city")
public class AdminCityController {
private final CityService service;
@Autowired
public AdminCityController(CityService service) {
	this.service = service;
}


@GetMapping
public String show(Model model){
	model.addAttribute("city's",service.findAll());
	return "city";}


@GetMapping("/delete/{id}")
public String delete(@PathVariable Integer id){
service.delete(id);	return "redirect:/admin/city";}
@PostMapping
public String save(@RequestParam String name){
	City city = new City(name);
	service.save(city);
	return "redirect:/admin/city";
}
}
