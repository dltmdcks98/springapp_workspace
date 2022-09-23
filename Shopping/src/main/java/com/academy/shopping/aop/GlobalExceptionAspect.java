package com.academy.shopping.aop;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.academy.shopping.exception.AdminException;
import com.academy.shopping.exception.MemberException;

@ControllerAdvice //Controller 외부에서 나오는 Exception을 처리할 수 있음
public class GlobalExceptionAspect {
	
	@ExceptionHandler(AdminException.class)
	public ModelAndView handleException(AdminException e) {
		ModelAndView mav = new ModelAndView("admin/error/result");
		mav.addObject("e",e);
		
		return mav;
	}
	@ExceptionHandler(MemberException.class)
	public ModelAndView handleException(MemberException e) {
		ModelAndView mav = new ModelAndView("shop/error/result");
		mav.addObject("e",e);
		
		return mav;
	}
}
