package ua.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.entity.Brand;
import ua.entity.Cargo;
import ua.entity.Goods;
import ua.entity.Owner;
import ua.service.CargoService;
import ua.service.OwnerService;

@Controller
@RequestMapping("/admin/owner")
public class AdminOwnerController {
private final OwnerService service;
@Autowired
private CargoService cargoService;
public AdminOwnerController(OwnerService service) {
	super();
	this.service = service;
}

@ModelAttribute("owner")
public Owner getForm(){
	return new Owner();
}
@GetMapping
public String show(Model model){
	 model.addAttribute("owners",service.findAllView());
	 model.addAttribute("cargos",service.findAllCargo());
return "owner"; 
}
@GetMapping("/delete/{id}")
public String show(@PathVariable Integer id){
	service.delete(id);
return "redirect:/admin/owner"; }
@PostMapping
public String save(
		 @RequestParam String name,
		 @RequestParam String phone,
		 @RequestParam int count,
		 @RequestParam String address,
		 @RequestParam List<Cargo> cargos
		 ){
	 Owner owner = new Owner(phone, count, address, cargos);
	 service.save(owner);
return "redirect:/admin/owner"; }
}
