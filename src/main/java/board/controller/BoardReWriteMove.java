package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import board.model.BoardVo;
import board.service.BoardService;
import board.service.BoardServiceI;

@MultipartConfig
@WebServlet("/boardReWriteMove")
public class BoardReWriteMove extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(BoardWrite.class);
	private BoardServiceI boardService = new BoardService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("답글작성 doPost()");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		// 해당 글의 부모값 가져오기
		int parentbcode = Integer.parseInt(req.getParameter("bcode"));

		BoardVo parentBoardVo = boardService.boardOneRead(parentbcode);
		int reparentbcode = parentBoardVo.getBcode();
		req.setAttribute("parentBoardVo", parentBoardVo);
		req.setAttribute("parentbcode", parentbcode);
		logger.debug("부모 bcode 값:{}", reparentbcode);
		
		
		/*
		 * int originno = parentBoardVo.getOriginno(); int groupno
		 * =parentBoardVo.getGroupord(); int grouplayer = parentBoardVo.getGrouplayer();
		 */
		
		
		req.getRequestDispatcher("/boardRepWrite.jsp").forward(req, resp);
		//boardReBoardWrite.jsp
		
		//입력값. 
		//그대로 seq,원글번호 원글그룹,
		
		//추가값. 레이어+1
		
		

	}
}
