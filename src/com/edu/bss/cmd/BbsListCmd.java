package com.edu.bss.cmd;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dto.BbsDTO;

public class BbsListCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		BbsDAO bbsdao = BbsDAO.getInstance();

		int currentPage = 0;
		
		try {
			currentPage = Integer.valueOf(request.getParameter("pageNum"));
		} catch (NumberFormatException e) {
			currentPage = 1;
		}

		int startRow = (currentPage - 1) * 5  + 1; // 해당 페이지에서 시작할 레코드
		int endRow = currentPage * 5 ; // 마지막 레코드
		
		ArrayList<BbsDTO> alist = bbsdao.getList(startRow, endRow);
		int getListCount = bbsdao.getListCount();
		
		
		request.setAttribute("count", getListCount);
		request.setAttribute("list", alist);
	}

}
