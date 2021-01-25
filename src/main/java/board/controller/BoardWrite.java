package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/boardWrite")
public class BoardWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(BoardWrite.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("글쓰기 summernote doGet()");		
		String bcode = req.getParameter("bcode");
		int ibcode = Integer.parseInt(bcode);
		logger.debug("ibcode 값: {}", ibcode);
		req.setAttribute("parentBcode", ibcode);
			
		req.getRequestDispatcher("/boardWrite.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bcode = req.getParameter("bcode");
		int ibcode = Integer.parseInt(bcode);
		// 그외 정보
//		String originno = req.getParameter("originno");
//		int ioriginno = Integer.parseInt(originno);
//		String groupord = req.getParameter("groupord");
//		int igroupord = Integer.parseInt(groupord);
//		String grouplayer = req.getParameter("grouplayer");
//		int igrouplayer = Integer.parseInt(grouplayer);
//		String writer = req.getParameter("writer");

		logger.debug("ibcode 값: {}", ibcode);
//		logger.debug("ioriginno 값: {}", ioriginno);
//		logger.debug("igroupord 값: {}", igroupord);
//		logger.debug("igrouplayer 값: {}", igrouplayer);
//		logger.debug("writer 값: {}", writer);
		
		req.setAttribute("parentBcode", ibcode);
		
		
		req.getRequestDispatcher("/boardOneSelect.jsp").forward(req, resp);
	}
}
