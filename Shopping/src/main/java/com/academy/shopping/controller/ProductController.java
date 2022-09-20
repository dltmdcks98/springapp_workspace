package com.academy.shopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.academy.shopping.exception.ProductException;
import com.academy.shopping.exception.UploadException;
import com.academy.shopping.model.domain.Product;
import com.academy.shopping.model.product.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/admin/product/list")
	public ModelAndView getList() {
		ModelAndView mav = new ModelAndView("admin/product/main");
		
		List productList = productService.selectAll();
		mav.addObject("productList",productList);//저장
		return mav;
	}
	
	@GetMapping("/admin/product/registform")
	public ModelAndView getRegistForm() {
		ModelAndView mav = new ModelAndView("admin/product/regist");
		return mav;
	}
	
	//관리자- 상품등록 요청 처리 
	@PostMapping("/admin/product/regist")
	public ModelAndView regist(HttpServletRequest request,Product product) {
		productService.regist(product,request.getServletContext().getRealPath("/resources/data"));
		ModelAndView mav = new ModelAndView("redirect:/admin/product/list");
		return mav;
	}
	
	//에러 발생시
	@ExceptionHandler(UploadException.class)
	public ModelAndView handleException(UploadException e) {
		ModelAndView mav = new ModelAndView("admin/error/result");
		mav.addObject("e",e);
		return mav;
	}
	@ExceptionHandler(ProductException.class)
	public ModelAndView handleException(ProductException e) {
		ModelAndView mav = new ModelAndView("admin/error/result");
		mav.addObject("e",e);
		return mav;
	}
	
	
}
