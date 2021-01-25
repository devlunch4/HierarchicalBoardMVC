package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/boardActUpdate")
public class BoardActUpdate extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(BoardActUpdate.class);

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("IN doPost()");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		// 게시판 번호
		String bcode = req.getParameter("bcode");
		// 활성 값
		String active = req.getParameter("active");
		int iactive = Integer.parseInt(active);
		logger.debug("bcode 값: {}", bcode);
		logger.debug("iactive값: {}", iactive);

		resp.sendRedirect(req.getContextPath() + "/boardCreateMove");
	}
}
