package com.edu.bss.cmd;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dto.BbsDTO;
import com.edu.bss.PageCriteria;
import com.edu.bss.RecordCriteria;

public class BbsListCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		BbsDAO bbsdao = BbsDAO.getInstance();

		int reqPage = Integer.valueOf(request.getParameter("reqPage"));
<<<<<<< HEAD

=======
/*		int numPerPage = Integer.valueOf(request.getParameter("numPerPage"));*/
		
		PageCriteria pc = new PageCriteria();
>>>>>>> parent of 189501b... 05030622
		RecordCriteria rc = new RecordCriteria(reqPage, 7);
		ArrayList<BbsDTO> alist = bbsdao.list(rc.getStartRecord(), rc.getEndRecord());

		request.setAttribute("list", alist);
	}

}
