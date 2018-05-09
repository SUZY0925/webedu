package com.edu.bss.cmd;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.BbsDAO;
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
		BbsDAO bbsdao = BbsDAO.getInstance();
		
		if(option == null || search.trim().equals("")) {
			FindCriteria fc = new FindCriteria(reqPage);
			
			ArrayList<BbsDTO> alist = bbsdao.list(fc.getStartRecord(), fc.getEndRecord());
			int totalRec = bbsdao.getListCount();
			PageCriteria pc = new PageCriteria(fc,totalRec);
			
			request.setAttribute("list", alist);
			request.setAttribute("page", pc);
			request.setAttribute("fc", fc);
		}
		else {
			FindCriteria fc = new FindCriteria(reqPage,option,search);
			
			ArrayList<BbsDTO> alist = bbsdao.searchList(fc.getOption(), fc.getSearch(), fc.getStartRecord(), fc.getEndRecord());
			int totalRec = bbsdao.getSearchListCount(fc.getOption(), fc.getSearch());
			PageCriteria pc = new PageCriteria(fc,totalRec);
			
			request.setAttribute("list", alist);
			request.setAttribute("page", pc);
			request.setAttribute("fc", fc);	
			
			request.setAttribute("option", option);
			request.setAttribute("search", search);
		}
	}
}
