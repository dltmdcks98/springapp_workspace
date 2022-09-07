package com.academy.springmvcsimple.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.academy.springmvcsimple.domain.Emp;
import com.academy.springmvcsimple.model.member.MemberService;

@Controller
public class MemberController {
	String TAG = this.getClass().getName();
	
//	//결합도를 낮추기 위함  최대한 추상적으로 
//	@Autowired
//	private EmpDAO empDAO;
//	@Autowired
//	private DeptDAO deptDAO; 위의 코드 대신
//	컨트롤러는 서비스를 통해 업무를 부탁한다.
	@Autowired
	private MemberService memberService;//DI를 구현하기 위해 상위 인터페이스를 보유한다.
	
	
	//사원 등록
	@RequestMapping(value = "/member/regist", method = RequestMethod.POST)
	public ModelAndView regist(Emp emp) {
		System.out.println(TAG+" : 사원명 :"	+emp.getEname());
		System.out.println(TAG+" : 희망 급여 :"	+emp.getSal());
		System.out.println(TAG+" : 부서명 :"	+emp.getDept().getDname());
		
		//이 시점 부터 MybatisEmpDAO = 다형성
//		empDAO.insert(emp);
//		deptDAO.insert(emp.getDept());//Dept 넣는것 
		//위의 코드가 있으면 model 역할까지 있는거 즉 Service가 있어야함
		
		memberService.regist(emp);//부서 + 사원 등록 업무가 추상화 되어 표현
		
		return new ModelAndView("redirect:/member/list");
	}
	
//	사원 목록 요청 처리
	@RequestMapping(value = "/member/list", method = RequestMethod.GET)
	public ModelAndView selectAll() {
		List memberList=memberService.selectAll();//3단계 일시키기
		ModelAndView mav= new ModelAndView();
		mav.addObject("memberList",memberList);//4단계 :결과 저장
		mav.setViewName("member/list");//포워딩

		return mav;
	}
	
	@RequestMapping(value = "/member/detail", method = RequestMethod.GET)
	public ModelAndView select(int empno) {
		Emp emp = memberService.select(empno);
		ModelAndView mav= new ModelAndView();
		mav.addObject("emp", emp);
		mav.setViewName("member/detail");
		return mav;
	}
	
}
