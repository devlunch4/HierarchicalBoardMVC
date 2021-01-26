package board.controller;

import java.io.IOException;

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

@WebServlet("/readOneBoard")
public class BoardOneRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(BoardOneRead.class);
	private BoardServiceI boardService = new BoardService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("");
		logger.debug("글 읽기 진입doGet()");

		int bcode = Integer.parseInt(req.getParameter("bcode"));
		String userid = req.getParameter("userid");
		String writer = req.getParameter("writer");
		logger.debug("bcode: {}", bcode);
		logger.debug("userid: {}", userid);
		logger.debug("writer: {}", writer);

		// 하나의 정보를 확인
		BoardVo boardVo = (BoardVo) boardService.boardOneRead(bcode);

		if (boardVo.getActive() == 1) {
			resp.sendRedirect(req.getContextPath() + "/boardOneSelect?bcode=" + boardVo.getOriginno());
		} else {

			req.setAttribute("boardVo", boardVo);
			logger.debug(boardVo.getContent());
			// 전송
			req.getRequestDispatcher("/boardOneRead.jsp").forward(req, resp);

		}
	}

}
