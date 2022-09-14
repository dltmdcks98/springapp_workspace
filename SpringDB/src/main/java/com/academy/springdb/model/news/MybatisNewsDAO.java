package com.academy.springdb.model.news;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.academy.springdb.exception.NewsException;
import com.academy.springdb.model.domain.News;

@Repository
public class MybatisNewsDAO implements NewsDAO{
	//mybatis - spring 의 쿼리 수행 객체 jdbc -> jdbcTemplate
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List selectAll() {
		
		return sqlSessionTemplate.selectList("News.selectAll");
	}

	@Override
	public News select(int news_id) {
		
		return sqlSessionTemplate.selectOne("News.select", news_id);
	}

	@Override
	public void insert(News news)throws NewsException {
		// TODO Auto-generated method stub
		System.out.println("Mybatis로 insert 시도");
		int result = sqlSessionTemplate.insert("News.insert", news);
		if(result==0) {
			throw new NewsException("Mybatis를 이용한 등록 실패");
		}
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
