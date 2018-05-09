package com.edu.test;

import org.junit.jupiter.api.Test;

import com.edu.bbs.dao.BbsDAO;

class TestBbsDAO {

/*	@Test
	void test() {
		RecordCriteria pc = new RecordCriteria(1,5);
		
		BbsDAO bbsdao = BbsDAO.getInstance();
		ArrayList<BbsDTO> list = bbsdao.list(pc.getStartRecord(), pc.getEndRecord());
	
		for(BbsDTO bbsdto : list) {
			System.out.println(bbsdto);
		}
	}
	*/
	
/*	@Test
	void test3() {
		BbsDAO bbsdao = BbsDAO.getInstance();
		ArrayList<BbsDTO> alist = bbsdao.searchList("작성자", "작성자",1,10);
		System.out.println(alist.size());
		for(BbsDTO bbsdto : alist) {
			System.out.println(bbsdto);
		}
	}
		*/
/*	@Test
	void test2() {
		RecordCriteria rc = new RecordCriteria(5,10);
		BbsDAO bbsdao = BbsDAO.getInstance();
		PageCriteria pc = new PageCriteria(rc,bbsdao.getListCount());
		
		System.out.println(pc.toString());
	}*/
	
	@Test
	void test4() {
		BbsDAO bbsdao = BbsDAO.getInstance();
		int cnt = bbsdao.getSearchListCount("제목+내용", "re");
		System.out.println(cnt);
	}

}
