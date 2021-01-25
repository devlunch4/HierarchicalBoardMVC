package board.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.model.BoardVo;
import db.MybatisUtil;

public class BoardDao implements BoardDaoI {

	// 게시판 조회
	@Override
	public List<BoardVo> selectAllBoard() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<BoardVo> boardList = sqlSession.selectList("board.selectAllBoard");
		sqlSession.close();
		return boardList;
	}

	// 게시판 생성
	@Override
	public int addBoard(BoardVo boardVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int addBoardCnt = sqlSession.update("board.addBoard", boardVo);
		if (addBoardCnt == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return addBoardCnt;
	}

	// 게시판 이름/활성상태 수정
	@Override
	public int updateBoardAct(BoardVo boardVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int updateBoardActCnt = sqlSession.update("board.updateBoardAct", boardVo);
		if (updateBoardActCnt == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return updateBoardActCnt;
	}

	// 하나의 게시판 조회
	@Override
	public List<BoardVo> selectOneBoard(int bcode) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<BoardVo> oneBoardList = sqlSession.selectList("board.selectOneBoard", bcode);
		sqlSession.close();
		return oneBoardList;

	}

}
