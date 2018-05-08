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

		int reqPage;
		try {
			reqPage = Integer.valueOf(request.getParameter("reqPage"));
		} catch (NumberFormatException e) {
			reqPage = 1;
		}

		PageCriteria pc = new PageCriteria();
		ArrayList pagelist = new ArrayList();
		pagelist.add(pc.getCurPage());
		pagelist.add(pc.getEndPage());
		pagelist.add(pc.getFinalEndPage());
		pagelist.add(pc.getPageNumPerPage());
		pagelist.add(pc.getStartPage());
		pagelist.add(pc.getTotalRec());
		
		RecordCriteria rc = new RecordCriteria(reqPage, 7);
		ArrayList<BbsDTO> alist = bbsdao.list(rc.getStartRecord(), rc.getEndRecord());

		request.setAttribute("list", alist);
		request.setAttribute("page", pagelist);
	}

}
