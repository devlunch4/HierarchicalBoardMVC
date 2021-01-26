package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/replyWrite")
public class ReplyWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(ReplyWrite.class);

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("댓글 작성 버튼 클릭 doPost()");

		//댓글작성자
		String userid = req.getParameter("userid");
		//댓글의 원본 bcode(게시판+게시판글)
		int bcode = Integer.parseInt(req.getParameter("bcode"));
		//댓글의 내용
		String replycontext = req.getParameter("replycontext");
		

	}

}
