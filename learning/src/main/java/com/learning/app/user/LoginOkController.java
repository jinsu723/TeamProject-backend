package com.learning.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.UserDAO;
import com.learning.app.dto.UserDTO;

public class LoginOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// DAO와 DTO 객체 생성
		UserDAO dao = new UserDAO();
		UserDTO dto = new UserDTO();
		// 결과 객체 생성
		Result result = new Result();

		// 폼 데이터 가져오기
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		System.out.println(userId + userPw);

		// 데이터베이스에서 사용자 검증
		dto = dao.login(userId, userPw);
		System.out.println(dto);

		if (dto != null) { // 로그인 성공
			System.out.println("로그인 성공");
			// 세션에 사용자 정보 저장
			HttpSession session = request.getSession();
			session.setAttribute("userDTO", dto);
			session.setMaxInactiveInterval(60 * 60 * 24);
			
			// 세션에 사용자 닉네임 저장
			// 로그인 했을 때 헤더에 닉네임을 표시
			session.setAttribute("userNickname", dto.getUserNickname());

			// 메인 페이지로 리다이렉트
//			request.setAttribute("loginNum", 1);
			System.out.println();
			
			request.setAttribute("loginMessage", "로그인 성공!");
			
			result.setPath(request.getContextPath() + "/app/preset/main.jsp");
			result.setRedirect(true);
		} else { // 로그인 실패
			System.out.println("로그인 실패");
			// 로그인 페이지로 포워드
//			request.setAttribute("loginNum", 2);
			request.setAttribute("loginError", "아이디 또는 비밀번호가 올바르지 않습니다.");
			
			result.setPath(request.getContextPath() + "/app/user/login/login.jsp");
			result.setRedirect(true);
		}

		return result;
	}
}
