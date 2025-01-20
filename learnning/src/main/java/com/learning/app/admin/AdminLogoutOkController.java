package com.learning.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learning.app.Execute;
import com.learning.app.Result;

public class AdminLogoutOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("AdminLoginOkController 실행");
		//결과 객체 생성
		Result result = new Result();
		//현재 요청된 세션을 불러온다
		HttpSession session = request.getSession();
		//세션 저장된 데이터 비우기
		session.removeAttribute("adminDTO");
		
		//result에 경로와 리다이렉트 값 담기
		result.setPath(request.getContextPath() + "/app/admin/adminLogin.jsp");
		result.setRedirect(true);
		System.out.println("LogoutOkController 실행 끝");
		
		return result;
	}

	
}
