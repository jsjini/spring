package com.example.demo.board.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.board.ReplyVO;
import com.example.demo.board.service.ReplyService;
import com.example.demo.common.Paging;


@RestController
public class ReplyController {
	
	@Autowired ReplyService replyService;
	
	// 댓글리스트 데이터
	@GetMapping("/ajax/replyList")
	public Map<String, Object> replyList(ReplyVO vo, Paging pvo, int bno) {
		vo.setStart(pvo.getFirst());
		vo.setEnd(pvo.getLast());
		vo.setBno(bno);
		Map<String, Object> map = replyService.getReplyList(vo);
		pvo.setTotalRecord((Long)map.get("count"));
		map.put("paging", pvo);
		return map;
	}
	
	// 등록처리
	@PostMapping("/ajax/reply")
	public ReplyVO save(@RequestBody ReplyVO vo) {
		replyService.insertReply(vo);
		return vo;
	}
	
	// 상세조회	
	@GetMapping("/ajax/replyInfo/{rno}")
	public ReplyVO getBoardInfo(@PathVariable int rno) {
		return replyService.getReplyInfo(rno);
	}	
	
	// 수정처리
	@PostMapping("/ajax/replyUpdate")
	public ReplyVO update(@RequestBody ReplyVO vo) {
		System.out.println(vo);
		replyService.updateReply(vo);
		return vo;
	}	
	
	// 삭제처리
	@PostMapping("/ajax/replyDelete")
	public String delete(@RequestBody int rno) {
		replyService.deleteReply(rno);
		return "OK";
	}	
}
