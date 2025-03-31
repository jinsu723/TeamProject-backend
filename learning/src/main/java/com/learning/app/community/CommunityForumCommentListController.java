package com.learning.app.community;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.CommunityDAO;
import com.learning.app.dao.partyForumDAO;

public class CommunityForumCommentListController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int postNum = Integer.valueOf(request.getParameter("postNum"));
		System.out.println("게시글 번호 : " + postNum);
		CommunityDAO communityDAO = new CommunityDAO();
		Gson gson = new Gson();
		JsonArray comments = new JsonArray();

		communityDAO.getpartyComment(postNum).stream().map(gson::toJson).map(JsonParser::parseString)
				.forEach(comments::add);

		System.out.println("게시글 목록 조회 : " + comments.toString());

		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(comments.toString());
		out.close();

		return null;
	}

}