package com.edu.bss.cmd;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dto.BbsDTO;
import com.edu.bss.PageCriteria;
import com.edu.bss.RecordCriteria;

public class BbsListCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		BbsDAO bbsdao = BbsDAO.getInstance();

<<<<<<< HEAD
		int reqPage;
		
		try {
			reqPage = Integer.valueOf(request.getParameter("reqPage"));
		} catch (NumberFormatException e) {
			reqPage = 1;
		}
	
		RecordCriteria rc = new RecordCriteria(reqPage, 10);
=======
		int reqPage = Integer.valueOf(request.getParameter("reqPage"));
<<<<<<< HEAD

=======
/*		int numPerPage = Integer.valueOf(request.getParameter("numPerPage"));*/
		
		PageCriteria pc = new PageCriteria();
>>>>>>> parent of 189501b... 05030622
		RecordCriteria rc = new RecordCriteria(reqPage, 7);
>>>>>>> 5d629b90d2b7a9ddce1279bc288c99878147cdcc
		ArrayList<BbsDTO> alist = bbsdao.list(rc.getStartRecord(), rc.getEndRecord());
		
		request.setAttribute("list", alist);
		
		PageCriteria pc = new PageCriteria(rc, bbsdao.getListCount());
		
		request.setAttribute("page", pc);
	}

}
