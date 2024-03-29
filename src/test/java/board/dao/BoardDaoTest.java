package board.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import board.model.BoardVo;
import board.model.ReplyVo;
import board.repository.BoardDao;
import board.repository.BoardDaoI;
import common.model.PageVo;

public class BoardDaoTest {
	private BoardDaoI boardDao;

	@Before
	public void setup() {
		boardDao = new BoardDao();
	}

	// 게시판 수 호출
	@Test
	public void selectAllBoardTest() {
		/*** Given ***/
//		BoardDaoI boardDao = new BoardDao();

		/*** When ***/
		List<BoardVo> boardList = boardDao.selectAllBoard();

		/*** Then ***/
		assertEquals(12, boardList.size());
	}

	// 게시판 생성
	@Test
	public void addBoardTest() {
		/*** Given ***/
//		BoardDaoI boardDao = new BoardDao();
		// 로그인을 해야만 승인이 된다
		BoardVo boardVo = new BoardVo("gogo", "테스트");

		/*** When ***/
		int addBoardTestCnt = boardDao.addBoard(boardVo);

		/*** Then ***/
		assertEquals(1, addBoardTestCnt);

	}

	// 게시판 이름/활성상태 수정
	@Test
	public void updateBoardActTest() {
		/*** Given ***/
//		BoardDaoI boardDao = new BoardDao();
		BoardVo boardVo = new BoardVo(1, "테스트", 0);
		/*** When ***/
		int updateBoardActCnt = boardDao.updateBoardAct(boardVo);

		/*** Then ***/
		assertEquals(1, updateBoardActCnt);
	}

	// 해당게시판의 글(답글개념) 가져오기
	@Test
	public void selectOneBoardTest() {
		/*** Given ***/
//		BoardDaoI boardDao = new BoardDao();
		int bcode = 1;

		/*** When ***/
		List<BoardVo> oneBoardList = boardDao.selectOneBoard(bcode);

		/*** Then ***/
		assertEquals(11, oneBoardList.size());
	}

	// 게시판 글 생성/추가
	@Test
	public void boardWriteTest() {
		/*** Given ***/
		// BoardDaoI boardDao = new BoardDao();
		// BoardVo boardVo = new BoardVo(parentBcode, originno, groupord, grouplayer,
		// writer, title, content);
		BoardVo boardVo = new BoardVo(1, 1, 1, 0, "테스트", "테스트", "테스트");

		/*** When ***/
		int boardWriteCnt = boardDao.boardWrite(boardVo);
		/*** Then ***/
		assertEquals(1, boardWriteCnt);

	}

	// 글 하나 조회
	@Test
	public void boardOneReadTest() {
		/*** Given ***/
		// BoardDaoI boardDao = new BoardDao();

		/*** When ***/
		// BoardVo boardVo = (BoardVo) boardService.boardOneRead(bcode);
		BoardVo boardVo = (BoardVo) boardDao.boardOneRead(1);

		/*** Then ***/
		assertEquals(0, boardVo.getActive());
	}

	// 글 하나 수정
	@Test
	public void boardOneUpdateTest() {
		/*** Given ***/
		// BoardDaoI boardDao = new BoardDao();
		// BoardVo boardvo = new BoardVo(title, content, active, bcode);
		BoardVo boardvo = new BoardVo("테스트", "테스트", 0, 1);
		/*** When ***/
		int boardOneUpdateCnt = boardDao.boardOneUpdate(boardvo);

		/*** Then ***/
		assertEquals(1, boardOneUpdateCnt);
	}

	// 게시글 페이징
	@Test
	public void selectPagingBoardTest() {
		/*** Given ***/
		PageVo pagevo = new PageVo(2, 2, 2);

		/*** When ***/
		List<BoardVo> boardList = boardDao.selectPagingBoard(pagevo);
		/*** Then ***/
		assertEquals(2, boardList.size());

	}

	// 해당 게시글 전체수 조회
	@Test
	public void selectAllOneBoardCntTest() {
		/*** Given ***/
		int bcode = 2;

		/*** When ***/
		int selectAllOneBoardCnt = boardDao.selectAllOneBoardCnt(bcode);
		/*** Then ***/
		assertEquals(4, selectAllOneBoardCnt);
	}

	// 해당 게시판의 댓글 조회
	@Test
	public void selectBoardReplyTest() {
		/*** Given ***/

		/*** When ***/

		/*** Then ***/
	}

	// 댓글 등록
	@Test
	public void replyWriteTest() {
		/*** Given ***/
		Date date = new Date();
		ReplyVo replyVo = new ReplyVo(0, 5, 0, "댓글테스트", "댓글작성자", date);

		/*** When ***/
		int replyWriteCnt = boardDao.replyWrite(replyVo);
		/*** Then ***/
		assertEquals(1, replyWriteCnt);
	}

}
