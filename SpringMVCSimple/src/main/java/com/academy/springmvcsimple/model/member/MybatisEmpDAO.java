package com.academy.springmvcsimple.model.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.academy.springmvcsimple.domain.Emp;
import com.academy.springmvcsimple.mybatis.MybatisConfigManager;
@Repository
public class MybatisEmpDAO implements EmpDAO{
	
	@Autowired
	MybatisConfigManager manager;
	
	@Override
	public int insert(Emp emp) {
		int result =0;
		SqlSession sqlSession = manager.getSqlSession();
		result = sqlSession.insert("Emp.insert",emp);
		sqlSession.commit();
		manager.closeSqlSession(sqlSession);
		return result;
	}

	@Override
	public List selectAll() {
		List list = null;
		SqlSession sqlSession = manager.getSqlSession();
		list = sqlSession.selectList("Emp.selectAll");
		System.out.println("list : "+list.size());
		manager.closeSqlSession(sqlSession);
		
		return list;
	}

	@Override
	public Emp select(int empno) {
		SqlSession sqlSession = manager.getSqlSession();
		Emp emp= sqlSession.selectOne("Emp.select",empno);
		manager.closeSqlSession(sqlSession);
		return emp;
	}

	@Override
	public int update(Emp emp) {
		return 0;
	}

	@Override
	public int delete(int empno) {
		return 0;
	}
	
}
