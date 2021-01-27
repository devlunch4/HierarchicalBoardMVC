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

@WebServlet("/boardOneSelect")
public class BoardOneSelect extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(BoardOneSelect.class);
	private BoardServiceI boardService = new BoardService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("IN doGet()");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		// 선택된 게시판의 bcode == 게시판 번호
		String bcode = req.getParameter("bcode");
		int ibcode = Integer.parseInt(bcode);

		// 사이드바를 위한 모든 게시판 조회
		List<BoardVo> boardList = boardService.selectAllBoard();
		req.setAttribute("boardList", boardList);
		logger.debug("조회된 전체 list 목록 수 {}", boardList.size());

		// 선택된 게시판의 게시글(답글들) 조회
		List<BoardVo> oneBoardList = boardService.selectOneBoard(ibcode);

		//전송될 객설정
		
		BoardVo boardVo = (BoardVo) boardService.boardOneRead(ibcode);
		String title = boardVo.getTitle();
		
		req.setAttribute("boardtitle", title);
		req.setAttribute("oneBoardList", oneBoardList);
		req.setAttribute("bcode", bcode);
		req.getRequestDispatcher("/boardOneSelect.jsp").forward(req, resp);
	}
}
