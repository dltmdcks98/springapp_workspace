package com.academy.shopping.controller.admin;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.academy.shopping.exception.ProductException;
import com.academy.shopping.exception.UploadException;
import com.academy.shopping.model.domain.Product;
import com.academy.shopping.model.product.ProductService;
import com.academy.shopping.model.util.FileManager;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private FileManager fileManager;
	//관리자 - 상품 목록 전체 조회
	@GetMapping("/admin/product/list")
	public ModelAndView getList(HttpServletRequest request) {
		//로그인 인증을 거치지 않았다면, 거부
		HttpSession session = request.getSession();
		
		ModelAndView mav =null;
		if(session.getAttribute("admin")==null) {//인증을 거치지 않고 들어오는 경우
			mav = new ModelAndView("admin/error/auth");
		}else {
			mav =  new ModelAndView("admin/product/main");
		}
		
		
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
	public ModelAndView regist(HttpServletRequest request, Product product) {
		productService.regist(product,request.getServletContext().getRealPath("/resources/data"));
		ModelAndView mav = new ModelAndView("redirect:/admin/product/list");
		return mav;
	}
	
	
	//관리자 - 상품 상세 조회
	//@RequestParam() : 디폴트 값을 넣을 수 있다. (defaultValue = "0")= 숫자를 default로 넣으면 String으로 해야함
	@GetMapping("/admin/product/view")
	public ModelAndView getDetail(HttpServletRequest request, @RequestParam(defaultValue = "0") int product_id) {
		ModelAndView mav = new ModelAndView("admin/product/detail");
		Product product =productService.select(product_id);
		mav.addObject("product",product);
		return mav;
	}
	
	
	@GetMapping("/admin/product/delete")
	public ModelAndView deleteProduct(HttpServletRequest request, Product product) {
		
		String dest = request.getServletContext().getRealPath("/resources/data/"+product.getProduct_img());
		
		productService.remove(product,dest); 
		
		return null;
	}
	
	//관리자- 상품 수정
	@PostMapping("/admin/product/edit")
	public ModelAndView edit(HttpServletRequest request, Product product) {

		productService.update(product);
		
		return null;
	}
	
	//관리자 엑셀 등록
	@PostMapping("/admin/product/excel")
	public ModelAndView registByExcel(HttpServletRequest request, MultipartFile excel) {
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("/resources/excel");
		
		File savedFile=fileManager.saveExcel(path,excel);
		
		//2.업로드된 엑셀 해석
		productService.registByExcel(savedFile,
				context.getRealPath("/resources/shop/img/product")
				,context.getRealPath("/resources/data")
				);
		
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
