package board.model;

import java.util.Date;

//댓글
public class ReplyVo {

	private int rcode; // 댓글 번호 PK
	private int bcode; // 게시판 및 게시글 번호 FK
	private int active; // 활성
	private String content; // 댓글 내용
	private String writer; // 작성자
	private Date reg_datetime; // 작성일

	public int getRcode() {
		return rcode;
	}

	public void setRcode(int rcode) {
		this.rcode = rcode;
	}

	public int getBcode() {
		return bcode;
	}

	public void setBcode(int bcode) {
		this.bcode = bcode;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
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
