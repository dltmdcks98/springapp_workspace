package com.academy.springdb.model.news;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
		List list = null;
		list = jdbcTemplate.query("select * from news order by news_id desc", new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				News news = new News();
				news.setNews_id(rs.getInt("news_id"));
				news.setTitle(rs.getString("title"));
				news.setWriter(rs.getString("writer"));
				news.setContent(rs.getString("content"));
				news.setRegdate(rs.getString("regdate"));
				news.setHit(rs.getInt("hit"));
				
				return news;
			}
			
		});
		
		return list;
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
		int result = jdbcTemplate.update("insert into news(news_id,title,writer, content) values(seq_news.nextval,?,?,?)", news.getTitle(),news.getWriter(),news.getContent());//update 메소드가 DML을 처리
		
		if(result==0) {
			throw new NewsException("jdbc 템플릿으로 등록 실패");//throw 에러 발생시키는것
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
