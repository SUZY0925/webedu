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
		/*
		 * {"employees":[ { "firstName":"John", "lastName":"Doe" }, {
		 * "firstName":"Anna", "lastName":"Smith" }, { "firstName":"Peter",
		 * "lastName":"Jones" } ]}
		 */
		str.append("{\"result\" : [");
		int i = 0;
		for (RbbsDTO rbbsdto : alist) {
			i += 1;
			str.append("{\"RNUM\":\"" + rbbsdto.getRnum() + "\",");
			str.append("\"BNUM\":\"" + rbbsdto.getBnum() + "\",");
			str.append("\"RCDATE\":\"" + rbbsdto.getRcdate() + "\",");
			str.append("\"RCONTENT\":\"" + rbbsdto.getRcontent() + "\",");
			str.append("\"RNAME\":\"" + rbbsdto.getRname() + "\",");
			str.append("\"RGOOD\":\"" + rbbsdto.getRgood() + "\",");

			if (alist.size() == i) {
				str.append("\"RBAD\":\"" + rbbsdto.getRbad() + "\"}");
			} else {
				str.append("\"RBAD\":\"" + rbbsdto.getRbad() + "\"},");
			}
		}
		str.append("]}");

		response.getWriter().write(str.toString());
	}

}
