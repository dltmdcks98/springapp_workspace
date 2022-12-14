package com.academy.springmvcsimple.model.member;

import java.util.List;

import com.academy.springmvcsimple.domain.Dept;

/*
 * 이 DAO는 모든 DEPT 관련된 DAO의 최상위 객체이다.
 * 즉, JDBC, Hibenate, Mybatis, JPA로 갈지 상관없는 최상위 객체
 * 단순히 결합도를 낮추기 위한 인터페이스 메모리에 올리지 못함
 */
public interface DeptDAO { 
	public int insert(Dept dept);
	public List selectAll();
	public Dept select(int deptno);
	public int update(Dept dept);
	public int delete(int deptno);
}
