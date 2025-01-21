package com.learning.app.partyforum;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.partyForumDAO;
import com.learning.app.dto.ForumDTO;
import com.learning.app.dto.partyForumDTO;

public class PartyForumDetailController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		
		int a = Integer.parseInt(request.getParameter("postNum"));
		
		System.out.println(a);
		
		partyForumDAO partyForumDAO = new partyForumDAO();
		List<partyForumDTO> forumDetail = partyForumDAO.getForumDetail(Integer.parseInt(request.getParameter("postNum")));
				
		for (partyForumDTO b : forumDetail) {
			System.out.println(b.getForumTitle());
			System.out.println(b.getForumContent());
	}
		
		request.setAttribute("forumDetail", forumDetail);
		
		result.setRedirect(false);
		result.setPath("/app/partyForum/partyForumDetail.jsp");
		
		return result;
	}

}
