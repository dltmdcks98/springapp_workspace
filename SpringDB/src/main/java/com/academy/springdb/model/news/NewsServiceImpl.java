package com.academy.springdb.model.news;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.academy.springdb.exception.NewsException;
import com.academy.springdb.model.domain.News;

@Service
public class NewsServiceImpl  implements NewsService{

	@Autowired
	//밑에 부분만 바꾸면 jdbc,mybatis 등으로 변경 
	@Qualifier("mybatisNewsDAO")
	private NewsDAO newsDAO;
	
	@Override
	public List selectAll() {
		return newsDAO.selectAll();
	}

	@Override
	public News select(int news_id) {
	
		return newsDAO.select(news_id);
	}

	@Override
	public void regist(News news) throws NewsException{//처리를 여기서 하게되면 클라이언트가 에러를 볼수 없다.
		// TODO Auto-generated method stub
		newsDAO.insert(news);//  
	}

	@Override
	public void update(News news) throws NewsException {
		// TODO Auto-generated method stub
		newsDAO.update(news);
	}

	@Override
	public void delete(int news_id) throws NewsException{
		// TODO Auto-generated method stub
		newsDAO.delete(news_id);
	}
	
}
