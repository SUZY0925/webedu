package com.edu.bbs.dao;

import java.util.ArrayList;

import com.edu.bbs.dto.BbsDTO;

public interface BbsDAO {

	// 글쓰기
	void write(BbsDTO bbsdto);

	ArrayList<BbsDTO> list(int startRow, int endRow);

	int getListCount();

	/*
		create or replace procedure  Clist_callbbs (
		    PNUM IN NUMBER,
		    OTITLE out bbs.btitle%TYPE,
		    ONAME out bbs.bname%TYPE,
		    OUDATE out bbs.budate%TYPE,
		    OHIT out bbs.bhit%TYPE,
		    OCONTENT out bbs.bcontent%TYPE)
		AS
		    r_errcode NUMBER;
		    r_errmsg VARCHAR(2);
		BEGIN
		        update BBS 
		        SET BHIT=(BHIT+1) where BNUM = PNUM;
		        select BTITLE, BNAME, BUDATE, BHIT, BCONTENT
		        INTO  OTITLE, ONAME, OUDATE, OHIT, OCONTENT
		        FROM bbs
		        where bnum = pnum;
		Exception 
		    WHEN OTHERS THEN
		    ROLLBACK;
		    r_errcode := SQLCODE;
		    r_errmsg := SQLERRM;
		    DBMS_OUTPUT.PUT_LINE('ERRCODE : ' || to_char(r_errcode));
		    DBMS_OUTPUT.PUT_LINE('ERRMSG : ' || r_errmsg);
		END;
		/
	*/
	// 글내용 가져오기
	BbsDTO view(int bNum);

	// 글수정하기
	BbsDTO modify(BbsDTO bbsdto);

	//글삭제하기
	void delete(int bNum);

	// 다음글 이전글 이동
	BbsDTO pageNav(int bNum, int np);

	//원글 가져오기
	BbsDTO replyView(int bNum);

	// 답글 등록하기
	void reply(BbsDTO bbsdto);

	void updateStep(int bgroup, int bstep);

	// 검색한 글목록가져오기
	ArrayList<BbsDTO> searchList(String option, String search, int startRow, int endRow);

	// 검색한 글 전체 수 가져오기
	int getSearchListCount(String option, String search);

}