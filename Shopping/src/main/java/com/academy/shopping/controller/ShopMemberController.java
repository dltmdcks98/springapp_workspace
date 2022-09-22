package com.academy.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.academy.shopping.model.category.TopCategoryService;
import com.academy.shopping.model.domain.Member;

@Controller
public class ShopMemberController {
	
	@Autowired
	private TopCategoryService topCategoryService;
	
	@GetMapping("/shop/member/registform")
	public ModelAndView getRegistForm() {
		List topCategoryList = topCategoryService.selectAll();
		
		ModelAndView mav = new ModelAndView("shop/member/join");
		mav.addObject("topCategoryList",topCategoryList);
		
		return mav;
	}
	@GetMapping("/shop/member/loginform")
	public ModelAndView getLoginForm() {
		List topCategoryList = topCategoryService.selectAll();

		ModelAndView mav = new ModelAndView("shop/member/login");
		mav.addObject("topCategoryList",topCategoryList);
		
		return mav;
	}
	

}
