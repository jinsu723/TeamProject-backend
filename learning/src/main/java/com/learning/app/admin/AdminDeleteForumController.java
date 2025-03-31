package com.learning.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.AdminDAO;

public class AdminDeleteForumController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("게시글 삭제");

		AdminDAO adminDAO = new AdminDAO();
		/* Result result = new Result(); */

		System.out.println("forumNumber : " + request.getParameter("forumNumber"));
		int forumNumber = Integer.parseInt(request.getParameter("forumNumber"));

		System.out.println("게시글 번호 : " + forumNumber);
		adminDAO.deletePartyForum(forumNumber);

		System.out.println("게시글 삭제 완료");


//		result.setPath(request.getContextPath() + "/adminParty.ad");
//		result.setRedirect(true);

		return null;
	}

}
