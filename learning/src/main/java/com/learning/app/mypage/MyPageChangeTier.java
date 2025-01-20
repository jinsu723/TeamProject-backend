package com.learning.app.mypage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.MyPageDAO;
import com.learning.app.dto.UserDTO;

public class MyPageChangeTier implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result rs = new Result();

		Map<String, String> map = new HashMap<String, String>();
		map.put("tier", request.getParameter("tier"));
		map.put("userNum", ((UserDTO) request.getSession().getAttribute("userDTO")).getUserNumber() + "");
		request.setAttribute("update", new MyPageDAO().chageTier(map));

		System.out.println("티어 업데이트 : " + request.getAttribute("update"));
		((UserDTO)request.getSession().getAttribute("userDTO")).setUserTier(request.getParameter("tier"));
		System.out.println("userDTO : " + request.getSession().getAttribute("userDTO"));
		rs.setPath(request.getContextPath() + "/app/myPage/myPageMain.jsp");
		rs.setRedirect(true);
		return rs;
	}

}
