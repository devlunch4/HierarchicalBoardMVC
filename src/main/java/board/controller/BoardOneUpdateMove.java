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

		int originno = Integer.parseInt(req.getParameter("originno"));

		if (userid.equals(writer)) {
			// 업데이트 수행

			// 변경될 정보
			// 제목.내용.활성화
			Date time = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String utime = dateFormat.format(time);

			String title = req.getParameter("title");
			String content = req.getParameter("summernote").trim() + "\n\n 수정시각" + utime;
		//	int active = Integer.parseInt(req.getParameter("active"));
			String activeValue =  req.getParameter("activeValue");
			int active =0;
			if(activeValue.equals("true")) {
				active = 0;
			}else {
				active = 1;
			}
			
			logger.debug(" 변경될 title값 : {}", title);
			logger.debug(" 변경될 summernote값 : {}", content);
			logger.debug(" 변경될 active값 : {}", active);

			BoardVo boardvo = new BoardVo(title, content, active, bcode);

			int boardOneUpdateCnt = boardService.boardOneUpdate(boardvo);
			if (boardOneUpdateCnt == 1) {
				logger.debug("게시글 {} 수정 완료", userid);
				resp.setContentType("text/html; charset=utf-8");
				PrintWriter out = resp.getWriter();
				out.println("<script>alert('게시글 수정이 완료 되었습니다.'); location.href='" + "/boardOneSelect?bcode=" + originno
						+ "';</script>");
				out.close();

			} else {
				resp.setContentType("text/html; charset=utf-8");
				PrintWriter out = resp.getWriter();
				out.println("<script>alert('오류가 발생되었습니다.'); location.href='" + "/boardOneSelect?bcode=" + originno
						+ "';</script>");
				out.close();
			}
		} else {
			// 알림창
			resp.setContentType("text/html; charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>alert('해당 작성자가 아닙니다.'); location.href='" + "/boardOneSelect?bcode=" + originno
					+ "';</script>");
			out.close();
			resp.sendRedirect(req.getContextPath() + "/boardOneSelect?bcode=" + originno);
		}

	}

}
