package com.edu.bss.cmd;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dto.BbsDTO;

public class BbsViewCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		BbsDTO bbsdto = new BbsDTO();
		bbsdto.setbNum(Integer.valueOf(request.getParameter("bNum")));
		
		BbsDAO bbsdao = BbsDAO.getInstance();
		
		bbsdto = bbsdao.view(bbsdto.getbNum());
		request.setAttribute("bbsdto", bbsdto);
	}
}