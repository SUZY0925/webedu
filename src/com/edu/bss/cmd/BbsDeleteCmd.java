package com.edu.bss.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dto.BbsDTO;

public class BbsDeleteCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int bNum = Integer.valueOf(request.getParameter("bNum"));
		
		BbsDAO bbsdao = BbsDAO.getInstance();
		bbsdao.delete(bNum);
		
		int reqPage;
		try {
			reqPage = Integer.valueOf(request.getParameter("reqPage"));
		} catch (Exception e) {
			reqPage = 1;
		}
		request.setAttribute("reqPage", reqPage);
	}

}
