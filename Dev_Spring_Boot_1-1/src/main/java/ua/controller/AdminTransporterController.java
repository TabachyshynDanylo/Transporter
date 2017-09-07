package ua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.model.request.TransporterRequest;
import ua.service.TransporterService;

@Controller
@RequestMapping("/admin/transporter")
@SessionAttributes("transporter")
public class AdminTransporterController {
	private final TransporterService service;

	public AdminTransporterController(TransporterService service) {
		super();
		this.service = service;
	}

	@ModelAttribute("transporter")
	public TransporterRequest getForm() {
		return new TransporterRequest();
	}

	@GetMapping
	public String show(Model model) {
		model.addAttribute("transporters", service.findAllView());
		model.addAttribute("city's", service.findAllCity());
		model.addAttribute("brands", service.findAllBrands());
		model.addAttribute("models", service.findAllModels());
		return "transporter";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "redirect:/admin/transporter";
	}

	@PostMapping
	public String save(@ModelAttribute("transporter") TransporterRequest request, SessionStatus status) {
		service.save(request);
		return cancel(status);
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model) {
		model.addAttribute("transporter", service.findOne(id));
		return show(model);
	}

	@GetMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/admin/transporter";
	}
}
