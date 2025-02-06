package com.learning.app.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.AdminDAO;
import com.learning.app.dto.UserDTO;

public class AdminSearchUserController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Result result = new Result();
		AdminDAO adminDAO = new AdminDAO();
		
		String userNickname = request.getParameter("userNickname");
		System.out.println(userNickname);
		
		List<UserDTO> searchResult = adminDAO.getSearchUserResult(userNickname);
		System.out.println("검색 결과 : " + searchResult);
		
		request.setAttribute("adminUser", searchResult);
		
		result.setPath("/app/admin/adminUser.jsp");
		result.setRedirect(false);
		
		return result;
	}
	
}
