package com.academy.springmvcbasic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.academy.springmvcbasic.domain.Notice;
import com.academy.springmvcbasic.model.repository.NoticeDAO;

/*
 * 수정 요청을 처리하는 하위 컨트롤러
 */
public class noticeEditController implements Controller {
	private NoticeDAO noticeDAO;
	
	//setter 대신 new를 하게 되면 NoticeController와 NoticeDAO간 결합도가 너무 강해진다.
	//결합도가 너무 강해질때, 만을 NoticeDAO의 클래스가 사라져 버리면 오류가 나니까 
	//DI를 통해 약화
	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//3단계 : 수정하기
		String notice_id = request.getParameter("notice_id");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		Notice notice = new Notice();
		notice.setNotice_id(Integer.parseInt(notice_id));
		notice.setTitle(title);
		notice.setWriter(writer);
		notice.setContent(content);
		
		noticeDAO.update(notice);

//		수정한 값을 DB에 적용하고 데이터를 가져와야 하므고 redirect
		ModelAndView mav = new ModelAndView("redirect:/board/content?notice_id="+notice_id);
		
		return mav;
	}
	
}
