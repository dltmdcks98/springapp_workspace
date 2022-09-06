package com.academy.springmvcbasic.model.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.academy.springmvcbasic.domain.Notice;
import com.academy.springmvcbasic.mybatis.MybatisConfigManager;

/*
 * MVC 중 모델 영역인 DAO를 정의
 */
public class NoticeDAO {
	MybatisConfigManager configManager= MybatisConfigManager.getInstance();//configmanager가 sql문을 연결 한다.
	
	public int insert(Notice notice) {
		int result =0;
		SqlSession sqlSession = configManager.getSqlSession();
		result=sqlSession.insert("Notice.insert",notice);
		sqlSession.commit();//myBatis는 자동 커밋이 안됨 
		configManager.closeSqlSession(sqlSession);
		return result;
	}
	
	public List selectAll() {
		List list = null;
		SqlSession sqlSession = configManager.getSqlSession();
		list = sqlSession.selectList("Notice.selectAll");
		configManager.closeSqlSession(sqlSession);
		return list;
	}
	//한건 가져오기 
	public Notice select(int notice_id) {
		Notice notice = null; 
		SqlSession sqlSession = configManager.getSqlSession();
		notice = sqlSession.selectOne("Notice.select",notice_id);
		configManager.closeSqlSession(sqlSession);
		return notice;
	}
	
	//한건 삭제하기
	public int delete(int notice_id) {
		int result = 0;
		SqlSession sqlSession = configManager.getSqlSession();
		result = sqlSession.delete("Notice.delete",notice_id);
		sqlSession.commit();
		configManager.closeSqlSession(sqlSession);
	

		return result;
	}
	
	//한건 수정
	public int update(Notice notice) {
		int result = 0;
		SqlSession sqlSession = configManager.getSqlSession();
		result=sqlSession.update("Notice.update", notice);
		sqlSession.commit();
		configManager.closeSqlSession(sqlSession);
		return result;
	}
}
