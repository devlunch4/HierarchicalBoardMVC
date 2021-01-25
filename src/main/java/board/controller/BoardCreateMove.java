package board.controller;

import java.io.IOException;
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

@WebServlet("/boardCreateMove")
public class BoardCreateMove extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(BoardCreateMove.class);
	private BoardServiceI boardService = new BoardService();

	// 로그인 또는 ~~ 후 화면으로 이동을 수행하는 메소드
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("In doGet()");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		
		
		/*
		 * HttpSession session = req.getSession(); session.getAttribute("S_USER");
		 */
		

		// 조회된 게시판 리스트화
		List<BoardVo> boardList =  boardService.selectAllBoard();
		req.setAttribute("boardList", boardList);
		logger.debug("조회된 list 목록 수 {}", boardList.size());
		req.getRequestDispatcher("/boardCreate.jsp").forward(req, resp);

	}

	
//	  // 버튼 반응시 수행하는 메소드
//	  
//	  @Override protected void doPost(HttpServletRequest req, HttpServletResponse
//	  resp) throws ServletException, IOException { logger.debug("In doPost()");
//	  req.setCharacterEncoding("UTF-8"); resp.setCharacterEncoding("UTF-8");
//	  
//	  //추가될 게시판의 이름 가져오기 String addBoardName = req.getParameter("addBoardName");
//	  logger.debug("addBoardName 값 : {}",addBoardName);
//	  
//	  
//	  
//	  HttpSession session = req.getSession(); session.getAttribute("S_USER");
//	  
//	  
//	  req.getRequestDispatcher("/boardCreate.jsp").forward(req, resp);
//	  
//	  // 기본값 가져오기 String userid = req.getParameter("userid"); // 입력 값 가져오기 String
//	  addBoardName = req.getParameter("addBoardName");
//	  
//	  BoardVo boardVo = new BoardVo(userid, addBoardName);
//	  
//	  if (userid == "" || addBoardName == "") { req.setAttribute("boardVo",
//	  boardVo); doGet(req, resp); }
//	  
//	  // 게시판 생성 초기 입력
//	  }
	 
}
