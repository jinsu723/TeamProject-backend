package com.learning.app.mypage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.MyPageDAO;
import com.learning.app.dto.MyForumDTO;
import com.learning.app.dto.UserDTO;

public class MyPageMyRecruitment implements Execute {
	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result rs = new Result();

		List<MyForumDTO> list = new ArrayList<MyForumDTO>();

		int userNumber = ((UserDTO) request.getSession().getAttribute("userDTO")).getUserNumber();
		System.out.println("유저 넘버 : " + userNumber);
		list = new MyPageDAO().myRecruitmentList(userNumber);
		request.setAttribute("posts", list);
		request.setAttribute("pageType", "신청");

		rs.setPath("/app/myPage/myPageRecruitment.jsp");
		rs.setRedirect(false);
		return rs;
	}
}
