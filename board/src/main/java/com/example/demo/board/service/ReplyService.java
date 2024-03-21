package com.example.demo.board.service;

import java.util.Map;

import com.example.demo.board.ReplyVO;

public interface ReplyService {
	Map<String, Object> getReplyList(ReplyVO vo);
	ReplyVO getReplyInfo(int rno);
	int insertReply(ReplyVO vo);
	int deleteReply(int rno);
	int updateReply(ReplyVO vo);
}
