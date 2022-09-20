package com.academy.shopping.controller;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.academy.shopping.model.domain.Product;
import com.academy.shopping.model.product.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
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
	
	//관리자- 상품등록 요청 처리 
	@PostMapping("/admin/product/regist")
	public ModelAndView regist(HttpServletRequest request,Product product) {
		MultipartFile multi= product.getPhoto();
		
		//파일 저장
		ServletContext context = request.getServletContext();//어플리케잇견에 대한 정보 객체
		String path = context.getRealPath("/data");//얻고싶은 경로를 루트를 기준으로 명시
		multi.transferTo(new File(path));
		
		System.out.println(multi.getOriginalFilename());
		
		return null;
	}
}
