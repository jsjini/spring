package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.board.BoardVO;

@Mapper
public interface BoardMapper {
	List<BoardVO> getBoardList(BoardVO vo);
	BoardVO getBoardInfo(int boardNo);
	int insertBoard(BoardVO BoardVO);
	int deleteBoard(int boardNo);
	int updateBoard(BoardVO vo);
}
