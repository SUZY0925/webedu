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
=======
<<<<<<< HEAD
		int reqPage;
		
>>>>>>> 94f5f354da9f8b97ea3e03edfb5dc2a99e658175
		try {
			reqPage = Integer.valueOf(request.getParameter("reqPage"));
		} catch (NumberFormatException e) {
			reqPage = 1;
		}
<<<<<<< HEAD
=======
	
		RecordCriteria rc = new RecordCriteria(reqPage, 10);
=======
		int reqPage = Integer.valueOf(request.getParameter("reqPage"));
<<<<<<< HEAD
>>>>>>> 94f5f354da9f8b97ea3e03edfb5dc2a99e658175

		PageCriteria pc = new PageCriteria();
		ArrayList pagelist = new ArrayList();
		pagelist.add(pc.getCurPage());
		pagelist.add(pc.getEndPage());
		pagelist.add(pc.getFinalEndPage());
		pagelist.add(pc.getPageNumPerPage());
		pagelist.add(pc.getStartPage());
		pagelist.add(pc.getTotalRec());
		
		RecordCriteria rc = new RecordCriteria(reqPage, 7);
>>>>>>> 5d629b90d2b7a9ddce1279bc288c99878147cdcc
		ArrayList<BbsDTO> alist = bbsdao.list(rc.getStartRecord(), rc.getEndRecord());
		
		request.setAttribute("list", alist);
<<<<<<< HEAD
		request.setAttribute("page", pagelist);
=======
		
		PageCriteria pc = new PageCriteria(rc, bbsdao.getListCount());
		
		request.setAttribute("page", pc);
>>>>>>> 94f5f354da9f8b97ea3e03edfb5dc2a99e658175
	}

}
