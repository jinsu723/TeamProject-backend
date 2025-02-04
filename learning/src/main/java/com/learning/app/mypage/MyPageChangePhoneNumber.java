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

public class MyPageChangePhoneNumber implements Execute {
	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result rs = new Result();
		MyPageDAO dao = new MyPageDAO();
		HttpSession session = request.getSession();

		String phoneNumber = request.getParameter("phoneNumber");
		System.out.println("phoneNumber : " + phoneNumber);

		String phoneNumberFormat = phoneNumber.substring(0, 3) + "-" + phoneNumber.substring(3, 7) + "-" + phoneNumber.substring(7);

		Map<String, String> map = new HashMap<String, String>();
		map.put("Phone", ((UserDTO) session.getAttribute("userDTO")).getUserPhone());
		map.put("newPhone", phoneNumberFormat);

		System.out.println(map);
		dao.changePhoneNumber(map);
		((UserDTO) session.getAttribute("userDTO")).setUserPhone(phoneNumberFormat);

		session.setAttribute("checkPass", "pass");
		rs.setPath(request.getContextPath() + "/app/myPage/myPageMain.jsp");
		rs.setRedirect(true);
		return rs;
	}
}
