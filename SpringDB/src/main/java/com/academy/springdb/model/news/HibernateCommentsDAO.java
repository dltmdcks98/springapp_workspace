package com.academy.springdb.model.news;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.academy.springdb.model.domain.Comments;

@Repository
public class HibernateCommentsDAO implements CommentsDAO {

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List selectByNewsId(int news_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comments select(int comments_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Comments comments) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Comments comments) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int comments_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByNewsId(int news_id) {
		// TODO Auto-generated method stub
		
	}
	
}
