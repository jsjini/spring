package com.example.demo.board;

import java.sql.Date;

import lombok.Data;
@Data
public class BoardVO {
	
	int boardNo;
	String title;
	String content;
	String writer;
	Date writerDate;
	int clickCnt;
	String image;
	
	int start = 1;
	int end = 10;
}
