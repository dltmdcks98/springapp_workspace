package com.academy.ormsqlmapapp.model.board;

import java.util.List;

import com.academy.ormsqlmapapp.model.domain.Board;

public interface BoardDAO {
	public List selectAll();
	public Board select(int board_id);
	public void insert(Board board);
	public void update(Board board);
	public void delete(Board board);//hibernate에서 객체로 받음 
	
}
