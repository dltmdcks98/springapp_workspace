package com.academy.springmvcsimple.domain;

import lombok.Data;

@Data
public class Emp {
	private int empno;
	private int ename;
	private String hiredate;
	private int sal;
	private Dept deptno;//숫자가 아니라, 객체를 has어 관계로 보유
}
