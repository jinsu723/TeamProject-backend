package com.learning.app.partyforum;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.partyForumDAO;

public class PartyForumCommentDeleteController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();

//		System.out.println(request.getParameter("commentNumber"));
//		System.out.println(request.getParameter("commentNumber").getClass());

		partyForumDAO partyForumDAO = new partyForumDAO();
		partyForumDAO.CommentDelete(Integer.parseInt(request.getParameter("commentNumber")));

		result.setRedirect(false);
		result.setPath("/app/partyForum/partyForum.fo");

		return result;
	}

}
