package com.ssafy.paging.model;

//페이징 관련 데이터 처리 클래스
public class PageResult {
	
	private int pageNo;
	private int count;

	private int tabSize;
	private int listSize;
	private int curTab;
	private int beginPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	
	public int getPageNo() {
		return pageNo;
	}

	public int getCount() {
		return count;
	}

	public int getTabSize() {
		return tabSize;
	}

	public int getListSize() {
		return listSize;
	}

	public int getCurTab() {
		return curTab;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}

	public PageResult(int pageNo, int count) {
		this(pageNo, count, 10, 10);
	}
	
	public PageResult(int pageNo, int count, int listSize, int tabSize) {
		this.pageNo = pageNo;
		this.count = count;
		this.listSize = listSize;
		this.tabSize = tabSize;
		
		
		int lastPage = (int)Math.ceil(count / 10d);
		
		this.curTab = (pageNo) / tabSize + 1;
		this.beginPage = (curTab - 1) * tabSize + 1;
		this.endPage = (curTab * tabSize > lastPage) ? lastPage : curTab * tabSize;
		
		boolean prev = (beginPage != 1);
		boolean next = (endPage != lastPage);
		
		
	}
	
}
