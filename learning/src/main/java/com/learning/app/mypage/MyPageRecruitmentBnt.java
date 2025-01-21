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

public class MyPageRecruitmentBnt implements Execute {
	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result rs = new Result();

		int partyNum = Integer.parseInt(request.getParameter("partyNum"));
		if (request.getParameter("isAgree").equals("true")) {
			new MyPageDAO().recruiteAgree(partyNum);
			System.out.println("수락 완");
		} else {
			new MyPageDAO().recruiteDisagree(partyNum);
			System.out.println("거절 완");
		}

		request.setAttribute("pageType", "모집");
		rs.setPath(request.getContextPath() + "/myPageCheckRecruite.my");
		rs.setRedirect(true);
		return rs;
	}
}
