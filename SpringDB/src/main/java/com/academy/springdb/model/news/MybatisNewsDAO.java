package com.academy.springdb.model.news;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.academy.springdb.model.domain.News;

@Repository
public class MybatisNewsDAO implements NewsDAO{

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
	public void insert(News news) {
		// TODO Auto-generated method stub
		System.out.println("Mybatis로 insert 시도");
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
