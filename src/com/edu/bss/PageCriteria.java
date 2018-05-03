package com.edu.bss;

import com.edu.bbs.dao.BbsDAO;

public class PageCriteria {
	private int pageNumPerPage = 10; // 한페이지에 보여줄 페이지수
	private int curPage; // 현재페이지
	private int startPage; // 한페이지의 시작페이지
	private int endPage; // 한페이지의 종료페이지

	private int totalRec; // 전체 레코드 수
	private int finalEndPage; // 최종페이지

	private boolean prev; // 이전페이지
	private boolean next; // 다음페이지
	
	private RecordCriteria recordCriteria;	// numPerPage 를 가져오기위해,,(한 페이지에 보여줄 레코드 수 참조)

	public void setPageNumPerPage(int pageNumPerPage) {
		this.pageNumPerPage = pageNumPerPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	// 한 페이지에 보여줄 시작페이지 계산
	public void setStartPage(int startPage) {
		this.startPage = endPage - pageNumPerPage + 1;
	}

	// 한 페이지에 보여줄 종료페이지 계산
	public void setEndPage(int endPage) {
		this.endPage = (int) (Math.ceil(curPage / (double) pageNumPerPage)) * pageNumPerPage;
	}

	// 전체 레코드 수(DAO에서 계산)
	public void setTotalRec(int totalRec) {
		this.totalRec = totalRec;
	}

	//최종페이지 계산
	public void setFinalEndPage(int finalEndPage) {
		this.finalEndPage = (int) Math.ceil(totalRec / recordCriteria.getNumPerPage());
	}

	public void setRecordCriteria(RecordCriteria recordCriteria) {
		this.recordCriteria = recordCriteria;
	}

	// 이전페이지보기버튼 보여줄지 판단
	public void setPrev(boolean prev) {
		this.prev = startPage == 1 ? false : true; 	// 만약에 startPage가 1이 아닐 경우 prev(이전페이지목록)을 true로,,
	}

	// 다음페이지보기버튼 보여줄지 판단
	public void setNext(boolean next) {
		this.next = (endPage * pageNumPerPage) > totalRec ? false : true; // 만약에 endPage*pageNumPerPage 가 전체 레코드수보다 클 경우 (아직 보여줄게 남았을 경우) next(다음페이지목록)을 true로.,.
	}

	public int getPageNumPerPage() {
		return pageNumPerPage;
	}

	public int getCurPage() {
		return curPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public int getTotalRec() {
		return totalRec;
	}

	public int getFinalEndPage() {
		return finalEndPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}

	public RecordCriteria getRecordCriteria() {
		return recordCriteria;
	}

	@Override
	public String toString() {
		return "pageCriteria [pageNumPerPage=" + pageNumPerPage + ", curPage=" + curPage + ", startPage=" + startPage
				+ ", endPage=" + endPage + ", totalRec=" + totalRec + ", finalEndPage=" + finalEndPage + ", prev=" + prev
				+ ", next=" + next + ", recordCriteria=" + recordCriteria + "]";
	}

	
	
}
