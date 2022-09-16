package com.academy.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

	
	//로그인 폼 요청 처리
	@GetMapping("/admin/loginform")
	public ModelAndView getForm() {
		
		return new ModelAndView("admin/login_form");
	}

	//관리자 등록 폼 요청 처리
	@GetMapping("/admin/registform")
	public ModelAndView getRegistForm() {
		//jsp의 이름 이 밑에 들어가야함 
		return new ModelAndView("admin/regist");
	}
	
	
}
