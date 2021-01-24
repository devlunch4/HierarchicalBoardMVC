package board.repository;

import java.util.List;

import board.model.BoardVo;

public interface BoardDaoI {

	// 게시판 조회
	List<BoardVo> selectAllBoard();

	// 게시판 생성
	int boardCreate(BoardVo boardVo);
}
