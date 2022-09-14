package com.academy.springdb.model.news;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.academy.springdb.exception.NewsException;
import com.academy.springdb.model.domain.News;

@Repository
public class JdbcNewsDAO implements NewsDAO{
	
	//Spring에서 기존에 JDBC를 보다 편하고, 트랜잭션 등의 처리를 위해 지원되는 객체인 JdbcTemplate을 이용해여
	//쿼리문을 수행
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public News select(int news_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(News news) throws NewsException {//throws 에러 전가 
		// TODO Auto-generated method stub
		System.out.println("jdbc 탬플릿으로 insert시도");
//		int result = jdbcTemplate.update("insert into news(title,writer, content) values(?,?,?)", news.getTitle(),news.getWriter(),news.getContent());//update 메소드가 DML을 처리
		
//		if(result==0) {
			throw new NewsException("jdbc 템플릿으로 등록 실패");//throw 에러 발생시키는것
//		}
	
	}

	@Override
	public void update(News news) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int news_id) {
		// TODO Auto-generated method stub
		
	}
	
}
