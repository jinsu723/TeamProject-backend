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

public class PartyForumCommentAddController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();

//		System.out.println(request.getParameter("postNum"));
//		System.out.println(request.getParameter("commentContent"));
//		System.out.println(request.getParameter("userId"));

		partyForumDAO partyforumDAO = new partyForumDAO();
		String userNum = Integer.toString(partyforumDAO.ApplyUserNum(request.getParameter("userId")));

		Map<String, String> map = new HashMap<String, String>();
		map.put("postNum", request.getParameter("postNum"));
		map.put("commentContent", request.getParameter("commentContent"));
		map.put("userNum", userNum);

		partyforumDAO.commentAdd(map);

		result.setRedirect(false);
		result.setPath(request.getContextPath() + "/app/partyForum/partyForum.fo");

		return result;
	}

}
