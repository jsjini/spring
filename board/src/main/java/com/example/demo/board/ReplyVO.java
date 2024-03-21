package com.example.demo.board;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ReplyVO {
	private int rno;
	private int bno;
	
	private String reply;
	private String replyer;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date replyDate;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date updateDate;
	
	int start = 1;
	int end = 10;
}
