package com.academy.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.academy.shopping.model.category.TopCategoryService;
import com.academy.shopping.model.domain.Product;
import com.academy.shopping.model.product.ProductService;

@Controller
public class ShopProductContorller {
	
	@Autowired
	private TopCategoryService topCategoryService;
	
	@Autowired
	private ProductService productService;
	
	//상품 목록 페이지 요청 
//	@RequestParam(defaultValue="0") : 파라미터값이 아무것도 넘어오지 않았을때 기본값을 설정
	@GetMapping("/shop/product")
	public ModelAndView getProductMain(@RequestParam(defaultValue="0") int topcategory_id,@RequestParam(defaultValue="0") int subcategory_id) {
		//카테고리 가져오기
		List topCategoryList =topCategoryService.selectAll();
		
		//하위 카테고리에 소속된 상품 가져오기(만일 선택된 하위카테고리가 없는 상태라면 모두 가져오기)
		List productList=null;
		if(topcategory_id!=0) {//상위 카테고리를 선택한 경우
			productList=productService.selectByTopId(topcategory_id);
		}else {//왼쪽에 있는 네비바를 선택한 경우
			if(subcategory_id==0) {
				productList = productService.selectAll();
			}else {
				productList = productService.selectBySubId(subcategory_id);
			}
		}
		
		ModelAndView mav = new ModelAndView("shop/list");
		mav.addObject("topCategoryList", topCategoryList);
		mav.addObject("productList", productList);
		return mav;
		
	}
	
	//상품 상세요청 처리
	@GetMapping("/shop/product/view")
	public ModelAndView getDetail(int product_id) {
		ModelAndView mav = new ModelAndView("shop/detail");
		
		List topCategoryList = topCategoryService.selectAll();
		mav.addObject("topCategoryList",topCategoryList);
		
		Product product = productService.select(product_id);
		mav.addObject("product",product);
		return mav;
	}
}
