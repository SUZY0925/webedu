package com.edu.bss.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dao.BbsDAOimpl;
import com.edu.bbs.dto.BbsDTO;
import com.edu.bss.FindCriteria;
import com.edu.bss.PageCriteria;
import com.edu.bss.RecordCriteria;

public class BbsViewCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BbsDAO bbsdao = BbsDAOimpl.getInstance();
		String bNum = request.getParameter("bNum");
		String reqPage = request.getParameter("reqPage");

		String search = request.getParameter("search");
		String option = request.getParameter("option");
		RecordCriteria rc;

		BbsDTO bbsdto = bbsdao.view(Integer.valueOf(bNum));

		if (option == null || search.trim().equals("")) {
			rc = new RecordCriteria(Integer.valueOf(reqPage));
		} else {
			rc = new FindCriteria(Integer.valueOf(reqPage), option, search);
		}
		request.setAttribute("bbsdto", bbsdto);
		request.setAttribute("rc", rc);
		
		request.setAttribute("search", search);
		request.setAttribute("option", option);
	}
}
