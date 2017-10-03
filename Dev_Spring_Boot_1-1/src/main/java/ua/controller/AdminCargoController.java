package ua.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.model.filter.SimpleFilter;
import ua.model.request.CargoRequest;
import ua.service.CargoService;

@Controller
@RequestMapping("/admin/cargo")
@SessionAttributes("cargo")
public class AdminCargoController {
	private final CargoService service;

	public AdminCargoController(CargoService service) {
		super();
		this.service = service;
	}

	@ModelAttribute("cargo")
	public CargoRequest getForm() {
		return new CargoRequest();
	}
	@ModelAttribute("filter")
	public SimpleFilter getFilter(){
		return new SimpleFilter();
	}
	@GetMapping
	public String show(Model model,@PageableDefault Pageable pageable,@ModelAttribute("filter") SimpleFilter filter) {
		model.addAttribute("cargos", service.findAllView(pageable, filter));
		model.addAttribute("city's", service.findAllCity(pageable, filter));
		model.addAttribute("goodss", service.findAllGoods(pageable, filter));
		return "cargo";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id,@PageableDefault Pageable pageable,@ModelAttribute("filter") SimpleFilter filter) {
		service.delete(id);
		return "redirect:/admin/cargo"+buildParams(pageable, filter);
	}

	@PostMapping
	public String save(@ModelAttribute("cargo") CargoRequest request, SessionStatus status,@PageableDefault Pageable pageable,@ModelAttribute("filter") SimpleFilter filter) {
		service.save(request);
		return cancel(status, pageable, filter);
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model,@PageableDefault Pageable pageable,@ModelAttribute("filter") SimpleFilter filter) {
		model.addAttribute("cargo", service.findOne(id));
		return show(model, pageable, filter);
	}

	@GetMapping("/cancel")
	public String cancel(SessionStatus status,@PageableDefault Pageable pageable,@ModelAttribute("filter") SimpleFilter filter) {
		status.setComplete();
		return "redirect:/admin/cargo"+buildParams(pageable, filter);
	}
	private String buildParams(Pageable pageable, SimpleFilter filter) {
		StringBuilder buffer = new StringBuilder();
		buffer.append("?page=");
		buffer.append(String.valueOf(pageable.getPageNumber()+1));
		buffer.append("&size=");
		buffer.append(String.valueOf(pageable.getPageSize()));
		if(pageable.getSort()!=null){
			buffer.append("&sort=");
			Sort sort = pageable.getSort();
			sort.forEach((order)->{
				buffer.append(order.getProperty());
				if(order.getDirection()!=Direction.ASC)
				buffer.append(",desc");
			});
		}
		buffer.append("&search=");
		buffer.append(filter.getSearch());
		return buffer.toString();
	}
	
}
