package com.academy.shopping.aop;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.academy.shopping.exception.MemberException;
import com.academy.shopping.model.category.TopCategoryService;

//횡단적 관심사항에 대한 공통코드를 작성해놓은 객체(하나의 관점으로 둘 예정)
public class MemberLoginAspect {
	
	@Autowired
	private TopCategoryService topCategoryService;
	
	 public Object loginCheck(ProceedingJoinPoint joinPoint) throws Throwable,MemberException {
		 Object returnObj = null;
		 System.out.println("회원 로그인 판단에 관여");
		 
		 //세션을 꺼낸다.
		 Object[] args =joinPoint.getArgs();
		 HttpServletRequest request = null;
		 for(Object arg : args) {
			 if(arg instanceof HttpServletRequest) {
				 request = (HttpServletRequest)arg;
			 }
		 }
		 
		 String uri = request.getRequestURI();
		 HttpSession session=null;
		 
		 ModelAndView mav = null;
		 if(
			//로그인 하지 않고 접근 가능한 URI 명단
			uri.equals("/shop")||
			uri.equals("/shop/member/registform")||
			uri.equals("/shop/member/loginform")||
			uri.equals("/shop/product")||
			uri.equals("/shop/product/view")
		) {
			 //원래 호출하려던 메소드 호출
			 returnObj=joinPoint.proceed();
			 if(returnObj instanceof ModelAndView) {
				 mav = (ModelAndView)returnObj;
			 }
		 }else {
			 //세션체크
			 session=request.getSession();
			 if(session.getAttribute("member")==null) {
				 throw new MemberException("회원 로그인이 필요한 서비스입니다.");
			 }else {
				 returnObj=joinPoint.proceed();
				 if(returnObj instanceof ModelAndView) {
					 mav = (ModelAndView)returnObj;
				 }
			 }
		 }
		 
		 if(mav !=null) {//동생 컨트롤러의 메서드가  ModelandView를 반환한 경우만 
			 List topCategoryList = topCategoryService.selectAll();
			 mav.addObject("topCategoryList",topCategoryList);
			 returnObj = mav;
		 }
		 return returnObj;
	 }
}
