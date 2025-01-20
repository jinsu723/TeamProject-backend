package com.learning.app.mypage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.MyPageDAO;
import com.learning.app.dto.UserDTO;

public class MyPageNickName implements Execute {
	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result rs = new Result();
		MyPageDAO dao = new MyPageDAO();

		HttpSession session = request.getSession();
		UserDTO dto = (UserDTO) session.getAttribute("userDTO");
		System.out.println("변경 전 닉네임 : " + dto.getUserNickname());
		System.out.println("변경 할 닉네임 : " + request.getParameter("newNick"));
		int result = dao.checkNick(request.getParameter("newNick"));

		if (result >= 1) {
			System.out.println("닉네임 중복");
			request.setAttribute("nickChanged", "false");
		} else {
			request.setAttribute("nickChanged", "true");
			Map<String, String> nick = new HashMap<String, String>();
			nick.put("nick", dto.getUserNickname());
			nick.put("newNick", request.getParameter("newNick"));
			dao.changeNick(nick);
			System.out.println("닉네임 변경 완료");
			dto.setUserNickname(request.getParameter("newNick"));
		}

		rs.setPath("/app/myPage/myPageMain.jsp");
		rs.setRedirect(false);
		return rs;
	}
}
