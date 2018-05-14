package com.edu.bss.cmd;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.RbbsDAO;
import com.edu.bbs.dao.RbbsDAOimpl;

public class RbbsDeleteCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String rNum = request.getParameter("rNum");
		RbbsDAO rbbsdao = RbbsDAOimpl.getInstance();
		rbbsdao.delete(rNum);
	}

}
