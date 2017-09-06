package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.service.ModelService;
@Controller
@RequestMapping("/admin/model")
@SessionAttributes("model")
public class AdminModelController {

private final ModelService service;
@Autowired
public AdminModelController(ModelService service) {
	this.service = service;
}

@ModelAttribute("model")
public ua.entity.Model getForm(){
	return new ua.entity.Model();
}

@GetMapping
public String show(Model model){
	model.addAttribute("models",service.findAll());
	return "model";}


@GetMapping("/delete/{id}")
public String delete(@PathVariable Integer id){
service.delete(id);	return "redirect:/admin/model";}

@PostMapping
public String save(@ModelAttribute("model") ua.entity.Model model,SessionStatus status){
	service.save(model);
	return cancel(status);
}
@GetMapping("/update/{id}")
public String update(@PathVariable Integer id, Model model){
	model.addAttribute("model",service.findOne(id));
	return show(model);
}
@GetMapping("/cancel")
public String cancel(SessionStatus status){
	status.setComplete();
	return "redirect:/admin/model";
}

}
