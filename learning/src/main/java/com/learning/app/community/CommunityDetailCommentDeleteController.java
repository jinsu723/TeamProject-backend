package com.learning.app.community;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.CommunityDAO;

public class CommunityDetailCommentDeleteController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("댓글 삭제 요청 받음");
		Result result = new Result();

		System.out.println("댓글 삭제 요청. 넘겨받은 값은: " + request.getParameter("pk"));
		System.out.println("게시글 값: " + request.getParameter("postNumber"));
		int commentNumber = Integer.parseInt(request.getParameter("pk"));
		int postNum = Integer.parseInt(request.getParameter("postNumber"));
		
		CommunityDAO communityDAO = new CommunityDAO();
		
		communityDAO.commentDeleteDetail(commentNumber);
		System.out.println(commentNumber+"의 댓글 삭제 완료");

		result.setPath("/app/communityForum/communityForumDetail.cf?postNum="+postNum);
		result.setRedirect(false);
		return result;
	}

}
