package com.learning.app.community;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learning.app.Execute;
import com.learning.app.Result;

public class CommunityDetailDeleteController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("게시글 삭제 요청 받음");
		Result result = new Result();
		
		System.out.println("게시글 삭제 요청. 넘겨받은 값은: "+request.getAttribute("postNum"));
		
		result.setPath("/app/communityForum/communityForum.cf");
		result.setRedirect(false);
		return result;
	}

}
