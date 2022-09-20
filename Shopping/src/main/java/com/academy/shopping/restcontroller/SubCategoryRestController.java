package com.academy.shopping.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.academy.shopping.exception.SubCategoryException;
import com.academy.shopping.exception.TopCategoryException;
import com.academy.shopping.model.category.SubCategoryService;

@RestController
public class SubCategoryRestController {
	
	@Autowired
	private SubCategoryService subCategoryService;
	

	
	//관리자 - 해당 상위 카테고리에 소속된 하위 카테고리 목록 가져오기 요청 처리 
	@GetMapping("/admin/subcategory/{topcategory_id}")
	public List getSubList(@PathVariable("topcategory_id") int topcategory_id) {
		System.out.println("넘어온 topcategory_id is :"+topcategory_id);
		List subList = subCategoryService.selectByTopCategoryId(topcategory_id);
		System.out.println("넘어온 subcategory list :" +subList);
		return subList;
	}
	
	
//	예외처리
	@ExceptionHandler(SubCategoryException.class)
	public ResponseEntity handleException(TopCategoryException e) {
		ResponseEntity entity = new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	}
}
