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

	// 클쓰기 버튼 클릭시
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("글쓰기 summernote doGet()");
		String bcode = req.getParameter("bcode");
		int ibcode = Integer.parseInt(bcode);
		logger.debug("ibcode 값: {}", ibcode);
		req.setAttribute("parentBcode", ibcode);

		req.getRequestDispatcher("/boardWrite.jsp").forward(req, resp);

	}

	// 글작성완료 버튼 클릭시
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("IN doPost()");
		// String bcode = req.getParameter("bcode");
		// int ibcode = Integer.parseInt(bcode);

		// bcode 시퀀스 자동. >> originno 설정용
		String parentBcode = req.getParameter("parentBcode");
		int iparentBcode = Integer.parseInt(parentBcode);

		// originno 설정
		// String originno = req.getParameter("originno");
		int ioriginno = iparentBcode;

		// groupord 게시판의 list.size를 활용
		List<BoardVo> oneBoardList = boardService.selectOneBoard(iparentBcode);
		// String groupord = req.getParameter("groupord");
		int igroupord = oneBoardList.size() + 1;

		// grouplayer 무조건 1
		// String grouplayer = req.getParameter("grouplayer");
		int igrouplayer = 1;

		// 글쓴이
		String writer = req.getParameter("userid");
		String title = req.getParameter("title");
		// 작성글
		String content = req.getParameter("summernote");

		logger.debug("iparentBcode 및 ioriginno 값: {}", ioriginno);
		logger.debug("igroupord 값: {}", igroupord);
		logger.debug("igrouplayer 값: {}", igrouplayer);
		logger.debug("writer 값: {}", writer);
		logger.debug("title 값: {}", title);
		logger.debug("content 값: {}", content);

		req.setAttribute("parentBcode", iparentBcode);
		req.setAttribute("bcode", iparentBcode);

		// 글 등록용 vo 객체 생성
		BoardVo boardVo = new BoardVo(iparentBcode, ioriginno, igroupord, igrouplayer, writer, title, content);

		int boardWriteCnt = boardService.boardWrite(boardVo);
		if (boardWriteCnt == 1) {
			// 정상수행
			logger.debug("BoardWrite 정상수행");
			resp.sendRedirect(req.getContextPath() + "/boardOneSelect?bcode="+iparentBcode);
		} else {
			// 비정상수행
			logger.debug("BoardWrite 비정상수행");
			req.getRequestDispatcher("/boardWrite").forward(req, resp);
		}
	}
}
