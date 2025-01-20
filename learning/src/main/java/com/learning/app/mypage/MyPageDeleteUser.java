package com.learning.app.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.MyPageDAO;
import com.learning.app.dto.UserDTO;

public class MyPageDeleteUser implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Result rs = new Result();

		System.out.println(new MyPageDAO().deleteUser(((UserDTO) session.getAttribute("userDTO")).getUserNumber()));

		rs.setPath(request.getContextPath()+"/app/myPage/myPageWithdraw.jsp");
		rs.setRedirect(true);
		return rs;
	}

}
