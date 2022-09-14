package com.academy.springdb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//컨트롤러이지만, 이 요청은 jsp를 보내는 처리가 아닌, 오직 json,xml같은 데이터만 보내는 즉 
//비동기요청에만 반응하는 컨트롤러
@RestController
public class NewsRestController {
	
	@GetMapping("/babo")//주소창에 rest/babo로 쳐야함
	@ResponseBody//jsp를 응답정보로 보내는 것이 아니라 String 데이터 자체를 응답정보로 보냄
	public String test() {
		return "this is data from my rest controller";
	}
}
