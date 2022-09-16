package com.academy.springdb.model.news;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.academy.springdb.exception.CommentsException;
import com.academy.springdb.model.domain.Comments;

@Repository
public class MybatisCommentsDAO implements CommentsDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

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
	public void delete(int comments_id) throws CommentsException{
	}

	@Override
	public void deleteByNewsId(int news_id) throws CommentsException {
		// TODO Auto-generated method stub
		int result = sqlSessionTemplate.delete("Comments.deleteByNewsId",news_id);
		if(result==0) {
			throw new CommentsException("mybatis로 댓글 삭제 실패");
		}
		
	}
	
}
