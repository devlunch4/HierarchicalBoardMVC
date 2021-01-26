package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import board.model.BoardVo;
import board.service.BoardService;
import board.service.BoardServiceI;

@WebServlet("/boardWrite")
public class BoardWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(BoardWrite.class);
	private BoardServiceI boardService = new BoardService();

	// 글쓰기 버튼 클릭시
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("글쓰기 버튼클릭 진입 doGet()");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String bcode = req.getParameter("bcode");
		int ibcode = Integer.parseInt(bcode);
		logger.debug("ibcode 값: {}", ibcode);
		req.setAttribute("parentBcode", ibcode);

		req.getRequestDispatcher("/boardWrite.jsp").forward(req, resp);

	}

	// 글작성완료 버튼 클릭시
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("글작성완료 버튼 클릭 doPost()");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		// String bcode = req.getParameter("bcode");
		// int ibcode = Integer.parseInt(bcode);

		// bcode 시퀀스 자동. >> originno 설정용
		int parentBcode = Integer.parseInt(req.getParameter("parentBcode"));

		// originno 설정
		// String originno = req.getParameter("originno");
		int originno = parentBcode;

		// groupord 게시판의 list.size를 활용
		List<BoardVo> oneBoardList = boardService.selectOneBoard(originno);

		// jsp 설정 가져옴
		int groupord = Integer.parseInt(req.getParameter("groupord"));

		if (groupord == 0) {
			groupord = oneBoardList.size() + 1;
		}

		// grouplayer 게시판의 첫글 글 작성시 layer무조건 =1 >> jsp 에서 설정함.
		int grouplayer = Integer.parseInt(req.getParameter("grouplayer"));

		// 글쓴이
		String writer = req.getParameter("userid");
		String title = req.getParameter("title");

		// 작성글
		String content = req.getParameter("summernote").trim();

		// 확인 로거
		logger.debug("parentBcode : {}", parentBcode);
		logger.debug("originno 값: {}", originno);
		logger.debug("groupord 값: {}", groupord);
		logger.debug("grouplayer 값: {}", grouplayer);
		logger.debug("writer 값: {}", writer);
		logger.debug("title 값: {}", title);
		logger.debug("content 값: {}", content);

		req.setAttribute("parentBcode", parentBcode);
		req.setAttribute("bcode", parentBcode);

		// 글 등록용 vo 객체 생성
		BoardVo boardVo = new BoardVo(parentBcode, originno, groupord, grouplayer, writer, title, content);

		int boardWriteCnt = boardService.boardWrite(boardVo);
		if (boardWriteCnt == 1) {
			// 정상수행
			logger.debug("BoardWrite 정상수행");
			resp.sendRedirect(req.getContextPath() + "/boardOneSelect?bcode=" + parentBcode);
		} else {
			// 비정상수행
			logger.debug("BoardWrite 비정상수행");
			req.getRequestDispatcher("/boardWrite").forward(req, resp);
		}
	}
}
