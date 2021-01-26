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
import user.service.UserService;
import user.service.UserServiceI;

// web.xml에 설정하는 servlet, servlet-mapping을 어노테이션을 통해 설정하는 방법
@WebServlet("/main")
public class MainMove extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(MainMove.class);
	private UserServiceI userService = new UserService();
	private BoardServiceI boardService = new BoardService();

	// 메인페이지 이동
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("doPost()");

		logger.debug("메인페이지 진입");
		// 조회된 게시판 리스트화
		List<BoardVo> boardList = boardService.selectAllBoard();
		req.setAttribute("boardList", boardList);
		logger.debug("조회된 전체 list 목록 수 {}", boardList.size());

//			req.setAttribute("pass", pass);
//			req.getRequestDispatcher("/pagingUser").forward(req, resp);
//			resp.sendRedirect(req.getContextPath() + "/boardmain.jsp");
		req.getRequestDispatcher("/main.jsp").forward(req, resp);
//			resp.sendRedirect(req.getContextPath() + "/boardmain.jsp");
	}

}
