package com.edu.bss.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dto.BbsDTO;

public class BbsReplyCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BbsDTO bbsdto = new BbsDTO();
		
		bbsdto.setbNum(Integer.valueOf(request.getParameter("bNum")));
		bbsdto.setbName(request.getParameter("bName"));
		bbsdto.setbTitle(request.getParameter("bTitle"));
		bbsdto.setbContent(request.getParameter("bContent"));
		bbsdto.setbGroup(Integer.valueOf(request.getParameter("bGroup")));
		bbsdto.setbStep(Integer.valueOf(request.getParameter("bStep")));
		bbsdto.setbIndent(Integer.valueOf(request.getParameter("bIndent")));
		
		System.out.println();
		BbsDAO bbsdao = BbsDAO.getInstance();
		bbsdao.reply(bbsdto);
		
		int reqPage;
		try {
			reqPage = Integer.valueOf(request.getParameter("reqPage"));
		} catch (Exception e) {
			reqPage = 1;
		}
		request.setAttribute("reqPage", reqPage);
	}

}
