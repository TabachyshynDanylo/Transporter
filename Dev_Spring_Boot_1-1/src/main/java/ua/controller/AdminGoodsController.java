package ua.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.entity.Brand;
import ua.entity.Goods;
import ua.model.filter.SimpleFilter;
import ua.service.GoodsService;
@Controller
@RequestMapping("/admin/goods")
@SessionAttributes("goods")
public class AdminGoodsController {

private final GoodsService service;
@Autowired
public AdminGoodsController(GoodsService service) {
	this.service = service;
}

@ModelAttribute("goods")
public Goods getForm(){
	return new Goods();
}
@ModelAttribute("filter")
public SimpleFilter getFilter(){
	return new SimpleFilter();
}

@GetMapping
public String show(Model model,@PageableDefault Pageable pageable,@ModelAttribute("filter") SimpleFilter filter){
	model.addAttribute("goodss",service.findAll(pageable, filter));
	return "goods";}


@GetMapping("/delete/{id}")
public String delete(@PathVariable Integer id,@PageableDefault Pageable pageable,@ModelAttribute("filter") SimpleFilter filter){
service.delete(id);	return "redirect:/admin/goods"+buildParams(pageable, filter);}
@PostMapping
public String save(@ModelAttribute("goods") @Valid Goods goods, BindingResult br,SessionStatus status, Model model,@PageableDefault Pageable pageable,@ModelAttribute("filter") SimpleFilter filter){
	if(br.hasErrors()){ return show(model, pageable, filter);}
	service.save(goods);
	return cancel(status, pageable, filter);
}
@GetMapping("/update/{id}")
public String update(@PathVariable Integer id, Model model,@PageableDefault Pageable pageable,@ModelAttribute("filter") SimpleFilter filter){
	model.addAttribute("goods",service.findOne(id));
	return show(model, pageable, filter);
}

@GetMapping("/cancel")
public String cancel(SessionStatus status,@PageableDefault Pageable pageable,@ModelAttribute("filter") SimpleFilter filter){
	status.setComplete();
	return "redirect:/admin/goods"+buildParams(pageable, filter);
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
