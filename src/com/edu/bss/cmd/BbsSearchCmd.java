package com.edu.bss.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BbsSearchCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
<<<<<<< HEAD
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
=======
		System.out.println(request.getParameter("inputState"));
		System.out.println("??");
>>>>>>> parent of e38fd8b... 1805081019
	}

}
