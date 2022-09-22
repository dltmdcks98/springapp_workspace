package com.academy.shopping.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.academy.shopping.model.domain.Member;
import com.academy.shopping.model.member.MemberService;
import com.academy.shopping.model.util.HashManager;

@RestController
public class ShopMemberRestController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private HashManager hashManager;
	
	@PostMapping("/member")
	public ResponseEntity regist(Member member) {
		System.out.println(member.getMember_id());
		System.out.println(member.getCustomer_id());
		System.out.println(member.getCustomer_name());
		System.out.println(member.getCustomer_pass());
		System.out.println(member.getCustomer_email());
		
		
		memberService.insert(member);
		
		
		return new ResponseEntity(HttpStatus.OK);
	}
}
