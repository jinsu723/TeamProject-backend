package com.learning.app.community;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.CommunityDAO;
import com.learning.app.dto.CommunityDTO;
import com.learning.app.dto.UserDTO;

public class CommunityWritingAddController implements Execute {
	
	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("게시글 추가 컨트롤러 호출 성공");
		System.out.println("게시글 카테고리: "+request.getParameter("postCategory"));
		System.out.println("게시글 제목: "+request.getParameter("postTitle"));
		System.out.println("게시글 내용: "+request.getParameter("postContent"));
		System.out.println("게시글 작성자: "+request.getParameter("postUserName"));
		CommunityDTO communityDTO = new CommunityDTO();
		CommunityDAO commuuityDAO = new CommunityDAO();
		Result result = new Result();
		
		String postCategory = request.getParameter("postCategory");
		String postTitle = request.getParameter("postTitle");
		String postContent = request.getParameter("postContent");
		String postUserName = request.getParameter("postUserName");
		
		communityDTO.setForumCategory(postCategory);
		communityDTO.setForumTitle(postTitle);
		communityDTO.setForumContent(postContent);
		communityDTO.setUserNickName(postUserName);
		
		boolean successCode = commuuityDAO.postAddDetail(communityDTO);
		if(successCode) {
			System.out.println("게시글 작성 완료");
		} else {
			System.out.println("게시글 작성 실패");
		}
		
		
		
		
		
		
		result.setPath("/app/communityForum/communityForum.cf");
		result.setRedirect(false);
		
		
		return result;
		
	}
}
