package com.edu.test;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dto.BbsDTO;
import com.edu.bss.PageCriteria;
import com.edu.bss.RecordCriteria;

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
	/*@Test
	void test2() {
		RecordCriteria rc = new RecordCriteria(5,10);
		BbsDAO bbsdao = BbsDAO.getInstance();
		PageCriteria pc = new PageCriteria(rc,bbsdao.getListCount());
		
		System.out.println(pc.toString());
	}*/
	
	@Test
	void test3() {
		BbsDAO bbsdao = BbsDAO.getInstance();
		ArrayList<BbsDTO> alist = bbsdao.searchList("작성자", "작성자");
		System.out.println(alist.size());
		for(BbsDTO bbsdto : alist) {
			System.out.println(bbsdto);
		}
	}

}
