package com.edu.bss.cmd;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dao.BbsDAOimpl;
import com.edu.bbs.dto.BbsDTO;
import com.edu.bss.FindCriteria;
import com.edu.bss.PageCriteria;
import com.edu.bss.RecordCriteria;

public class BbsListCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int reqPage;
		try {
			reqPage = Integer.valueOf(request.getParameter("reqPage"));
		} catch (NumberFormatException e) {
			reqPage = 1;
		}
		String search = request.getParameter("search");
		String option = request.getParameter("option");
		BbsDAO bbsdao = BbsDAOimpl.getInstance();
		RecordCriteria rc;
		ArrayList<BbsDTO> alist;
		int totalRec;
		PageCriteria pc;
		
		if(option == null || search.trim().equals("")) {	// 검색조건이 없는 경우
			rc = new RecordCriteria(reqPage);
			
			alist = bbsdao.list(rc.getStartRecord(), rc.getEndRecord());
			totalRec = bbsdao.getListCount();
			pc = new PageCriteria(rc,totalRec);
			
			request.setAttribute("list", alist);
			request.setAttribute("page", pc);
			request.setAttribute("rc", rc);
		}
		else {
			rc = new FindCriteria(reqPage,option,search);
			
			alist = bbsdao.searchList(((FindCriteria) rc).getOption(), ((FindCriteria) rc).getSearch(), rc.getStartRecord(), rc.getEndRecord());
			totalRec = bbsdao.getSearchListCount(((FindCriteria) rc).getOption(), ((FindCriteria) rc).getSearch());
			pc = new PageCriteria(rc,totalRec);
			
			request.setAttribute("list", alist);
			request.setAttribute("page", pc);
			
			if(rc instanceof FindCriteria) {
				request.setAttribute("rc", (FindCriteria)rc);	
			}
		}
	}
}
