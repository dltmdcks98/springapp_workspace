package com.academy.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.academy.shopping.model.category.TopCategoryService;

@Controller
public class ShopProductContorller {
	
	@Autowired
	private TopCategoryService topCategoryService;
	
	//상품 목록 페이지 요청
	@GetMapping("/shop/product")
	public ModelAndView getProductMain() {
		List topCategoryList =topCategoryService.selectAll();
		ModelAndView mav = new ModelAndView("shop/list");
		mav.addObject("topCategoryList", topCategoryList);
		return mav;
		
	}
}
