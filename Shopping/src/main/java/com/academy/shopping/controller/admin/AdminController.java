package com.academy.shopping.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.academy.shopping.model.product.ProductService;

@Controller
public class AdminController {

	@Autowired
	private ProductService productService;
	
	//로그인 폼 요청 처리
	@GetMapping("/admin/loginform")
	public ModelAndView getForm(HttpServletRequest request) {
		
		return new ModelAndView("admin/login_form");
	}

	//관리자 등록 폼 요청 처리
	@GetMapping("/admin/registform") 
	public ModelAndView getRegistForm(HttpServletRequest request) {
		//jsp의 이름 이 밑에 들어가야함 
		return new ModelAndView("admin/regist");
	}
	
	//관리자 메인페이지 요청
	@GetMapping("/admin/main")
	public ModelAndView getMain(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/index");
		return mav;
	}
}
