package com.edu.bss.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.edu.bbs.dto.BbsDTO;
import com.edu.bbs.dao.BbsDAO;

public class BbsWriteCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		BbsDTO bbsdto = new BbsDTO();
		
		
		bbsdto.setbTitle(request.getParameter("bTitle"));
		bbsdto.setbName(request.getParameter("bName"));
		bbsdto.setbContent(request.getParameter("bContent"));
	
		BbsDAO bbsdao = BbsDAO.getInstance();
		bbsdao.write(bbsdto);
	}
}
