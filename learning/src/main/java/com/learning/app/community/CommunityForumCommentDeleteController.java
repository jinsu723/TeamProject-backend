package com.learning.app.community;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.CommunityDAO;
import com.learning.app.dao.partyForumDAO;

public class CommunityForumCommentDeleteController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		System.out.println(request.getParameter("commentNumber"));
//		System.out.println(request.getParameter("commentNumber").getClass());

		request.setCharacterEncoding("utf-8");
		Gson gson = new Gson();
		CommunityDAO communityDAO = new CommunityDAO();

//		System.out.println(request.getParameter("replyNumber"));

		communityDAO.CommentDelete(Integer.parseInt(request.getParameter("replyNumber")));

		response.setContentType("application/json; charset=utf-8");
		response.getWriter().write(gson.toJson(Map.of("status", "success", "message", "댓글이 성공적으로 삭제되었습니다")));

		return null;
	}

}