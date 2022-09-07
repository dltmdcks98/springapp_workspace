package com.academy.springmvcsimple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.academy.springmvcsimple.domain.Emp;
import com.academy.springmvcsimple.model.member.DeptDAO;

@Controller
public class MemberController {
	String TAG = this.getClass().getName();
	
	//결합도를 낮추기 위함  최대한 추상적으로 

	private DeptDAO deptDao;
	
	//사원 등록
	@RequestMapping(value = "/member/regist", method = RequestMethod.POST)
	public ModelAndView regist(Emp emp) {
		System.out.println(TAG+" : 사원명 :"+emp.getEname());
		System.out.println(TAG+" : 희망 급여 :"+emp.getSal());
		System.out.println(TAG+" : 부서명 :"+emp.getDept().getDname());
		
		return null;
	}
}
