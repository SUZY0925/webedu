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
		
		for(int i = 0; i <1567; ++i) {
			rbbsdto.setBnum(1);
			rbbsdto.setRname("test_"+i);
			rbbsdto.setRcontent("reply test_"+i);
			rbbsdao.write(rbbsdto);
		}
	}
	*/
/*	@Test
	void test2() {
		RbbsDAO rbbsdao = RbbsDAOimpl.getInstance();
		
		ArrayList<RbbsDTO> alist = rbbsdao.list(1, 10);
		
		System.out.println(alist.size());
		for(RbbsDTO rbbsdto : alist) {
			System.out.println(rbbsdto.toString());
		}
	}*/
	
/*	@Test
	void modify() {
		ArrayList<RbbsDTO> alist;
		RbbsDAO rbbsdao = RbbsDAOimpl.getInstance();
		
		alist = rbbsdao.list(1);
		System.out.println("---------------수정전-----------------");
		for(RbbsDTO rbbsdto : alist) {
			System.out.println(rbbsdto.toString());
		}
		rbbsdao.modify("2", "수정테스트~");
		
		alist = rbbsdao.list(1);
		System.out.println("---------------수정후-----------------");
		for(RbbsDTO rbbsdto : alist) {
			System.out.println(rbbsdto.toString());
		}
	}*/
	/*
	@Test
	void delete() {
		ArrayList<RbbsDTO> alist;
		RbbsDAO rbbsdao = RbbsDAOimpl.getInstance();
		
		alist = rbbsdao.list(1);
		System.out.println("---------------삭제전-----------------");
		for(RbbsDTO rbbsdto : alist) {
			System.out.println(rbbsdto.toString());
		}
		rbbsdao.delete("2");
		
		alist = rbbsdao.list(1);
		System.out.println("---------------삭제후-----------------");
		for(RbbsDTO rbbsdto : alist) {
			System.out.println(rbbsdto.toString());
		}
	}*/
/*	
	@Test
	void reply() {
		RbbsDTO rbbsdto = new RbbsDTO();
		
		rbbsdto.setBnum(1);
		rbbsdto.setRnum(27);
		rbbsdto.setRname("대댓작성자");
		rbbsdto.setRcontent("대댓내용");
		
		RbbsDAO rbbsdao = RbbsDAOimpl.getInstance();
		
		rbbsdao.reply(rbbsdto);
		
	}*/
	
	@Test
	void list() {
		RbbsDAO rbbsdao = RbbsDAOimpl.getInstance();
		
		ArrayList<RbbsDTO> alist = rbbsdao.list(1,1,10);
		
		for(RbbsDTO rbbsdto : alist) {
			System.out.println(rbbsdto.toString());
		}
	}

}
