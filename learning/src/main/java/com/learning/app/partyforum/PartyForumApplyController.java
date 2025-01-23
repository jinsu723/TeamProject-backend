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

public class PartyForumApplyController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();

//		System.out.println((request.getParameter("userId")));
//		System.out.println((request.getParameter("userId")).getClass());
//		System.out.println(request.getParameter("postNum"));
//		System.out.println(request.getParameter("postNum").getClass());

		int postNum = Integer.parseInt(request.getParameter("postNum"));

		partyForumDAO partyForumDAO = new partyForumDAO();
		int userId = partyForumDAO.ApplyUserNum((request.getParameter("userId")));

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("userId", userId);
		map.put("postNum", postNum);

		partyForumDAO.partyForumApply(map);

		result.setRedirect(false);
		result.setPath("/app/partyForum/partyForumDetail.fo?postNum=" + postNum);

		return result;
	}

}
