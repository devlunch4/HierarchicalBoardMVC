package board.repository;

import org.apache.ibatis.session.SqlSession;

import board.model.BoardVo;
import db.MybatisUtil;

public class BoardDao implements BoardDaoI{

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
	
	//게시판 조회
}
