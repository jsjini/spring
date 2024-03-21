package com.example.demo.board.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.board.ReplyVO;
import com.example.demo.board.mapper.ReplyMapper;
import com.example.demo.board.service.ReplyService;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired ReplyMapper replyMapper;
		
	@Override
	public Map<String, Object> getReplyList(ReplyVO vo) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("data", replyMapper.getReplyList(vo));
		map.put("count", replyMapper.getCount1(vo));
		return map;
	}

	@Override
	public ReplyVO getReplyInfo(int rno) {
		return replyMapper.getReplyInfo(rno);
	}

	@Override
	public int insertReply(ReplyVO vo) {
		return replyMapper.insertReply(vo);
	}

	@Override
	public int updateReply(ReplyVO vo) {
		return replyMapper.updateReply(vo);
	}

	@Override
	public int deleteReply(int rno) {
		return replyMapper.deleteReply(rno);
	}
	
}
