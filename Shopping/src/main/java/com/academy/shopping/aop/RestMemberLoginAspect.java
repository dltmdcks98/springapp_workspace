package com.academy.shopping.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.http.ResponseEntity;

import com.academy.shopping.exception.MemberException;

public class RestMemberLoginAspect {
	String TAG=this.getClass().getName();//현재 클래스 명이 담아짐

	public Object loginCheck(ProceedingJoinPoint joinPoint) throws Throwable, MemberException{
		Object returnObj = null;
		
		System.out.println(TAG+" rest방식 회원 로그인 판단에 관여");
		
		System.out.println(TAG+" 원래 호출하려던 메서드"+joinPoint.getSignature().getName());
		
		HttpServletRequest request = null;
		HttpSession session = null;
		
		Object[] args = joinPoint.getArgs();
		for(Object arg : args) {
			System.out.println(TAG + " 매개변수 "+arg);
			if(arg instanceof HttpServletRequest) {
				request = (HttpServletRequest)arg;
			}
		}
		
		//회원 로그인 여부 판단
		session = request.getSession();
		if(session.getAttribute("member")==null) {
			throw new MemberException("회원 로그인이 필요한 서비스입니다.(rest)");
		}else {
			ResponseEntity entity=null;
			if(returnObj instanceof ResponseEntity) {
				entity=(ResponseEntity)returnObj;
				System.out.println("entity 반환" + entity);
			}
		}

		returnObj = joinPoint.proceed();//원래 호출하려던 메소드 호출
		
		
		return returnObj;
	}
	
}
