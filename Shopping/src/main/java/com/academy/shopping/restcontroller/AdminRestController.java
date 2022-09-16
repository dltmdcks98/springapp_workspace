package com.academy.shopping.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//controller vs restcontroller => restcontroller에 @ResponseBody가 붙여짐 즉 데이터만 넘어가는거
@RestController
public class AdminRestController {
	
	@PostMapping("/admin")
	@ResponseBody//RestController 에서는 이 속성이 자동부여됨 이 속성은 결과 뷰페이지를 매핑하는 것이 아니라, 순수 데이터를 전송하는 효과, 따라서 비동기 응답에 적절
	public String regist() {
		
		return "babo";
	}
}
