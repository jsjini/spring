package com.example.demo.emp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.board.ReplyVO;
import com.example.demo.board.mapper.ReplyMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ReplyController {
	
	final ReplyMapper mapper;
	
	// 리스트
	@GetMapping("/replies/list")
	
	
	// 등록처리
	@PostMapping("/replies/new")
	public ReplyVO save(ReplyVO vo) {
		mapper.insertReply(vo);
		return vo;
	}
	
	// 상세조회
	@GetMapping("replies/{rno}")
	public ReplyVO info(@PathVariable long rno) {
		return mapper.getReplyInfo(rno);
	}
	
	
}
