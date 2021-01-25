package user.login.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import user.service.UserService;
import user.service.UserServiceI;

// web.xml에 설정하는 servlet, servlet-mapping을 어노테이션을 통해 설정하는 방법
@WebServlet("/loginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	private UserServiceI userService = new UserService();
	private BoardServiceI boardService = new BoardService();

	// 요청 메소드와 관련없이 서블릿이 동작하게 하려면
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("doPost()");

		// input 입력 값 가져오기
		String userid = req.getParameter("userid");
		String pass = req.getParameter("pass");
		// 조회된 정보 UserVo 객체에 담기
		UserVo user = userService.selectUser(userid);

		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date time = new Date();

		String logintime = format1.format(time);
		logger.debug(logintime);

		// 로그인 성공 ==> service를 통해 데이터베이스에 저장된 값과 일치할떄
		// session에 데이터 베이스를 조회한 사용자 정보를 (userVo)를 저장
		if (user != null && pass.equals(user.getPass())) {
			logger.debug("로그인 성공 >> 메인페이지 진입");

			HttpSession session = req.getSession();
			session.setAttribute("S_USER", user);
			session.setAttribute("logintime", logintime);
			
			req.setAttribute("userid", userid);
			
			// 조회된 게시판 리스트화
			List<BoardVo> boardList = boardService.selectAllBoard();
			req.setAttribute("boardList", boardList);
			logger.debug("조회된 전체 list 목록 수 {}", boardList.size());
			
			
//			req.setAttribute("pass", pass);
//			req.getRequestDispatcher("/pagingUser").forward(req, resp);
//			resp.sendRedirect(req.getContextPath() + "/boardmain.jsp");
			req.getRequestDispatcher("/main.jsp").forward(req, resp);
//			resp.sendRedirect(req.getContextPath() + "/boardmain.jsp");

		}
		// 로그인 실패
		else {
			logger.debug("로그인 실패 >> 메인페이지 불가");
			resp.setContentType("text/html; charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>alert('아이디/비밀번호를 확인하세요'); location.href='" + "/login.jsp" + "';</script>");
			out.close();
			// resp.sendRedirect(req.getContextPath() + "/login.jsp");
		}
	}
}
