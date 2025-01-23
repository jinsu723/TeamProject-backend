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

		int forumNumber = Integer.parseInt(request.getParameter("forumNumber"));

		System.out.println("게시글 번호 : " + forumNumber);
		adminDAO.deletePartyForum(forumNumber);

		System.out.println("게시글 삭제 완료");

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		return null;
	}

}
