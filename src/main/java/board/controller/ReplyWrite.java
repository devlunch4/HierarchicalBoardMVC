package board.controller;

import java.io.IOException;
import java.util.Date;
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

@WebServlet("/replyWrite")
public class ReplyWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(ReplyWrite.class);
	private BoardServiceI boardService = new BoardService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("댓글 작성 버튼 클릭 doPost()");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		List<BoardVo> boardList = boardService.selectAllBoard();
		req.setAttribute("boardList", boardList);

		// 댓글 입력값 설정
		int seqRcodeAuto = 0;
		// 필요 정보
		// 원글replyBcode ok
		int replyBcode = Integer.parseInt(req.getParameter("replyBcode"));
		// 활성값 replyActive 0 set in jsp
		int replyActive = Integer.parseInt(req.getParameter("replyActive"));
		// 내용 replyContent ok
		String replyContent = req.getParameter("replyContent");
		// 작성자 replyWriter ok
		String replyWriter = req.getParameter("replyWriter");
		// 날짜 servlet auto
		Date date = new Date();

		ReplyVo replyVo = new ReplyVo(seqRcodeAuto, replyBcode, replyActive, replyContent, replyWriter, date);

		// 원글 정보 가져오기
		BoardVo boardVo = (BoardVo) boardService.boardOneRead(replyBcode);

		int replyWriteCnt = boardService.replyWrite(replyVo);
		if (replyWriteCnt == 1) {
			// 정상수행
			logger.debug("BoardWrite 정상수행");

			// 댓글 리스트 설정(업데이트된.)
			List<ReplyVo> replyList = boardService.selectBoardReply(replyBcode);
			// 해당 게시글 하나의 정보 세팅
			req.setAttribute("boardVo", boardVo);
			// 해당 게시글에 대한 댓글들 출력
			req.setAttribute("replyList", replyList);
			logger.debug("해당글 Bcode 값 :{}", boardVo.getBcode());
			// 전송
			req.getRequestDispatcher("/boardOneRead.jsp").forward(req, resp);

		} else {
			// 비정상수행
			logger.debug("BoardWrite 비정상수행");
			resp.sendRedirect(req.getContextPath() + "/boardOneSelect?bcode=" + boardVo.getOriginno());
		}

	}

}
