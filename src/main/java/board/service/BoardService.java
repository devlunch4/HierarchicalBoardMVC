package board.service;

import java.util.List;

import board.model.BoardVo;
import board.repository.BoardDao;
import board.repository.BoardDaoI;

public class BoardService implements BoardServiceI {
	private BoardDaoI boardDao = new BoardDao();

	// 게시판 조회
	@Override
	public List<BoardVo> selectAllBoard() {
		return boardDao.selectAllBoard();
	}

	// 게시판 생성
	@Override
	public int addBoard(BoardVo boardVo) {
		return boardDao.addBoard(boardVo);
	}
	// 게시판 상태 수정
	@Override
	public int updateBoardAct(BoardVo boardVo) {
		
		return boardDao.updateBoardAct(boardVo);
	}

}
