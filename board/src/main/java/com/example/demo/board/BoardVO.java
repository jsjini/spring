package com.example.demo.board;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
public class BoardVO {
	
	int boardNo;
	String title;
	String content;
	String writer;
	@JsonFormat(pattern = "yyyy-MM-dd")
	Date writerDate;
	Integer clickCnt;
	String image;
	
	int start = 1;
	int end = 10;
}
