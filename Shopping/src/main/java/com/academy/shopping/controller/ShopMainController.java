package com.academy.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.academy.shopping.model.category.TopCategoryService;

//쇼핑몰 메인데 대한 요청 처리
@Controller
public class ShopMainController {
	
	@Autowired
	private TopCategoryService topCategoryService;
	
	
	@GetMapping("/shop")
	public ModelAndView getMain() {
		//신상품 및 각종 기획 상품등 진열 
		ModelAndView mav = new ModelAndView("shop/index");
		/* 아래 코드는 aop에서 동작
		 * //카테고리 가져오기 
		 * List topCategoryList =topCategoryService.selectAll();
		 * mav.addObject("topCategoryList",topCategoryList);
		 */		
		return mav;
	}
	
}
