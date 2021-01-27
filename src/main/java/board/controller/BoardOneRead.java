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
import board.model.ReplyVo;
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
		
		
		//댓글 관련 시작
		List<ReplyVo> replyList = boardService.selectBoardReply(bcode);
		logger.debug("댓글 목록내 댓글 수 : {}", replyList.size());
		

		if (boardVo.getActive() == 1) {
			resp.sendRedirect(req.getContextPath() + "/boardOneSelect?bcode=" + boardVo.getOriginno());
		} else {
//해당 게시글 하나의 정보 세팅
			req.setAttribute("boardVo", boardVo);
			
			//해당 게시글에 대한 댓글들 출력
			req.setAttribute("replyList", replyList);
			
			logger.debug(boardVo.getContent());
			// 전송
			req.getRequestDispatcher("/boardOneRead.jsp").forward(req, resp);

		}
	}

}
