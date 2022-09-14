package com.academy.springdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.academy.springdb.model.domain.News;
import com.academy.springdb.model.news.NewsService;

@Controller/*스프링 컨테이너가 메모리에 올릴 대상이 될 수 있도록*/
public class NewsContoller {
	
	@Autowired
	private NewsService newsService;
	
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
}
