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
	
	// 해당게시판의 글(답글개념) 가져오기
	List<BoardVo> selectOneBoard(int bcode);
	
	
	// 게시판 글 생성/추가
	int boardWrite(BoardVo boardVo);
	
	// 글 하나 조회
	BoardVo boardOneRead(int bcode);
	
	// 글 하나 수정
	int boardOneUpdate(BoardVo boardVo);
}
