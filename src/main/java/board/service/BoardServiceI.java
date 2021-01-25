package board.service;

import java.util.List;

import board.model.BoardVo;

public interface BoardServiceI {

	// 게시판 조회
	List<BoardVo> selectAllBoard();

	// 게시판 생성
	int addBoard(BoardVo boardVo);
}