package board.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.model.BoardVo;
import board.model.FileVo;
import board.model.ReplyVo;
import common.model.PageVo;
import db.MybatisUtil;
import user.model.UserVo;

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
		int addBoardCnt = sqlSession.insert("board.addBoard", boardVo);
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

	// 해당게시판의 글(답글개념) 가져오기
	@Override
	public List<BoardVo> selectOneBoard(int bcode) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<BoardVo> oneBoardList = sqlSession.selectList("board.selectOneBoard", bcode);
		sqlSession.close();
		return oneBoardList;

	}

	// 게시판 글 생성/추가
	@Override
	public int boardWrite(BoardVo boardVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int boardWriteCnt = sqlSession.update("board.boardWrite", boardVo);
		if (boardWriteCnt == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return boardWriteCnt;
	}

	// 글 하나 조회
	@Override
	public BoardVo boardOneRead(int bcode) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		BoardVo boardVo = sqlSession.selectOne("board.boardOneRead", bcode);
		sqlSession.close();
		return boardVo;
	}

	// 글 하나 수정
	@Override
	public int boardOneUpdate(BoardVo boardVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int boardOneUpdateCnt = sqlSession.update("board.boardOneUpdate", boardVo);
		if (boardOneUpdateCnt == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return boardOneUpdateCnt;
	}

	// 페이징 선택에 따른 게시글 조회
	@Override
	public List<BoardVo> selectPagingBoard(PageVo pagevo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<BoardVo> pageList = sqlSession.selectList("board.selectPagingBoard", pagevo);
		sqlSession.close();
		return pageList;
	}

	// 해당 게시글 전체수 조회
	@Override
	public int selectAllOneBoardCnt(int bcode) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int boardCnt = sqlSession.selectOne("board.selectAllOneBoardCnt", bcode);
		sqlSession.close();
		return boardCnt;
	}

	// 해당 게시글의 댓글 조회
	@Override
	public List<ReplyVo> selectBoardReply(int bcode) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<ReplyVo> reaplyList = sqlSession.selectList("reply.selectBoardReply", bcode);
		sqlSession.close();
		return reaplyList;
	}

	// 댓글 등록
	@Override
	public int replyWrite(ReplyVo replyVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int replyWriteCnt = sqlSession.update("reply.replyWrite", replyVo);
		if (replyWriteCnt == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return replyWriteCnt;
	}

	// 댓글 삭제(실제론 활성값 수정)
	@Override
	public int replyDelete(ReplyVo replyVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int replyDeleteCnt = sqlSession.update("reply.replyDelete", replyVo);
		if (replyDeleteCnt == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return replyDeleteCnt;
	}

	// 파일 정보 입력
	public int insertFile(FileVo fileVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int insertFileCnt = sqlSession.update("file.insertFile", fileVo);
		if (insertFileCnt == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return insertFileCnt;
	}
}
