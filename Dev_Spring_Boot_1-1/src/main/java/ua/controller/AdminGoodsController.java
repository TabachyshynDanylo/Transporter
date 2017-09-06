package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.entity.Brand;
import ua.entity.Goods;
import ua.service.GoodsService;

public class AdminGoodsController {

private final GoodsService service;
@Autowired
public AdminGoodsController(GoodsService service) {
	this.service = service;
}


@GetMapping
public String show(Model model){
	model.addAttribute("goodss",service.findAll());
	return "goods";}


@GetMapping("/delete/{id}")
public String delete(@PathVariable Integer id){
service.delete(id);	return "redirect:/admin/goods";}
@PostMapping
public String save(@RequestParam String name){
	Goods goods = new Goods(name);
	service.save(goods);
	return "redirect:/admin/goods";
}

}
