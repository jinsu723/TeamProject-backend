package com.learning.app.partyforum;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.partyForumDAO;
import com.learning.app.dto.partyForumDTO;

public class PartyForumEditController implements Execute {
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();

		System.out.println(Integer.parseInt(request.getParameter("postNum")));
		partyForumDAO partyForumDAO = new partyForumDAO();
		List<partyForumDTO> forumDetail = partyForumDAO.getForumDetail(Integer.parseInt(request.getParameter("postNum")));
		request.setAttribute("forumDetail", forumDetail);

		result.setRedirect(false);
		result.setPath("/app/partyForum/partyForumEdit.jsp");

		return result;
	}

}
