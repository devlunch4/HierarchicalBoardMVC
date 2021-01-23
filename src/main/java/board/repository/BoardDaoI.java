package board.repository;

import board.model.BoardVo;

public interface BoardDaoI {

	//게시판 생성
	int boardCreate(BoardVo boardVo);
}
