package com.edu.bss.cmd;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dto.BbsDTO;
import com.edu.bss.PageCriteria;
import com.edu.bss.RecordCriteria;

public class BbsSearchCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String option = request.getParameter("option");
		String search = request.getParameter("search");
		
		BbsDAO bbsdao = BbsDAO.getInstance();
		System.out.println("......");
//		int reqPage;
//		
//		try {
//			reqPage = Integer.valueOf(request.getParameter("reqPage"));
//		} catch (NumberFormatException e) {
//			reqPage = 1;
//		}
//		
//		RecordCriteria rc = new RecordCriteria(reqPage, 10);
		
//		ArrayList<BbsDTO> alist = bbsdao.searchList(option, search,rc.getStartRecord(), rc.getEndRecord());
		ArrayList<BbsDTO> alist = bbsdao.searchList(option, search);
		
//		PageCriteria pc = new PageCriteria(rc, bbsdao.getSearchListCount(option,search));
		
		request.setAttribute("searchList", alist);
		
//		request.setAttribute("page", pc);
	}

}
