package com.learning.app.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dto.UserDTO;

public class MyPageCheckPass implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result rs = new Result();

		HttpSession session = request.getSession();
		UserDTO dto = (UserDTO) session.getAttribute("userDTO");
		if (dto == null) {
			rs.setPath(request.getContextPath() + "/app/user/login/login.jsp");
			return rs;
		}
		session.setMaxInactiveInterval(60 * 60 * 24);
		System.out.println(dto.toString());

		if ((dto.getUserPasswd().equals(request.getParameter("password")))) {
			System.out.println("패스워드 true");
			session.setAttribute("checkPass", "pass");
			rs.setPath(request.getContextPath() + "/app/myPage/myPageMain.jsp");
		} else {
			System.out.println("패스워드 false");
			rs.setPath(request.getContextPath() + "/app/myPage/checkPass.jsp");
		}

		rs.setRedirect(true);
		return rs;
	}

}
