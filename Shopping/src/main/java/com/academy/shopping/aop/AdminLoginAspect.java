package com.academy.shopping.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;

//관리자모드에서 로그인을 거치지 않고 진행한 요청에 대해
//거부처리
public class AdminLoginAspect {
	
	public Object loginCheck(ProceedingJoinPoint joinPoint) {
		System.out.println("관리자의 컨트롤러의 메서드 호출에 관여");
		
		//세션을 얻어와서 해당 세션에 admin 객체가 들어있는지 판단 및 처리
		Object[] args = joinPoint.getArgs();//원래 호출하려던 메서드의 매개변수 들 
		for(int i=0;i<args.length;i++) {
			if(args[i] instanceof HttpServletRequest ) {
				System.out.println("요청객체 발견 : "+args );
			}
		}
		return null;
	}
}
