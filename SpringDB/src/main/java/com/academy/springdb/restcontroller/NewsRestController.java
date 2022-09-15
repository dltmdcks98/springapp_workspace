package com.academy.springdb.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//컨트롤러이지만, 이 요청은 jsp를 보내는 처리가 아닌, 오직 json,xml같은 데이터만 보내는 즉 
//비동기요청에만 반응하는 컨트롤러
@RestController
public class NewsRestController {
	public NewsRestController() {
		System.out.println("rest Controller 지금 Spring에 의해 태어남");
	}
	
	@GetMapping("/babo")//주소창에 rest/babo로 쳐야함
	@ResponseBody//jsp를 응답정보로 보내는 것이 아니라 String 데이터 자체를 응답정보로 보냄
	public String test() {
		return "this is data from my rest controller";
	}
	
	@PostMapping("/comments")
	public String regist() {
		System.out.println("댓글 등록 요청 받음");
		return null;
	}
	
	//뉴스기사에 소속된 댓글 목록 요청처리 뒤에 동사를 넣지않는다. {}는 변수화 시킨다
	//@PathVariabel : 경로 사이에 있는 문자를 변수로.(@PathVariable("news_id") int news_id 는 URL에 news_id에 자리에 있는 값은 변수 news_id로 넣는다.
	@GetMapping("/comments/{news_id}")
	@ResponseBody//접두어 접미어를 적용하지 않는다.
	public String getList(@PathVariable("news_id") int news_id) {
		System.out.println("넘어온 news_id :"+news_id);
		return "getLsit";
	}

}
