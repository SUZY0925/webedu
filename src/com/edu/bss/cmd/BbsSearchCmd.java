package com.edu.bss.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BbsSearchCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request.getParameter("inputState"));
		System.out.println("??");
	}

}
