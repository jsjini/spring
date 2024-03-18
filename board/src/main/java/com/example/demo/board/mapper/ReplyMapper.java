package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.board.ReplyVO;

@Mapper
public interface ReplyMapper {
	List<ReplyVO> getReplyList(ReplyVO vo);
	public int insertReply(ReplyVO vo);
	public ReplyVO getReplyInfo(long rno);
	
}
