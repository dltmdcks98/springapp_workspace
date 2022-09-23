package com.academy.shopping.restcontroller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academy.shopping.exception.SubCategoryException;
import com.academy.shopping.exception.TopCategoryException;
import com.academy.shopping.model.category.SubCategoryService;
import com.academy.shopping.model.domain.SubCategory;
import com.academy.shopping.model.domain.TopCategory;

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
	
//  관리자 - 해당 상위 카테고리에 소속된 하위 카테고리 추가
	@PostMapping("/admin/subcategory")
	public ResponseEntity registSub(SubCategory subCategory) {
		subCategoryService.insert(subCategory);
//		응답정보 컨텐츠의 헤더에 인코딩 처리
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/html;charset=UTF-8");
		
		ResponseEntity<String> entity = new ResponseEntity<String>("등록성공",headers,HttpStatus.OK);//200
		return entity;
	}
	
//	예외처리
	@ExceptionHandler(SubCategoryException.class)
	public ResponseEntity handleException(TopCategoryException e) {
		ResponseEntity entity = new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	}
}
