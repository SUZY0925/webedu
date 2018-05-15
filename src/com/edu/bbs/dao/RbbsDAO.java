package com.edu.bbs.dao;

import java.util.ArrayList;

import com.edu.bbs.dto.BbsDTO;
import com.edu.bbs.dto.RbbsDTO;

public interface RbbsDAO {

	// 댓글등록
	void write(RbbsDTO rbbsdto);

	// 댓글 목록
	ArrayList<RbbsDTO> list(int bNum, int startRow, int endRow);
	// 댓글 갯수
	int getListCount();

	// 글내용 가져오기
	BbsDTO view(int bNum);

	// 글수정하기
	void modify(String rNum, String rContent);

	//글삭제하기
	void delete(String rNum);

	// 다음글 이전글 이동
	BbsDTO pageNav(int bNum, int np);

	//원글 가져오기
	RbbsDTO replyView(int bNum);

	// 답글 등록하기
	void reply(RbbsDTO rbbsdto);

	void updateStep(int bgroup, int bstep);

	// 검색한 글목록가져오기
	ArrayList<RbbsDTO> searchList(String option, String search, int startRow, int endRow);

	// 검색한 글 전체 수 가져오기
	int getSearchListCount(String option, String search);

	ArrayList<RbbsDTO> list(int bNum);

	void goodOrBad(String rNum, String goodOrBad);

	int replyTotalRec(int bNum);

}