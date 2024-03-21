package com.example.demo.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.mapper.ReplyMapper;

@SpringBootTest
public class ReplyMapperTests {
	
	@Autowired ReplyMapper mapper;
	
	//@Test
	public void 댓글등록() {
			ReplyVO vo = new ReplyVO();
			
			// 게시물의 번호
			vo.setReply("댓글 테스트");
			vo.setReplyer("replyer");
			vo.setBno(10);
			int result = mapper.insertReply(vo);
			System.out.println(result);
			System.out.println(vo);
	}
	
	@Test
	public void 댓글조회() {
		int rno = 1;
		ReplyVO vo = mapper.getReplyInfo(rno);
		System.out.println(vo);
	}
	
}
