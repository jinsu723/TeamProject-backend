package com.learning.app.mypage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.MyPageDAO;
import com.learning.app.dto.ForumDTO;
import com.learning.app.dto.MyForumDTO;
import com.learning.app.dto.UserDTO;

public class MyPageMyPost implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result rs = new Result();
		
		HttpSession session = request.getSession();
		UserDTO dto = (UserDTO) session.getAttribute("userDTO");
		session.setMaxInactiveInterval(60 * 60 * 24);

		System.out.println("유저 num : "+dto.getUserNumber());
		List<MyForumDTO> list = new MyPageDAO().myPostList(dto.getUserNumber());
		
		request.setAttribute("posts", list);
		
		rs.setPath("/app/myPage/myPageMyPost.jsp");
		rs.setRedirect(false);
		return rs;
	}
	
	
	
	
}
