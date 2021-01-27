package board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import board.model.BoardVo;
import board.model.ReplyVo;
import board.repository.BoardDao;
import board.repository.BoardDaoI;
import common.model.PageVo;
import user.model.UserVo;

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

	// 게시글 페이징
	@Override
	public Map<String, Object> selectPagingBoard(PageVo pagevo) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BoardVo> boardList = boardDao.selectPagingBoard(pagevo);
		int boardCnt = boardDao.selectAllOneBoardCnt(pagevo.getBcode());
		map.put("boardList", boardList);
		map.put("boardCnt", boardCnt);
		return map;
	}

	// 해당 게시판의 댓글 조회
	@Override
	public List<ReplyVo> selectBoardReply(int bcode) {
		return boardDao.selectBoardReply(bcode);
	}

	@Override
	public int replyWrite(ReplyVo replyVo) {
		return boardDao.replyWrite(replyVo);
	}

	// 댓글 삭제(실제론 활성값 수정)
	@Override
	public int replyDelete(ReplyVo replyVo) {
		return boardDao.replyDelete(replyVo);
	}

}
