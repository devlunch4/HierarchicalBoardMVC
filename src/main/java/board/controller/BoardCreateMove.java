package board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import board.model.BoardVo;
import board.service.BoardService;
import board.service.BoardServiceI;
import user.model.UserVo;

@WebServlet("/boardCreateMove")
public class BoardCreateMove extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(BoardCreateMove.class);
	private BoardServiceI boardService = new BoardService();

	// 로그인 또는 ~~ 후 화면으로 이동을 수행하는 메소드
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("In doGet()");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		// 조회된 게시판 리스트화
		List<BoardVo> boardList = boardService.selectAllBoard();
		req.setAttribute("boardList", boardList);
		logger.debug("조회된 list 목록 수 {}", boardList.size());
		req.getRequestDispatcher("/boardCreate.jsp").forward(req, resp);
	}

	// 게시판 생성/추가 버튼 반응시 수행하는 메소드
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("In doPost()");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		// 추가해야할 것은 게시판명, 게시판 생성자
		// 추가될 게시판명 가져오기
		String title = req.getParameter("addBName");
		// 세션의 아이디 가져오기
		HttpSession session = req.getSession();
		UserVo userVo = (UserVo) session.getAttribute("S_USER");
		// String writer = userVo.getUserid();
		String writer = null;
		try {
			writer = userVo.getUserid();
			logger.debug("session userid 값 : {}", writer);
		} catch (Exception e) {
			logger.debug("예외 발생 session 값 없음");
		}

		// 페이지의 아이디 파라미터사용시
		String userid = req.getParameter("userid");
		logger.debug("title 값 : {}", title);
		logger.debug("userid 값 : {}", userid);

		BoardVo boardVo = new BoardVo(writer, title);

		// int addBoard = boardService.addBoard(boardVo);
		if (writer == "" || writer == null || userVo == null) {
			// 로그인 정보가 없을시
			logger.debug("로그인 페이지로 이동>> userid값/userVo세션값 없음.");
			resp.setContentType("text/html; charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>alert('로그인을 해주세요'); location.href='" + "/login.jsp" + "';</script>");
			out.close();
		} else {
			int addBoardCnt = boardService.addBoard(boardVo);
			if (addBoardCnt == 1) {
				// 정상수행시
				logger.debug("addBoard 추가완료 정상수행");
				doGet(req, resp);
			} else {
				// 비정상 수행시
				logger.debug("addBoard 추가실패 비정상수행");
				doGet(req, resp);
			}
		}
	}

}
