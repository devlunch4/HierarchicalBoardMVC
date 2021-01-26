package board.service;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import board.model.BoardVo;
import common.model.PageVo;

public class BoardServiceTest {
	private BoardServiceI boardService;

	@Before
	public void setup() {
		boardService = new BoardService();
	}

	// 게시판 수 호출
	@Test
	public void selectAllBoardTest() {
		/*** Given ***/
//			boardServiceI boardService = new boardService();

		/*** When ***/
		List<BoardVo> boardList = boardService.selectAllBoard();

		/*** Then ***/
		assertEquals(12, boardList.size());
	}

	// 게시판 생성
	@Test
	public void addBoardTest() {
		/*** Given ***/
//			boardServiceI boardService = new boardService();
		// 로그인을 해야만 승인이 된다
		BoardVo boardVo = new BoardVo("gogo", "테스트");

		/*** When ***/
		int addBoardTestCnt = boardService.addBoard(boardVo);

		/*** Then ***/
		assertEquals(1, addBoardTestCnt);

	}

	// 게시판 이름/활성상태 수정
	@Test
	public void updateBoardActTest() {
		/*** Given ***/
//			boardServiceI boardService = new boardService();
		BoardVo boardVo = new BoardVo(1, "테스트", 0);
		/*** When ***/
		int updateBoardActCnt = boardService.updateBoardAct(boardVo);

		/*** Then ***/
		assertEquals(1, updateBoardActCnt);
	}

	// 해당게시판의 글(답글개념) 가져오기
	@Test
	public void selectOneBoardTest() {
		/*** Given ***/
//			boardServiceI boardService = new boardService();
		int bcode = 1;

		/*** When ***/
		List<BoardVo> oneBoardList = boardService.selectOneBoard(bcode);

		/*** Then ***/
		assertEquals(11, oneBoardList.size());
	}

	// 게시판 글 생성/추가
	@Test
	public void boardWriteTest() {
		/*** Given ***/
		// boardServiceI boardService = new boardService();
		// BoardVo boardVo = new BoardVo(parentBcode, originno, groupord, grouplayer,
		// writer, title, content);
		BoardVo boardVo = new BoardVo(1, 1, 1, 0, "테스트", "테스트", "테스트");

		/*** When ***/
		int boardWriteCnt = boardService.boardWrite(boardVo);
		/*** Then ***/
		assertEquals(1, boardWriteCnt);

	}

	// 글 하나 조회
	@Test
	public void boardOneReadTest() {
		/*** Given ***/
		// boardServiceI boardService = new boardService();

		/*** When ***/
		// BoardVo boardVo = (BoardVo) boardService.boardOneRead(bcode);
		BoardVo boardVo = (BoardVo) boardService.boardOneRead(1);

		/*** Then ***/
		assertEquals(0, boardVo.getActive());
	}

	// 글 하나 수정
	@Test
	public void boardOneUpdateTest() {
		/*** Given ***/
		// boardServiceI boardService = new boardService();
		// BoardVo boardvo = new BoardVo(title, content, active, bcode);
		BoardVo boardvo = new BoardVo("테스트", "테스트", 0, 1);
		/*** When ***/
		int boardOneUpdateCnt = boardService.boardOneUpdate(boardvo);

		/*** Then ***/
		assertEquals(1, boardOneUpdateCnt);
	}

	// 페이징선택에 따른 게시글 조회
	@Test
	public void selectPagingBoardTest() {
		/*** Given ***/
		PageVo pagevo = new PageVo(2, 2, 2);
		/*** When ***/
		Map<String, Object> map = boardService.selectPagingBoard(pagevo);
		/*** Then ***/
		List<BoardVo> boardVo = (List<BoardVo>) map.get("boardList");
		int boardCnt = (int) map.get("boardCnt");
		assertEquals(2, boardVo.size());
		assertEquals(4, boardCnt);
	}

}
