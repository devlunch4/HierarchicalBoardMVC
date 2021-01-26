package board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

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

@WebServlet("/boardOneUpdateMove")
public class BoardOneUpdateMove extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(BoardOneUpdateMove.class);
	private BoardServiceI boardService = new BoardService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("글 수정 버튼 후 페이지 이동 doPost()");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		int bcode = Integer.parseInt(req.getParameter("bcode"));
		String userid = req.getParameter("userid");
		String writer = req.getParameter("writer");
		logger.debug("bcode: {}", bcode);
		logger.debug("userid: {}", userid);
		logger.debug("writer: {}", writer);

		// 하나의 정보를 확인
		BoardVo boardVo = (BoardVo) boardService.boardOneRead(bcode);

			req.setAttribute("boardVo", boardVo);
			logger.debug(boardVo.getContent());
			// 전송
			req.getRequestDispatcher("/boardOneUpdate.jsp").forward(req, resp);

	}
}
