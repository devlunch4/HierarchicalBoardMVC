package board.repository;

import java.util.List;

import board.model.BoardVo;

public interface BoardDaoI {

	// 게시판 조회
	List<BoardVo> selectAllBoard();

	// 게시판 생성/추가
	int addBoard(BoardVo boardVo);
	
	// 게시판 이름/활성상태 수정
	int updateBoardAct(BoardVo boardVo);
	
	// 게시판 하나 조회
	List<BoardVo> selectOneBoard(int bcode);
}
