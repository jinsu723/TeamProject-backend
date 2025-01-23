package com.learning.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learning.app.Execute;
import com.learning.app.Result;

public class LogoutOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Result result = new Result();

		HttpSession session = request.getSession();
		System.out.println("로그아웃");

//		// 세션 무효화 전에 로그아웃 메시지 설정
//		session.setAttribute("logoutMessage", "로그아웃되었습니다.");
		// 세션 무효화
		session.invalidate();
		
//		// 메인 페이지로 리다이렉트   
//      result.setPath(request.getContextPath() + "/app/preset/main.jsp");
		
		// 로그아웃 메시지를 URL 파라미터로 전달
//      result.setPath(request.getContextPath() + "/app/preset/main.jsp?logoutMessage=로그아웃되었습니다"); 이건 실패
		result.setPath(request.getContextPath() + "/app/preset/main.jsp?logoutMessage="
				+ java.net.URLEncoder.encode("로그아웃되었습니다", "UTF-8"));

		result.setRedirect(true);//리다이렉트 방식 성공
		System.out.println("로그아웃 성공");
		return result;
//------------------------------------------------------------------
//		// 로그아웃 메시지를 요청에 저장(세션 무효화랑 충돌 안나게 forward 방식으로)
//		request.setAttribute("logoutMessage", "로그아웃되었습니다.");
//
//		// 세션 무효화
//		session.invalidate();
//
//		// 메인 페이지로 포워드
//		result.setPath("/app/preset/main.jsp");
//		result.setRedirect(false); // forward 방식으로 main.jsp로 이동
//		System.out.println("로그아웃 성공");
//----------------------------------------------------------------------
		

	}

}
