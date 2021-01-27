package board.model;

import java.util.Date;

public class FileVo {

	private int fcode; // 파일번호
	private int bcode; // 원글번호
	private int active; // 활성
	private String fname; // 파일명
	private String fextension; // 파일확장자
	private String writer; // 작성자
	private Date reg_datetime; // 생성일
	private String fclob; // 저장파일

	
	
	
	public FileVo(int fcode, int bcode, int active, String fname, String fextension, String writer, Date reg_datetime,
			String fclob) {
		super();
		this.fcode = fcode;
		this.bcode = bcode;
		this.active = active;
		this.fname = fname;
		this.fextension = fextension;
		this.writer = writer;
		this.reg_datetime = reg_datetime;
		this.fclob = fclob;
	}

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

	public String getFclob() {
		return fclob;
	}

	public void setFclob(String fclob) {
		this.fclob = fclob;
	}
}
