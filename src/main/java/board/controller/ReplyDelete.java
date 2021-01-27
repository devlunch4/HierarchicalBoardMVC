package board.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

@WebServlet("/replyDelete")
public class ReplyDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(ReplyDelete.class);
	private BoardServiceI boardService = new BoardService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("댓글 삭제(수정) 버튼 클릭 doPost()");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		List<BoardVo> boardList = boardService.selectAllBoard();
		req.setAttribute("boardList", boardList);

		// 댓글 입력값 설정
		// 필요 정보
		// 원댓글replyRcode ok
		int replyRcode = Integer.parseInt(req.getParameter("replyRcode"));
		// 활성값 replyActive 0 set in jsp
		int replyActive = Integer.parseInt(req.getParameter("replyActive"));
		Date date = new Date();

		// 실제 댓글 삭제시 사용되는 파라미터는 rcode 와 active
		ReplyVo replyVo = new ReplyVo(replyRcode, 0, replyActive, "0", "0", date);

		int replyBcode = Integer.parseInt(req.getParameter("replyBcode"));
		// 원글 정보 가져오기
		BoardVo boardVo = (BoardVo) boardService.boardOneRead(replyBcode);
		

		// 삭제 >. 실제론 활성화 값 변경
		int replyDeleteCnt = boardService.replyDelete(replyVo);

		/*
		 * // 시간 지연 수행 try {
		 * logger.debug("시간지연 수행---------------------------------------------------");
		 * // 2초 TimeUnit.SECONDS.sleep(2); // delay 0.5 second //
		 * TimeUnit.MICROSECONDS.sleep(500); // delay 1 minute //
		 * TimeUnit.MINUTES.sleep(1); } catch (InterruptedException e) {
		 * System.err.format("IOException: %s%n", e); }
		 */
		if (replyDeleteCnt == 1) {
			// 정상수행
			logger.debug("BoardWrite 정상수행");

			// 해당 게시글 하나의 정보 세팅
			req.setAttribute("boardVo", boardVo);
			// 해당 게시글에 대한 댓글들 출력
			// 댓글 리스트 설정(업데이트된.)
			List<ReplyVo> replyList = boardService.selectBoardReply(replyBcode);
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
