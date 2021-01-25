package board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import board.model.BoardVo;
import board.service.BoardService;
import board.service.BoardServiceI;
import user.model.UserVo;

@WebServlet("/boardActUpdate")
public class BoardActUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(BoardActUpdate.class);
	private BoardServiceI boardServie = new BoardService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("IN doPost()");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		// 세션의 아이디 가져오기
		HttpSession session = req.getSession();
		UserVo userVo = (UserVo) session.getAttribute("S_USER");
		// String writer = userVo.getUserid();

		if (userVo == null) {
			// 세션아이디가 없는 경우 로그인 페이지로 이동
			// resp.sendRedirect(req.getContextPath() + "/login.jsp");
			logger.debug("로그인 페이지로 이동>> userid값/userVo세션값 없음.");
			resp.setContentType("text/html; charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>alert('로그인을 해주세요'); location.href='" + "/login.jsp" + "';</script>");
			out.close();
		} else {
			// 세션에서 아이디 가져오기
			String writer = userVo.getUserid();
			logger.debug("session userid 값 : {}", writer);
			// 페이지에서 아이디 가져오기
			// String userid = req.getParameter("userid");

			// 게시판 번호 가져오기
			String bcode = req.getParameter("bcode");
			int ibcode = Integer.parseInt(bcode);
			// 게시판 명 가져오기
			String title = req.getParameter("title");
			// 활성 값 가져오기
			String active = req.getParameter("active");
			int iactive = Integer.parseInt(active);

			logger.debug("bcode 값: {}", bcode);
			logger.debug("title 값: {}", title);
			logger.debug("iactive값: {}", iactive);

			logger.debug("writer값: {}", writer);

			BoardVo boardVo = new BoardVo(ibcode, title, iactive);
			// 수정 dao 시행
			int boardActUpdateCnt = boardServie.updateBoardAct(boardVo);
			if (boardActUpdateCnt == 1) {
				// 정상 수행시
				// 방법 2: resp.sendRedirect 사용
				logger.debug("게시판명/활성상태 수정 완료");
				resp.sendRedirect(req.getContextPath() + "/boardCreateMove");
			} else {
				// 비정상 수행시
				// 방법1 : doGet 으로 넘기기
				doGet(req, resp);
			}
			// resp.sendRedirect(req.getContextPath() + "/boardCreateMove");
		}
	}
}
