package com.academy.springmvcbasic.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.academy.springmvcbasic.model.repository.NoticeDAO;

//공지 게시판의 목록요청을 처리하는 하위 컨트롤러(3,4단계 수행)
public class NoticeListController implements Controller{
	private NoticeDAO noticeDAO;
	
	//setter (injection)주입 
	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//3단계 일 시키기
		List boardList = noticeDAO.selectAll();
		System.out.println("글목록 수는"+boardList.size());
		//4단계 view로 전달 
		 ModelAndView mav = new ModelAndView();
		 mav.addObject("boardList",boardList);//요청 객체에 저장하는 효과
		 mav.setViewName("board/list");
		 
		return mav;//viewResolver가 받음
	}
}
