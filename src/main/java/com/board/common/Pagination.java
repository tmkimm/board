package com.board.common;

public class Pagination {
	private int listSize = 10;    // 한 페이지에 보여질 리스트 개수
	private int rangeSize = 10;   // 한번에 보여지는 페이지 개수
	private int page;			  // 현재 페이지
	private int range;			  // 현재 각 페이지 범위 시작 번호
	private int listCnt;		  // 전체 리스트 수
	private int pageCnt;		  // 전체 페이지 수
	private int startPage;		  // 각 페이지 범위 시작 번호
	private int startList;	  	  
	private int endPage;	      // 각 페이지 범위 끝 번호
	private boolean prev;		  // 이전 페이지 여부
	private boolean next;		  // 다음 페이지 여부
	
	public int getListSize() {
		return listSize;
	}
	public void setListSize(int listSize) {
		this.listSize = listSize;
	}
	public int getRangeSize() {
		return rangeSize;
	}
	public void setRangeSize(int rangeSize) {
		this.rangeSize = rangeSize;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public int getListCnt() {
		return listCnt;
	}
	public void setListCnt(int listCnt) {
		this.listCnt = listCnt;
	}
	public int getPageCnt() {
		return pageCnt;
	}
	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getStartList() {
		return startList;
	}
	public void setStartList(int startList) {
		this.startList = startList;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	
	// Parameter : 현재 페이지, 현재 범위, 전체 리스트 수
	public void pageInfo(int page, int range, int listCnt) {
		this.page = page;
		this.range = range;
		this.listCnt = listCnt;

		// 전체 페이지수 ( 리스트 / 한 화면에 보일 리스트 수 )
		// 전체 데이터가 305건이고  15건씩 표현하면 전체 페이지는 21 페이지.
		this.pageCnt = (int) Math.ceil((double)listCnt/listSize);

		//시작 페이지
		this.startPage = (range - 1) * rangeSize + 1 ;

		//끝 페이지
		this.endPage = range * rangeSize;

		//게시판 시작번호
		this.startList = 1 + ((page - 1) * listSize);

		//이전 버튼 상태
		this.prev = range == 1 ? false : true;

		//다음 버튼 상태
		this.next = endPage > pageCnt ? false : true;
		if (this.endPage > this.pageCnt) {
			this.endPage = this.pageCnt;
			this.next = false;
		}
	}
	 
	@Override
	public String toString() {
		return "Pagination [listSize=" + listSize + ", rangeSize=" + rangeSize + ", page=" + page + ", range=" + range
				+ ", listCnt=" + listCnt + ", pageCnt=" + pageCnt + ", startPage=" + startPage + ", startList="
				+ startList + ", endPage=" + endPage + ", prev=" + prev + ", next=" + next + "]";
	}
}
