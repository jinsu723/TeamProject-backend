package com.learning.app.partyforum;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.partyForumDAO;
import com.learning.app.dto.partyForumDTO;

public class WritingEndController implements Execute {
	
	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 지금 작성된 것들이 타고 왔음 그러면 내가 게시글제목이랑 게시글 내용을 적어서 서버에 줘야함
		System.out.println("1");
		System.out.println(request.getParameter("forumCategory"));
		System.out.println(request.getParameter("forumTitle"));
		System.out.println(request.getParameter("forumContent"));

		// DAO와 DTO 객체 생성
		partyForumDAO partyforumDAO = new partyForumDAO();
		partyForumDTO partyforumDTO = new partyForumDTO();
		// 결과 객체 생성
		Result result = new Result();

		System.out.println(partyforumDTO);
		partyforumDTO.setUserNumber(1);
//		forumDTO.setForumCategory(request.getParameter("forumCategory"));
//		forumDTO.setForumTitle(request.getParameter("forumTitle"));
//		forumDTO.setForumContent(request.getParameter("forumContent"));
		partyforumDTO.setForumCategory(request.getParameter("자유"));
		partyforumDTO.setForumTitle(request.getParameter("제발"));
		partyforumDTO.setForumContent(request.getParameter("제발요"));

		result.setRedirect(true); // ++++ Result 객체 추가 후 작성
		result.setPath(request.getContextPath()); // ++++ Result 객체 추가 후 작성

		return result;
	}
}
