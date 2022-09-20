package com.academy.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
	@GetMapping("/admin/product/list")
	public ModelAndView getList() {
		ModelAndView mav = new ModelAndView("admin/product/main");
		
		return mav;
	}
	
	@GetMapping("/admin/product/registform")
	public ModelAndView getRegistForm() {
		ModelAndView mav = new ModelAndView("admin/product/regist");
		return mav;
	}
	
}
