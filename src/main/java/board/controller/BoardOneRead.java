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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid = req.getParameter("userid");
		int bcode = Integer.parseInt(req.getParameter("bcode"));
		String writer = req.getParameter("writer");
		logger.debug("userid: {} bcode: {} writer: {}", userid, bcode, writer);

		BoardVo boardVo = (BoardVo) boardService.boardOneRead(bcode);
		logger.debug(boardVo.getContent());
		
	}

}
