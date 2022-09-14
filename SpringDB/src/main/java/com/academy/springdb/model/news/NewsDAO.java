package com.academy.springdb.model.news;

import java.util.List;

import com.academy.springdb.model.domain.News;

public interface NewsDAO {
	public List selectAll();
	public News select(int news_id);
	
	//기존과는 다르게 void로 한다.
	public void insert(News news);
	public void update(News news);
	public void delete(int news_id);
	
}
