package com.edu.bss;

public class FindCriteria extends RecordCriteria {
	private String option;	// 검색타입
	private String search;	// 검색단어
	
	public FindCriteria() {	//
	}
	
	public FindCriteria(int reqPage) {
		super(reqPage);
	}

	public FindCriteria(int reqPage, String option, String search) {
		super(reqPage);
		this.option = option;
		this.search = search;
	}
	
	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	
	public String getmakeURL() {
		StringBuffer str = new StringBuffer();
		if(super.getReqPage() != 0) {
			str.append("reqPage="+super.getReqPage());
		}
		if(this.getOption() != null) {
			str.append("&option="+this.getOption());
		}
		if(this.getSearch() != null) {
			str.append("&search="+this.getSearch());
		}
		return str.toString();
	}

	@Override
	public String toString() {
		return "FindCriteria [option=" + option + ", search=" + search + "]";
	}
}
