package com.academy.shopping.restcontroller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.academy.shopping.model.domain.Product;
import com.academy.shopping.model.product.ProductService;
import com.academy.shopping.model.util.Message;

@RestController
public class ProductRestController {

	@Autowired
	private ProductService productService;
	
	
	@PostMapping("/admin/product/delete")												//json과 DTO의 매핑을 위해 RequestBody를 넣어야함
	public ResponseEntity<Message> delete(HttpServletRequest request,@RequestBody Product product){
		System.out.println("넘겨받은 상품id : "+product.getProduct_id());
		System.out.println("넘겨받은 상품 img : "+product.getProduct_img());
		
		String dest=request.getServletContext().getRealPath("/resources/data/"+product.getProduct_img());
		
		productService.remove(product, dest);
		Message message = new Message(1,"상품 삭제 성공");
		ResponseEntity<Message>entity = new ResponseEntity<Message>(message,HttpStatus.OK);
		
		return entity;
	}
}
