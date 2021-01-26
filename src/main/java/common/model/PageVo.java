package common.model;

//페이징 처리를 위한 VO 객체
public class PageVo {
	private int page;
	private int pageSize;
	private int bcode;

	public PageVo() {
	}

	public PageVo(int page, int pageSize, int bcode) {
		this.page = page;
		this.pageSize = pageSize;
		this.bcode = bcode;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getBcode() {
		return bcode;
	}

	public void setBcode(int bcode) {
		this.bcode = bcode;
	}

	
}
