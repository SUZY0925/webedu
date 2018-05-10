package com.edu.test;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.edu.bbs.dao.RbbsDAO;
import com.edu.bbs.dao.RbbsDAOimpl;
import com.edu.bbs.dto.RbbsDTO;

class TestRbbsDAO {
/*
	@Test
	void test() {
		RbbsDAO rbbsdao = RbbsDAOimpl.getInstance();
		RbbsDTO rbbsdto = new RbbsDTO();
		
		rbbsdto.setBnum(1);
		rbbsdto.setRname("test");
		rbbsdto.setRcontent("reply test");
		
		rbbsdao.write(rbbsdto);
		
		System.out.println(rbbsdto.toString());
	}*/
	
	@Test
	void test2() {
		RbbsDAO rbbsdao = RbbsDAOimpl.getInstance();
		
		ArrayList<RbbsDTO> alist = rbbsdao.list(1, 10);
		
		System.out.println(alist.size());
		for(RbbsDTO rbbsdto : alist) {
			System.out.println(rbbsdto.toString());
		}
	}

}
