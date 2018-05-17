package com.edu.bss.cmd;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.RbbsDAO;
import com.edu.bbs.dao.RbbsDAOimpl;
import com.edu.bbs.dto.RbbsDTO;
import com.edu.bss.PageCriteria;
import com.edu.bss.RecordCriteria;

public class RbbsListCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		RbbsDAO rbbsdao = RbbsDAOimpl.getInstance();
		ArrayList<RbbsDTO> alist = new ArrayList<>();
		
		int bNum = Integer.valueOf(request.getParameter("bNum"));
		int reReqPage;
		try {
			reReqPage = Integer.valueOf(request.getParameter("reReqPage"));
		} catch (NumberFormatException e) {
			reReqPage = 1;
		}
		
		RecordCriteria rc = new RecordCriteria(reReqPage,10);
		int replyTotalRec = rbbsdao.replyTotalRec(bNum);
		PageCriteria pc = new PageCriteria(rc,replyTotalRec);
		
		alist = rbbsdao.list( bNum, rc.getStartRecord(), rc.getEndRecord());
		StringBuffer str = new StringBuffer();

		str.append("{\"result\" : [");
		int i = 0;
		for (RbbsDTO rbbsdto : alist) {
			i += 1;
			str.append("{\"RNUM\":\"" + rbbsdto.getRnum() + "\",");
			str.append("\"BNUM\":\"" + rbbsdto.getBnum() + "\",");
			str.append("\"RCDATE\":\"" + rbbsdto.getRcdate() + "\",");
			str.append("\"RCONTENT\":\"" + rbbsdto.getRcontent() + "\",");
			str.append("\"RNAME\":\"" + rbbsdto.getRname() + "\",");
			str.append("\"RINDENT\":\"" + rbbsdto.getRindent() + "\",");
			str.append("\"RGOOD\":\"" + rbbsdto.getRgood() + "\",");

			if (alist.size() == i) {
				str.append("\"RBAD\":\"" + rbbsdto.getRbad() + "\"}");
			} else {
				str.append("\"RBAD\":\"" + rbbsdto.getRbad() + "\"},");
			}
		}
		str.append("] ,");
		/*
		{ "result" : [ { }, { }, { } ] ,
		 "page" : { "startPage" : 1, "endPage" : 10 } }
		*/
		str.append("\"pageCriteria\" : {");
		str.append("\"startPage\" : "		+ pc.getStartPage()		+ ", ");
		str.append("\"endPage\" : " 		+ pc.getEndPage()			+ ", ");
		str.append("\"finalEndPage\" : " + pc.getFinalEndPage()  + ", ");
		str.append("\"prev\" : " 			+ pc.isPrev() 				+ ", ");
		str.append("\"next\" : "			+ pc.isNext());
		str.append("}}");
		
		response.getWriter().write(str.toString());
		
	}

}
