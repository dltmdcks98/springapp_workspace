package com.academy.ormsqlmapapp;

import com.academy.ormsqlmapapp.model.board.BoardDAO;
import com.academy.ormsqlmapapp.model.board.HibernateBoardDAO;
import com.academy.ormsqlmapapp.model.domain.Board;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoardDAO boardDAO = new HibernateBoardDAO();
/*	조회
		boardDAO.selectAll();
		*/
/* 삽입
		Board board = new Board();
		board.setTitle("하이버네이드");
		board.setWriter("superman");
		board.setContent("none");
		boardDAO.insert(board);
*/
		
		/*수정
		Board board = new Board();
		board.setBoard_id(5);
		board.setTitle("수정될까");
		board.setWriter("수정");
		board.setContent("ㅋㅋㅋ");
		boardDAO.update(board);
		*/
		Board board = new Board();
		board.setBoard_id(5);
		boardDAO.delete(board);
	}

}

