package com.edu.bss.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dao.BbsDAOimpl;
import com.edu.bbs.dto.BbsDTO;

public class BbsPagenavCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int bNum = Integer.valueOf(request.getParameter("bNum"));
		int np = Integer.valueOf(request.getParameter("np"));

		BbsDTO bbsdto = new BbsDTO();
		BbsDAO bbsdao = BbsDAOimpl.getInstance();
		
		bbsdto = bbsdao.pageNav(bNum, np);
		request.setAttribute("bbsdto", bbsdto);
	}
}
