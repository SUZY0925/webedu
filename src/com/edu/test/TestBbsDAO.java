package com.edu.test;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dto.BbsDTO;
import com.edu.bss.RecordCriteria;

class TestBbsDAO {

	@Test
	void test() {
		RecordCriteria pc = new RecordCriteria(1,5);
		
		BbsDAO bbsdao = BbsDAO.getInstance();
		ArrayList<BbsDTO> list = bbsdao.list(pc.getStartRecord(), pc.getEndRecord());
	
		for(BbsDTO bbsdto : list) {
			System.out.println(bbsdto);
		}
	}

}
