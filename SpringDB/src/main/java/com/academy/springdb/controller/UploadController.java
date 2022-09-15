package com.academy.springdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {

	//클라이언트가 전송한 파일을 업로드 처리
	@PostMapping("/upload")
	public ModelAndView save() {
		System.out.println("업로드 요청 받기 성공");
		
		return null;
	}
}
