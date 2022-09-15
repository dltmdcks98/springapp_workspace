package com.academy.springdb.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.academy.springdb.model.domain.Gallery;

@Controller
public class UploadController {

	//클라이언트가 전송한 파일을 업로드 처리
	@PostMapping("/upload")
	public ModelAndView save(HttpServletRequest request,Gallery gallery) {
		System.out.println("업로드 요청 받기 성공");
		System.out.println("제목 : "+gallery.getTitle());
		System.out.println("작성자 : "+gallery.getWriter());
		System.out.println("파일 : "+gallery.getPhoto());
		
		//업로드된 파일에 대한 분석
		MultipartFile multi=gallery.getPhoto();
		System.out.println("업로드된 파일의 유형"+multi.getContentType());
		System.out.println("업로드된 파일의 이름"+multi.getOriginalFilename());
		System.out.println("html 파라미터의 이름"+multi.getName());
		System.out.println("파일의 크기"+multi.getSize());
		
		//아직 물리적인 파일로 존재시킨 적이 없으므로, 원하는 서버의 디렉토리에 파일을 저장해보자
		String path =request.getServletContext().getRealPath("/resources/data");//jsp에서의 application내장객체(getServletContext() ..getRealpath()
		String filepath= path + "/" + multi.getOriginalFilename();
		try {
			multi.transferTo(new File(filepath));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
