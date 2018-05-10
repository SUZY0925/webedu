package com.edu.bss.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dao.BbsDAOimpl;
import com.edu.bbs.dto.BbsDTO;

public class BbsReplyViewCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int bNum = Integer.valueOf(request.getParameter("bNum"));
		
		BbsDAO bbsdao = BbsDAOimpl.getInstance();
		BbsDTO bbsdto = bbsdao.replyView(bNum);
		
		request.setAttribute("replyView", bbsdto);
		
		int reqPage;
		try {
			reqPage = Integer.valueOf(request.getParameter("reqPage"));
		} catch (Exception e) {
			reqPage = 1;
		}
		request.setAttribute("reqPage", reqPage);
	}

}
