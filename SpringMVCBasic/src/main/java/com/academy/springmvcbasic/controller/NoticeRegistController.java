package com.academy.springmvcbasic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.academy.springmvcbasic.domain.Notice;
import com.academy.springmvcbasic.model.repository.NoticeDAO;

/*
 * 글쓰기 요청을 처리하는 하위 컨트롤러
 */
public class NoticeRegistController implements Controller {
	private NoticeDAO noticeDAO;
	
	//생성자 메소드 주입
	public NoticeRegistController(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("글쓰기 요청 받음");
		//3단계 
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content= request.getParameter("content");
		
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setWriter(writer);
		notice.setContent(content);
	
		noticeDAO.insert(notice);
		ModelAndView mav = new ModelAndView();
//		mav.setViewName("board/list"); viewResolver에 의해 /board/list.jsp으로 되므로 포워딩이 된다. 
		mav.setViewName("redirect:/board/list");//지정한 뷰 이름으로 재 접속
		
		return mav;
	}
	
}
