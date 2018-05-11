package com.edu.bss.cmd;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.RbbsDAO;
import com.edu.bbs.dao.RbbsDAOimpl;
import com.edu.bbs.dto.RbbsDTO;

public class RbbsListCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		RbbsDAO rbbsdao = RbbsDAOimpl.getInstance();
		ArrayList<RbbsDTO> alist = new ArrayList<>();
		StringBuffer str = new StringBuffer();
		
		int bNum = Integer.valueOf(request.getParameter("bNum"));
		alist = rbbsdao.list(bNum);
/*		{"employees":[
		              { "firstName":"John", "lastName":"Doe" },
		              { "firstName":"Anna", "lastName":"Smith" },
		              { "firstName":"Peter", "lastName":"Jones" }
		          ]}*/
		str.append("{ \"result\" : [\n");
		
		for(RbbsDTO rbbsdto : alist) {
			str.append("{\"댓글번호\":\""+rbbsdto.getRnum() + "\"},\n");
			str.append("{\"원글번호\":\""+rbbsdto.getBnum() + "\"},\n");
			str.append("{\"작성일\":\""+rbbsdto.getRcdate() + "\"},\n");
			str.append("{\"내용\":\""+rbbsdto.getRcontent() + "\"},\n");
			str.append("{\"작성자\":\""+rbbsdto.getRname() + "\"},\n");
			str.append("{\"좋아요\":\""+rbbsdto.getRgood() + "\"},\n");
			str.append("{\"싫어요\":\""+rbbsdto.getRbad() + "\"},\n\n");
		}
		str.append("]}");
		
		response.getWriter().write(str.toString());
	}

}
