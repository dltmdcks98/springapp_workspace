package com.academy.springdb.model.news;

import java.util.List;

import com.academy.springdb.model.domain.Comments;

public interface CommentsDAO {
	public List selectAll();
	public List selectByNewsId(int news_id);//해당 뉴스기사에 소속된 댓글 목록
	public Comments select(int comments_id);
	public void insert(Comments comments);
	public void update(Comments comments);
	public void delete(int comments_id);
}
