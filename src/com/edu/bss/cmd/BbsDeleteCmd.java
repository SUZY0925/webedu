package com.edu.bss.cmd;

<<<<<<< HEAD
import java.util.ArrayList;

=======
>>>>>>> 189501b2d6e79d7877ba17d765528576dfe7980f
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dto.BbsDTO;

public class BbsDeleteCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
<<<<<<< HEAD
		BbsDAO bbsdao = BbsDAO.getInstance();
		
		int bNum = Integer.valueOf(request.getParameter("bNum"));
		
//		bbsdao.delete(bNum);
=======
		
		int bNum = Integer.valueOf(request.getParameter("bNum"));
		
		BbsDAO bbsdao = BbsDAO.getInstance();
		bbsdao.delete(bNum);
>>>>>>> 189501b2d6e79d7877ba17d765528576dfe7980f
	}

}
