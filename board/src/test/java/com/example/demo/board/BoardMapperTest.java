package com.example.demo.board;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.mapper.BoardMapper;

@SpringBootTest
public class BoardMapperTest {

	@Autowired BoardMapper mapper;
	
	@Test
	public void 보드전체조회() {
		BoardVO vo = new BoardVO();
//		vo.setTitle(null);
//		vo.setContent(null);
		vo.setWriter("김철수");
		
		List<BoardVO> list = mapper.getBoardList(vo);
		
		System.out.println("결과는="+list.size());
	}
	
	@Test
	public void 보드단건조회() {
		int boardNo = 10;
		BoardVO vo = mapper.getBoardInfo(boardNo);
		System.out.println(vo);
//		assertEqual(employeeId, vo.getEmployeeId());
	}
	
	@Test
	public void 보드등록() {
		// vo 객체 생성
		BoardVO vo = new BoardVO();
		vo.setTitle("등록테스트");
		vo.setContent("등록테스트다!!!");
		vo.setWriter("관리자");
		
		int result = mapper.insertBoard(vo);
		
		// 등록된 사번을 조회
		System.out.println("등록된 사번 : " +vo.getContent()); 
		
		System.out.println("등록건수="+ result);
	}
	
	@Test
	public void 보드삭제() {
		int boardNo = 22;
		int result = mapper.deleteBoard(boardNo);
		System.out.println("삭제건수="+ result);
	}
	
	@Test
	public void 보드수정() {
		BoardVO vo = new BoardVO();
		vo.setBoardNo(11);
		vo.setContent("수정테스트 스프링");
		
		int result = mapper.updateBoard(vo);
		System.out.println("수정건수="+ result);
	}
}
