package com.academy.ormsqlmapapp.model.domain;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Board {
	private int board_id;
	private String title;
	private String writer;
	private String content;
	private String regdate;
	private int hit;
}
