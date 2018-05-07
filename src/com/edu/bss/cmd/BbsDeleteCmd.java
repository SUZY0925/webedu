package com.edu.bss.cmd;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dto.BbsDTO;

public class BbsDeleteCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BbsDAO bbsdao = BbsDAO.getInstance();
		
		int bNum = Integer.valueOf(request.getParameter("bNum"));
		
		
		bbsdao.delete(bNum);
	}

}
