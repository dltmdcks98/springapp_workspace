package com.academy.springdb.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.academy.springdb.exception.CommentsException;
import com.academy.springdb.model.domain.Comments;
import com.academy.springdb.model.news.CommentsService;

//컨트롤러이지만, 이 요청은 jsp를 보내는 처리가 아닌, 오직 json,xml같은 데이터만 보내는 즉 
//비동기요청에만 반응하는 컨트롤러
@RestController
public class NewsRestController {
	
	@Autowired
	private CommentsService commentsService; 
	
	public NewsRestController() {
		System.out.println("rest Controller 지금 Spring에 의해 태어남");
	}
	
	@GetMapping("/babo")//주소창에 rest/babo로 쳐야함
	@ResponseBody//jsp를 응답정보로 보내는 것이 아니라 String 데이터 자체를 응답정보로 보냄
	public String test() {
		return "this is data from my rest controller";
	}
	
	//스프링의 모든 컨트롤러에서는 업무수행시 예외가 발생하면, 해당 예외를 처리할 수 있도록 이벤트를 지웒
	//이벤트는 @ExceptionHandelr 어노테이션으로 처리 
	@PostMapping("/comments")
	public String regist(Comments comments) {
		System.out.println(comments);
		commentsService.insert(comments);//댓글 등록
		
		return "ok";
	}
	
	//뉴스기사에 소속된 댓글 목록 요청처리 뒤에 동사를 넣지않는다. {}는 변수화 시킨다
	//@PathVariabel : 경로 사이에 있는 문자를 변수로.(@PathVariable("news_id") int news_id 는 URL에 news_id에 자리에 있는 값은 변수 news_id로 넣는다.
	@GetMapping("/comments/{news_id}")
	@ResponseBody//접두어 접미어를 적용하지 않는다.
	public List getList(@PathVariable("news_id") int news_id) {
		System.out.println("넘어온 news_id :"+news_id);
		
		List commentList = commentsService.selectByNewsId(news_id);
		//클라이언트가 예측하고 기다리는 데이터는 json,xml 이다. 
		//지금 전달하는 객체는 클라이언트가 이해할 수 없는 자바 객체 
		//따라서 자바 객체를 json으로 변환하되 수동이 아닌 자동으로 진행하려면 외부 라이브러러리(Gson)을 이용
		//Spring도 외부 라이브러리(Jackson Databind)를 이용
		return commentList;
	}


	@ExceptionHandler(CommentsException.class)
	public String handleException(CommentsException e){//예외가 발생하면, 해당 예외를 객체의 인스턴스를 생성하여 우리가 정의해놓은 메서드의 매개변수로 전달해준다.
		return e.getMessage();
		
	}
}
