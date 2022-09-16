package com.academy.ormsqlmapapp;

import com.academy.ormsqlmapapp.model.board.BoardDAO;
import com.academy.ormsqlmapapp.model.board.HibernateBoardDAO;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoardDAO boardDAO = new HibernateBoardDAO();
		boardDAO.selectAll();
	}

}
