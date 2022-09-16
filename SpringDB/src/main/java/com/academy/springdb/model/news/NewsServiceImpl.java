package com.academy.springdb.model.news;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.academy.springdb.exception.NewsException;
import com.academy.springdb.model.domain.News;

@Service
public class NewsServiceImpl  implements NewsService{

	@Autowired
	//밑에 부분만 바꾸면 jdbc,mybatis 등으로 변경 
	@Qualifier("mybatisNewsDAO")
	private NewsDAO newsDAO;
	
	@Autowired
	@Qualifier("mybatisCommentsDAO")
	private CommentsDAO commentsDAO;
	
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

	@Transactional(propagation = Propagation.REQUIRED)//이 부분이 있으면, 트랜잭션을 자동으로 만들어준다.
	public void delete(int news_id) throws NewsException{
		//세부 업무 1 - 자식 글 삭제
		commentsDAO.deleteByNewsId(news_id);//예외 걸려있음 , 예외 발생시 Spring에서 예외를 알아서 처리 
		
		//세부 업무 2 - 부모글 삭제 
		newsDAO.delete(news_id);//예외 걸려있음

	}
	
}
