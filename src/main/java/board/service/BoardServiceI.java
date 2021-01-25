package board.service;

import java.util.List;

import board.model.BoardVo;

public interface BoardServiceI {

	// 게시판 조회
	List<BoardVo> selectAllBoard();

	// 게시판 생성
	int addBoard(BoardVo boardVo);

	// 게시판 이름/활성상태 수정
	int updateBoardAct(BoardVo boardVo);

	// 해당게시판의 글(답글개념) 가져오기
	List<BoardVo> selectOneBoard(int bcode);
}
