package board.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import board.model.BoardVo;
import board.model.FileVo;
import board.service.BoardService;
import board.service.BoardServiceI;
import util.FileUtil;

@MultipartConfig
@WebServlet("/boardWrite")
public class BoardWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(BoardWrite.class);
	private BoardServiceI boardService = new BoardService();

	// 글쓰기 버튼 클릭시
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("글쓰기 버튼클릭 진입 doGet()");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String bcode = req.getParameter("bcode");
		int ibcode = Integer.parseInt(bcode);
		logger.debug("ibcode 값: {}", ibcode);
		req.setAttribute("parentBcode", ibcode);

		req.getRequestDispatcher("/boardWrite.jsp").forward(req, resp);

	}

	// 글작성완료 버튼 클릭시
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("글작성완료 버튼 클릭 doPost()");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		// String bcode = req.getParameter("bcode");
		// int ibcode = Integer.parseInt(bcode);

		// bcode 시퀀스 자동. >> originno 설정용
		int parentBcode = Integer.parseInt(req.getParameter("parentBcode"));

		// originno 설정
		// String originno = req.getParameter("originno");
		int originno = parentBcode;

		// groupord 게시판의 list.size를 활용
		List<BoardVo> oneBoardList = boardService.selectOneBoard(originno);

		// jsp 설정 가져옴
		int groupord = Integer.parseInt(req.getParameter("groupord"));

		if (groupord == 0) {
			groupord = oneBoardList.size() + 1;
		}

		// grouplayer 게시판의 첫글 글 작성시 layer무조건 =1 >> jsp 에서 설정함.
		int grouplayer = Integer.parseInt(req.getParameter("grouplayer"));

		// 글쓴이
		String writer = req.getParameter("userid");
		String title = req.getParameter("title");

		// 작성글
		String content = req.getParameter("summernote").trim();

		// 확인 로거
		logger.debug("parentBcode : {}", parentBcode);
		logger.debug("originno 값: {}", originno);
		logger.debug("groupord 값: {}", groupord);
		logger.debug("grouplayer 값: {}", grouplayer);
		logger.debug("writer 값: {}", writer);
		logger.debug("title 값: {}", title);
		logger.debug("content 값: {}", content);

		req.setAttribute("parentBcode", parentBcode);
		req.setAttribute("bcode", parentBcode);

		// 글 등록용 vo 객체 생성
		BoardVo boardVo = new BoardVo(parentBcode, originno, groupord, grouplayer, writer, title, content);

		// 파일관련 설정
		Part file1 = req.getPart("file1");
		String filename = "";
		String realFileName = "";
		String fileExtension = "";
		String fclob = "";
		Date date = new Date();
		int seqfthis = 0; // SEQ_HFILE.NEXTVAL
		int seqbnow = 0; // 게시글 입력후 가져오기 SEQ_HBOARD.CURRVAL
		if (file1.getSize() > 0) {
			filename = FileUtil.getFileName(file1.getHeader("Content-Disposition"));
			fileExtension = FileUtil.getFileExtension(filename);
			// brown / bronw.png ?? 확장자 뒤의 "." 처리를 FileUtil.getFileExtension return 값에서 처리함
			realFileName = UUID.randomUUID().toString() + fileExtension;
			// 저장위치 지정
			// file1.write("d:\\upload\\" + realFileName);
		}
		logger.debug("filename:{}, realFileName;{}", filename, realFileName);

		int boardWriteCnt = boardService.boardWrite(boardVo);

		// SEQ_HFILE.NEXTVAL
		// 게시글 입력후 가져오기 SEQ_HBOARD.CURRVAL
		FileVo fileVo = new FileVo(seqfthis, seqbnow, 0, filename, fileExtension, writer, date, fclob);
		logger.debug("BoardWrite 정상수행");

		// 파일테이블 입력
		int insertFileCnt = boardService.insertFile(fileVo);
		if (insertFileCnt == 1) {
			logger.debug("BoardWrite 정상수행");
		} else {
			logger.debug("BoardWrite 비정상수행");
		}
		if (boardWriteCnt == 1 && insertFileCnt == 1) {
			// 정상수행
			// 글작성-파일테이블 정상 수행 후
			resp.sendRedirect(req.getContextPath() + "/boardOneSelect?bcode=" + parentBcode);

		} else {
			// 비정상수행
			logger.debug("BoardWrite 비정상수행");
			req.getRequestDispatcher("/boardWrite").forward(req, resp);
		}
	}
}
