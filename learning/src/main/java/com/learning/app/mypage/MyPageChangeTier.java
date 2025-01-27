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

public class MyPageChangeTier implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result rs = new Result();
		HttpSession session = request.getSession();

		Map<String, String> map = new HashMap<String, String>();
		map.put("tier", request.getParameter("tier"));
		map.put("userNum", ((UserDTO) session.getAttribute("userDTO")).getUserNumber() + "");
		request.setAttribute("update", new MyPageDAO().chageTier(map));

		System.out.println("티어 업데이트 : " + request.getAttribute("update"));
		((UserDTO) session.getAttribute("userDTO")).setUserTier(request.getParameter("tier"));

		System.out.println("userDTO : " + session.getAttribute("userDTO"));

		session.setAttribute("checkPass", "pass");
		rs.setPath(request.getContextPath() + "/app/myPage/myPageMain.jsp");
		rs.setRedirect(true);
		return rs;
	}

}
