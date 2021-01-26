package board.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/boardOneUpdate")
public class BoardOneUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(BoardOneUpdate.class);
	private BoardServiceI boardService = new BoardService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("글 수정 버튼 클릭 doPost()");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		int bcode = Integer.parseInt(req.getParameter("bcode"));
		String userid = req.getParameter("userid");
		String writer = req.getParameter("writer");
		
if(userid.equals(writer)) {
	//업데이트 수행
	BoardVo boardvo
}
else{
	//알림창
	resp.setContentType("text/html; charset=utf-8");
	PrintWriter out = resp.getWriter();
	out.println("<script>alert('해당 작성자가 아닙니다');</script>");
	out.close();
}
		
	}

}
