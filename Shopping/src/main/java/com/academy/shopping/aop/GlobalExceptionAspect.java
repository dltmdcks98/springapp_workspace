package com.academy.shopping.aop;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.academy.shopping.exception.AdminException;
import com.academy.shopping.exception.EmailException;
import com.academy.shopping.exception.MemberException;
import com.academy.shopping.exception.OrderDetailException;
import com.academy.shopping.exception.OrderSummaryException;
import com.academy.shopping.exception.ProductException;

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
	@ExceptionHandler(OrderSummaryException.class)
	public ModelAndView handleException(OrderSummaryException e) {
		ModelAndView mav = new ModelAndView("shop/error/result");
		mav.addObject("e",e);
		
		return mav;
	}
	
	@ExceptionHandler(OrderDetailException.class)
	public ModelAndView handleException(OrderDetailException e) {
		ModelAndView mav = new ModelAndView("shop/error/result");
		mav.addObject("e",e);
		
		return mav;
	}
	@ExceptionHandler(EmailException.class)
	public ModelAndView handleException(EmailException e) {
		ModelAndView mav = new ModelAndView("shop/error/result");
		mav.addObject("e",e);
		
		return mav;
	}
	@ExceptionHandler(ProductException.class)
	public ModelAndView handleException(ProductException e) {
		ModelAndView mav = new ModelAndView("shop/error/result");
		mav.addObject("e",e);
		
		return mav;
	}
	
}
