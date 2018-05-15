package com.edu.bss.cmd;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.RbbsDAO;
import com.edu.bbs.dao.RbbsDAOimpl;

public class RbbsGoodORBadCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String goodOrBad = request.getParameter("goodOrBad");
		String rNum = request.getParameter("rNum");
		RbbsDAO rbbsdao = RbbsDAOimpl.getInstance();
		rbbsdao.goodOrBad(rNum, goodOrBad);
		
	}

}
