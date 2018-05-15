package com.edu.bss.cmd;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.RbbsDAO;
import com.edu.bbs.dao.RbbsDAOimpl;
import com.edu.bbs.dto.RbbsDTO;

public class RbbsReplyCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		RbbsDTO rbbsdto = new RbbsDTO();

		rbbsdto.setRnum(Integer.valueOf(request.getParameter("rNum")));
		rbbsdto.setRname(request.getParameter("rName"));
		rbbsdto.setRcontent(request.getParameter("rContent"));

		RbbsDAO rbbsdao = RbbsDAOimpl.getInstance();
		rbbsdao.reply(rbbsdto);
	}

}
