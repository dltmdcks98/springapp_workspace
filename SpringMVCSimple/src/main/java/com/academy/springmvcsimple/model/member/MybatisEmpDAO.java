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
		return null;
	}

	@Override
	public Emp select(int empno) {
		return null;
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
