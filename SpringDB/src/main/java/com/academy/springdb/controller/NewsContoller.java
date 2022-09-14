package com.academy.springdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.academy.springdb.exception.NewsException;
import com.academy.springdb.model.domain.News;
import com.academy.springdb.model.news.NewsService;

@Controller/*스프링 컨테이너가 메모리에 올릴 대상이 될 수 있도록*/
public class NewsContoller {
	
	@Autowired
	private NewsService newsService;
	
	@GetMapping("/rest")
	@ResponseBody
	public String test() {
//		데이터만 보낼 때는 
		return "하이";
	}
	
	@GetMapping("/news/list")
	public ModelAndView selectAll() {
		System.out.println("클라이언트의 요청 감지");
		return null;
	}
	
	//글쓰기 폼 요청
	@GetMapping("/news/registform")
	public ModelAndView registForm() {
		ModelAndView mav = new ModelAndView("news/regist");
		return mav;
	}
	
	//글쓰기 요청 처리
	@PostMapping("/news/regist")
	public ModelAndView regist(News news) {
		newsService.regist(news);
		return null;
	}
	
	//스프링 MVC 컨트롤러의 메서드들 중에서 예외가 발생할때 이 예외를 처리할 메서드를 지원해준다. 
	@ExceptionHandler(NewsException.class)
	public ModelAndView handleException(NewsException e) {
		
		//클라이언트가 에러 메시지를 볼수 있도록 뷰로 저장 
		ModelAndView mav = new ModelAndView("error/result");
		mav.addObject("msg",e.getMessage());
		return mav;
	}
}
