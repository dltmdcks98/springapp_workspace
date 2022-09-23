package com.academy.shopping.aop;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.academy.shopping.model.category.TopCategoryService;

/*
 * 쇼핑몰에서 상위 카테고리는 어디서건 보여줄 정보이므로
 * 어플리케이션에 횡단적 관심사에 해당
 * 따라서 상위 카테고리 목록을 가져오는 코드를 별도의 객체로 정의하여,
 * AOP 의 Aspect로 정의해놓고, 필요할때마다 이 코드를 관여시킨다.
 */
public class TopCategoryAspect {
	
	@Autowired
	private TopCategoryService topCategoryService;
	
	//이 메서드는, 쇼핑몰의 상위 카테고리를 필요로하는 모든 메서드에서 공통적으로 동작할 예정
	public Object getCategoryList(ProceedingJoinPoint joinPoint) {
		System.out.println("컨트롤러가 동작할때 관여");
		
		//원래 호출하려던 객체명 알아맞추기
		Object target = joinPoint.getTarget();//원래 호출하려던 객체
		System.out.println("원래 호출하겨던 객체 : "+target.getClass().getName());
		
		Object returnObj=null;
		try {
			returnObj = joinPoint.proceed(); //원래 호출하려던 메서드 대신 호출(원래 메서드 역할)
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//원래의 요청 대센에Aspect가(프록시=대리)가 컨트롤러의 메서드를 대신 호출하고, 반환된 ModelAndView에 정보를 심어본다.
		ModelAndView mav = (ModelAndView)returnObj;
		List topCategoryList = topCategoryService.selectAll();
		mav.addObject("topCategoryList",topCategoryList);
		
		return mav;//DispatcherServlet에게 반환되면 이때 DispatcherServletdms ViewResolver에게 jsp페이지를 얻기 위한 해셕을 맡기
	}
	
}
