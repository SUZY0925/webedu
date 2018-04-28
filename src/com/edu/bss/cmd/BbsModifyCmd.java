package com.edu.bss.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dto.BbsDTO;

public class BbsModifyCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BbsDTO bbsdto = new BbsDTO();
		
		bbsdto.setbNum(Integer.valueOf(request.getParameter("bNum")));
		bbsdto.setbTitle(request.getParameter("bTitle"));
		bbsdto.setbName(request.getParameter("bName"));
		bbsdto.setbContent(request.getParameter("bContent"));
		
		BbsDAO bbsdao = BbsDAO.getInstance();
		
		bbsdto = bbsdao.modify(bbsdto);
		request.setAttribute("bbsdto", bbsdto);

	}

}
