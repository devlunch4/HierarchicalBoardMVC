package board.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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
import common.model.PageVo;
import user.model.UserVo;

//리스트 출력시 페이징 처리를 위한 서블릿
@WebServlet("/pagingBoard")
public class PagingBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(PagingBoard.class);
	private BoardServiceI boardService = new BoardService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		logger.debug("doGet() 진입완료");
		// 파라미터 설정
		String pageParam = req.getParameter("page");
		String pageSizeParam = req.getParameter("pagesize");
		int bcode = Integer.parseInt(req.getParameter("bcode"));

		// 사이드바를 위한 모든 게시판 조회
		List<BoardVo> boardList = boardService.selectAllBoard();
		req.setAttribute("boardList", boardList);
		logger.debug("조회된 전체 list 목록 수 {}", boardList.size());

		
		// 페이징 처리를 위한 설정
		// 삼항연산자를 통한 null값 처리
		int page = pageParam == null ? 1 : Integer.parseInt(pageParam);
		int pagesize = pageSizeParam == null ? 10 : Integer.parseInt(pageSizeParam);

		// 페이징 객체 선언
		PageVo pagevo = new PageVo(page, pagesize, bcode);

		// 조회된 페이지 정보를 맵에 설정
		Map<String, Object> map = boardService.selectPagingBoard(pagevo);

		// 서비스에서 생성되어 현 클래스내 설정된 맵의 키값인 "userList" 값을 List화
		List<BoardVo> oneBoardList = (List<BoardVo>) map.get("boardList");

		// 서비스에서 생성되어 현 클래스내 설정된 맵의 키값인 "userCnt"를 값을 int화
		int boardCnt = (int) map.get("boardCnt");

		// 위에서 구한 값을 통한 연산 및 올림
		int pagination = (int) Math.ceil((double) boardCnt / pagesize);

		logger.debug("boardCnt 값 : {}, pagination 값 : {}", boardCnt, pagination);

		// req 설정
		req.setAttribute("oneBoardList", oneBoardList);
		req.setAttribute("pagination", pagination);
		req.setAttribute("pagevo", pagevo);
		req.setAttribute("bcode", bcode);

		// 송신
		req.getRequestDispatcher("/boardOneSelectPage.jsp").forward(req, resp);
	}
}
