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

public class CommunityEditOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("게시글 수정 컨트롤러 호출 성공");
		CommunityDTO communityDTO = new CommunityDTO();
		CommunityDAO communityDAO = new CommunityDAO();
		Result result = new Result();
		
		System.out.println("게시글 수정된 PK: "+ request.getParameter("postNum"));
		System.out.println("게시글 수정된 카테고리: "+ request.getParameter("editCategoryText"));
		System.out.println("게시글 수정된 제목: "+ request.getParameter("editTitleText"));
		System.out.println("게시글 수정된 내용: "+ request.getParameter("editContentText"));
		System.out.println("게시글 수정한 유저: "+ request.getParameter("postUserName"));

		int postNumber = Integer.parseInt(request.getParameter("postNum"));
		String editCategory = request.getParameter("editCategoryText");
		String editTitle = request.getParameter("editTitleText");
		String editContent = request.getParameter("editContentText");
		String editUserName = request.getParameter("postUserName");
		
		communityDTO.setForumCategory(editCategory);
		communityDTO.setForumTitle(editTitle);
		communityDTO.setForumContent(editContent);
		communityDTO.setForumNumber(postNumber);
		communityDTO.setUserNickName(editUserName);

		boolean successCode = communityDAO.editMyPost(communityDTO);
		System.out.println(communityDTO.toString());
		if(successCode) {
			System.out.println("게시글 작성 완료");
		} else {
			System.out.println("게시글 작성 실패");
		}

//		request.setAttribute("details", myPost);

		result.setPath("/app/communityForum/communityForumDetail.cf?postNum="+postNumber);
		result.setRedirect(false);

		HttpSession session = request.getSession(false);
		if (session != null) {
			UserDTO userDTO = (UserDTO) session.getAttribute("userDTO");
			if (userDTO != null) {
				request.setAttribute("userCheckLogins", true);
				request.setAttribute("loginUserName", userDTO.getUserNickname());
			} else {
				request.setAttribute("userCheckLogins", false);
				request.setAttribute("loginUserName", false);
			}
		} else {
			System.out.println("세션 불량");
		}

		return result;

	}
}
