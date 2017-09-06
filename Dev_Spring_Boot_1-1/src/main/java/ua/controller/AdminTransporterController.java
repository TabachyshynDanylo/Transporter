package ua.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.entity.Brand;
import ua.entity.Cargo;
import ua.entity.City;
import ua.entity.Status;
import ua.entity.Transporter;
import ua.service.BrandService;
import ua.service.CityService;
import ua.service.ModelService;
import ua.service.TransporterService;

@Controller
@RequestMapping("/admin/transporter")
public class AdminTransporterController {
private final TransporterService service;
@Autowired
private CityService cityService;
@Autowired
private BrandService brandService;
@Autowired
private ModelService modelService;
public AdminTransporterController(TransporterService service){
	super();
	this.service = service;
}


@GetMapping
public String show(Model model){
	 model.addAttribute("transporters",service.findAllView());
	 model.addAttribute("city's",service.findAllCity());
	 model.addAttribute("brands",service.findAllBrands());
	 model.addAttribute("models",service.findAllModels());
return "cargo"; 
}

@GetMapping("/delete/{id}")
public String show(@PathVariable Integer id){
	service.delete(id);
return "redirect:/admin/transporter"; }
@PostMapping
public String save(
		 @RequestParam String name,
		 @RequestParam BigDecimal rate,
		 @RequestParam int maxWeight,
		 @RequestParam int count,
		 @RequestParam String photoUrl,
		 @RequestParam int version,
		 @RequestParam int age,
		 @RequestParam String phone,
		 @RequestParam String brand,
		 @RequestParam String model,
		 @RequestParam int carAge,
		 @RequestParam City cityArrive,
		 @RequestParam LocalDateTime dateArrive,
		 @RequestParam Status status
		 ){
	Brand brand1=brandService.findByName(brand);
	ua.entity.Model model1=modelService.findByName(model);
	City arrive=cityService.findByName(cityArrive); 
	Transporter transporter = new Transporter(rate, maxWeight, photoUrl, version, count, age, phone, brand1, model1, carAge, arrive, dateArrive, status);
	service.save(transporter);
	
return "redirect:/admin/transporter"; }
}
