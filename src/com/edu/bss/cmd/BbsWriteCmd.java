package com.edu.bss.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.edu.bbs.dto.BbsDTO;
import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dao.BbsDAOimpl;

public class BbsWriteCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		BbsDTO bbsdto = new BbsDTO();
		
		
		bbsdto.setbTitle(request.getParameter("bTitle"));
		bbsdto.setbName(request.getParameter("bName"));
		bbsdto.setbContent(request.getParameter("bContent"));
	
		BbsDAO bbsdao = BbsDAOimpl.getInstance();
		bbsdao.write(bbsdto);
		
		int reqPage;
		try {
			reqPage = Integer.valueOf(request.getParameter("reqPage"));
		} catch (Exception e) {
			reqPage = 1;
		}
		request.setAttribute("reqPage", reqPage);
	}
}
