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
			// 밴 테이블에 올라가있는지 확인
			if (dao.checkBen(dto.getUserNumber()) > 0) {
				System.out.println("밴 유저");
				request.setAttribute("loginMessage", "밴 유저");
				result.setPath("/app/user/login/login.jsp");
				result.setRedirect(false);
				return result;
			}

			System.out.println("로그인 성공");
			HttpSession session = request.getSession();
			session.setAttribute("userDTO", dto);
			session.setMaxInactiveInterval(60 * 60 * 24); // 세션 유지 시간 설정
			session.setAttribute("userNickname", dto.getUserNickname());

			// 로그인 성공 메시지 전달

//	            //포워드 방식
//	            request.setAttribute("loginMessage", "로그인 성공!");
//	            result.setPath("/app/preset/main.jsp"); // forward 방식으로 main.jsp로 이동
//	            result.setRedirect(false);
			// 리다이렉트 방식
			session.setAttribute("loginMessage", "로그인 성공!");
			result.setPath(request.getContextPath() + "/app/preset/main.jsp");
			result.setRedirect(true);
		} else { // 로그인 실패
			// 포워드 방식
			System.out.println("로그인 실패");
			request.setAttribute("loginMessage", "아이디 또는 비밀번호가 올바르지 않습니다.");
			result.setPath("/app/user/login/login.jsp");
			result.setRedirect(false);

			// 리다이렉트 방식
//	            System.out.println("로그인 실패");
//	            HttpSession session = request.getSession();
//	            session.setAttribute("loginMessage", "아이디 또는 비밀번호가 올바르지 않습니다."); // 메시지 전달
//	            result.setPath(request.getContextPath() + "/app/user/login/login.jsp"); // 리다이렉트
//	            result.setRedirect(true);
		}

		return result;
	}
}
