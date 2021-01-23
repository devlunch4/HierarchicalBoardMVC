package board.model;

import java.util.Date;

public class FileVo {

	private int fcode; //파일번호
	private int bcode; //원글번호
	private int originno; //그룹
	private int groupord; //그룹순서
	private int grouplayer; //그룹계층
	private int active; //활성
	private String fname; //파일명
	private String fextension; //파일확장자
	private String writer; //작성자
	private Date reg_datetime; //생성일

	public int getFcode() {
		return fcode;
	}

	public void setFcode(int fcode) {
		this.fcode = fcode;
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

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFextension() {
		return fextension;
	}

	public void setFextension(String fextension) {
		this.fextension = fextension;
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
