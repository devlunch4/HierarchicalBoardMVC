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

	// 게시판 이름/활성상태 수정
	@Override
	public int updateBoardAct(BoardVo boardVo) {
		return boardDao.updateBoardAct(boardVo);
	}

	// 해당게시판의 글(답글개념) 가져오기
	@Override
	public List<BoardVo> selectOneBoard(int bcode) {
		return boardDao.selectOneBoard(bcode);
	}

	@Override
	public int boardWrite(BoardVo boardVo) {
		// TODO Auto-generated method stub
		return boardDao.boardWrite(boardVo);
	}
	// 글 하나 조회
	@Override
	public BoardVo boardOneRead(int bcode) {
		return boardDao.boardOneRead(bcode);
	}

	
	// 글 하나 수정
	@Override
	public int boardOneUpdate(BoardVo boardVo) {
		return boardDao.boardOneUpdate(boardVo);
	}

}
