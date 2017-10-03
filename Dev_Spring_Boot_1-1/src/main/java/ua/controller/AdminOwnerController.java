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
import ua.model.request.OwnerRequest;
import ua.service.OwnerService;

@Controller
@RequestMapping("/admin/owner")
@SessionAttributes("owner")
public class AdminOwnerController {
	private final OwnerService service;

	public AdminOwnerController(OwnerService service) {
		super();
		this.service = service;
	}

	@ModelAttribute("owner")
	public OwnerRequest getForm() {
		return new OwnerRequest();
	}
	@ModelAttribute("filter")
	public SimpleFilter getFilter(){
		return new SimpleFilter();
	}
	@GetMapping
	public String show(Model model,@PageableDefault Pageable pageable,@ModelAttribute("filter") SimpleFilter filter) {
		model.addAttribute("owners", service.findAllView(pageable, filter));
		model.addAttribute("cargos", service.findAllCargo(pageable, filter));
		return "owner";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id,@PageableDefault Pageable pageable,@ModelAttribute("filter") SimpleFilter filter) {
		service.delete(id);
		return "redirect:/admin/owner"+buildParams(pageable, filter);
	}

	@PostMapping
	public String save(@ModelAttribute("owner") OwnerRequest request, SessionStatus status,@PageableDefault Pageable pageable,@ModelAttribute("filter") SimpleFilter filter) {
		service.save(request);
		return cancel(status, pageable, filter);
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model,@PageableDefault Pageable pageable,@ModelAttribute("filter") SimpleFilter filter) {
		model.addAttribute("owner", service.findOne(id));
		return show(model, pageable, filter);
	}

	@GetMapping("/cancel")
	public String cancel(SessionStatus status,@PageableDefault Pageable pageable,@ModelAttribute("filter") SimpleFilter filter) {
		status.setComplete();
		return "redirect:/admin/owner"+buildParams(pageable, filter);
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
