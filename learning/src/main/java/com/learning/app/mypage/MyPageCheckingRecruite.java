package com.learning.app.mypage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.MyPageDAO;
import com.learning.app.dto.MyForumDTO;
import com.learning.app.dto.UserDTO;

public class MyPageCheckingRecruite implements Execute {
	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result rs = new Result();

		int userNumber = ((UserDTO) request.getSession().getAttribute("userDTO")).getUserNumber();
		System.out.println("유저 넘버 : " + userNumber);
		List<MyForumDTO> list = new MyPageDAO().checkRecruiting(userNumber);
		System.out.println("모집 현황 1번 : " + list.get(0));
		request.setAttribute("posts", list);
		request.setAttribute("pageType", "모집");

		
		rs.setPath("/app/myPage/myPageRecruitment.jsp");
		rs.setRedirect(false);
		return rs;
	}
}
