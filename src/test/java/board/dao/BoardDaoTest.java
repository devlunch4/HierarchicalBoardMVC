package board.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import board.model.BoardVo;
import board.repository.BoardDao;
import board.repository.BoardDaoI;

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
	//	BoardDaoI boardDao = new BoardDao();
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
	//	BoardDaoI boardDao = new BoardDao();

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
		//BoardDaoI boardDao = new BoardDao();
		//BoardVo boardvo = new BoardVo(title, content, active, bcode);
		BoardVo boardvo = new BoardVo("테스트","테스트", 0, 1);
		/*** When ***/
		int boardOneUpdateCnt = boardDao.boardOneUpdate(boardvo);
		
		/*** Then ***/
		assertEquals(1, boardOneUpdateCnt);
	}

}
