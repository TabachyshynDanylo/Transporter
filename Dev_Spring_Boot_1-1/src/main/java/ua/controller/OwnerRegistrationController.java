package ua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.model.request.OwnerRequest;
import ua.service.UserService;

@Controller
@RequestMapping("/registration/owner")
@SessionAttributes("transporter")
public class OwnerRegistrationController {

	public final UserService service;

	public OwnerRegistrationController(UserService service) {
		this.service = service;
	}
	
	@ModelAttribute("transporter")
	public OwnerRequest getForm(){
		return new OwnerRequest();
	}
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("models", service.findAllModels());
		return "owner-registration";
			}
	
	@PostMapping
	public String save(@ModelAttribute("owner") OwnerRequest request){
		service.save(request);
		return "redirect:/login";
	}

	
	
}
