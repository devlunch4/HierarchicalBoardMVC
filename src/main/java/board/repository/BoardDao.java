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
	public int boardCreate(BoardVo boardVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int boardCreate = sqlSession.update("board.boardCreate", boardVo);
		if (boardCreate == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return boardCreate;
	}

}
