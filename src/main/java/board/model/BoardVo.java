package board.model;

import java.util.Date;

//게시판 및 게시글
public class BoardVo {

	private int bcode; // 게시글 번호 PK
	private int originno; // 원글번호
	private int groupord; // 그룹순서
	private int grouplayer; // 그룹계층
	private int active; // 활성화
	private String title; // 제목
	private String content; // 내용
	private String writer; // 작성자
	private Date reg_datetime; // 날짜시간

	public BoardVo() {
	}

	// 새로운 게시판 생성시 사용
	public BoardVo(String writer, String title) {
		this.writer = writer;
		this.title = title;
	}

	// 게시판명,활성상태 수정시 사용
	public BoardVo(int bcode, String title, int active) {
		this.bcode = bcode;
		this.title = title;
		this.active = active;
	}
	
	// 글 등록시 사용
	public BoardVo(int bcode, int originno, int groupord, int grouplayer, String writer, String title, String content) {
		this.bcode = bcode;
		this.originno = originno;
		this.groupord = groupord;
		this.grouplayer = grouplayer;
		this.writer = writer;
		this.title = title;
		this.content = content;
	}
	
	//글 수정시 사용
	public BoardVo (String title, String content, int active, int bcode) {
		this.title = title;
		this.content = content;
		this.active = active;
		this.bcode = bcode;
	}
	

	public int getBcode() {
		return bcode;
	}

	public void setBcode(int bcode) {
		this.bcode = bcode;
	}

	public int getOriginno() {
		return originno;
	}

	public void setOriginno(int originno) {
		this.originno = originno;
	}

	public int getGroupord() {
		return groupord;
	}

	public void setGroupord(int groupord) {
		this.groupord = groupord;
	}

	public int getGrouplayer() {
		return grouplayer;
	}

	public void setGrouplayer(int grouplayer) {
		this.grouplayer = grouplayer;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getReg_datetime() {
		return reg_datetime;
	}

	public void setReg_datetime(Date reg_datetime) {
		this.reg_datetime = reg_datetime;
	}

}
