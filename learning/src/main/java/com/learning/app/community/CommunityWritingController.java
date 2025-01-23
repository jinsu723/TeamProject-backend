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

public class CommunityWritingController implements Execute {
	
	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("게시글 작성 컨트롤러 호출 성공");
		Result result = new Result();
		result.setPath("/app/communityForum/communityForumWriteing.jsp");
		result.setRedirect(false);
		
		HttpSession session = request.getSession(false);
		if(session != null) {
			UserDTO userDTO = (UserDTO) session.getAttribute("userDTO");
			if(userDTO != null) {
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
