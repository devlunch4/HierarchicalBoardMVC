package board.repository;

import java.util.List;

import board.model.BoardVo;
import board.model.ReplyVo;
import common.model.PageVo;

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

	// 게시글 페이징
	List<BoardVo> selectPagingBoard(PageVo pagevo);

	// 해당 게시글 전체수 조회
	int selectAllOneBoardCnt(int bcode);

	// 해당 게시판의 댓글 조회
	List<ReplyVo> selectBoardReply(int bcode);
	
	// 댓글 등록
	int replyWrite(ReplyVo replyVo);
}
