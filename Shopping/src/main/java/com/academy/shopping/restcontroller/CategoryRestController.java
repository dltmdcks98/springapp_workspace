package com.academy.shopping.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academy.shopping.exception.TopCategoryException;
import com.academy.shopping.model.category.TopCategoryService;
import com.academy.shopping.model.domain.TopCategory;

@RestController
public class CategoryRestController {
	
	@Autowired
	private TopCategoryService topCategoryService;
	
	//관리자-카테고리 등록 요청 처리
	@PostMapping("/admin/category")
	public ResponseEntity regist(TopCategory topCategory) {
		topCategoryService.insert(topCategory);
		ResponseEntity entity = new ResponseEntity(HttpStatus.OK);//200
		return entity;
	}
	
	@ExceptionHandler(TopCategoryException.class)
	public ResponseEntity handleException(TopCategoryException e) {
		ResponseEntity entity = new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	}
}
