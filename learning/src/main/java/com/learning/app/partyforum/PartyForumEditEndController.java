package com.learning.app.partyforum;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.partyForumDAO;

public class PartyForumEditEndController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();

//		System.out.println(request.getParameter("postNum"));
//		System.out.println(request.getParameter("forumTitle"));
//		System.out.println(request.getParameter("forumContent"));

		partyForumDAO partyForumDAO = new partyForumDAO();
		Map<String, String> map = new HashMap<String, String>();
		map.put("forumTitle", request.getParameter("forumTitle"));
		map.put("forumContent", request.getParameter("forumContent"));
		map.put("postNum", request.getParameter("postNum"));
		partyForumDAO.EditEnd(map);

		result.setRedirect(true);
		result.setPath(request.getContextPath() + "/app/partyForum/partyForum.fo");

		return result;
	}

}
