package com.academy.shopping.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.academy.shopping.exception.MemberException;
import com.academy.shopping.model.domain.Member;
import com.academy.shopping.model.member.MemberService;
import com.academy.shopping.model.util.HashManager;
import com.academy.shopping.model.util.Message;

@RestController
public class ShopMemberRestController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private HashManager hashManager;
	
	@PostMapping("/member")
	public ResponseEntity<Message> regist(Member member) {
		System.out.println(member.getCustomer_id());
		System.out.println(member.getCustomer_name());
		System.out.println(member.getCustomer_pass());
		System.out.println(member.getCustomer_email());
		
		memberService.insert(member);
		Message message = new Message(1,"가입 성공");
		
		
		ResponseEntity<Message> entity = new ResponseEntity<Message>(message,HttpStatus.CREATED);
		return entity;
	}

	@GetMapping("/member/{customer_id}")
	public ResponseEntity<Message> getId(@PathVariable("customer_id") String customer_id){
		System.out.println("검증할 아이디" + customer_id);
		
		
		return null;
	}
	
	
	//사용자가 생성한 Exception이라 HttpStatus.ok를 사용하면 성공으로 간주 
	@ExceptionHandler(MemberException.class)
	public ResponseEntity<Message> handleException(MemberException e){
		
		Message message = new Message(0,"가입실패");
		
		ResponseEntity<Message> entity = new ResponseEntity<Message>(message,HttpStatus.OK);
		
		return entity;
	}
}
