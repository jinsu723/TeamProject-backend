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

public class SignUp5Controller implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// DAO와 DTO 객체 생성
		UserDAO dao = new UserDAO();
		UserDTO dto = new UserDTO();
		Result result = new Result();

		// 세션에서 이전 입력 데이터 가져오기
		HttpSession session = request.getSession();
		String userPhone = (String) session.getAttribute("userPhone");
		String userNickname = (String) session.getAttribute("userNickname");
		String userId = (String) session.getAttribute("userId");
		String userPw = (String) session.getAttribute("userPw");

		// 현재 입력 데이터 가져오기
		String userTier = request.getParameter("userTier");

		// DTO에 모든 데이터 설정
		dto.setUserPhone(userPhone);
		dto.setUserNickname(userNickname);
		dto.setUserId(userId);
		dto.setUserPasswd(userPw);
		dto.setUserTier(userTier);

		// 데이터베이스에 저장
		dao.signUp(dto);

		// 회원가입 완료 페이지로 이동
		result.setPath("/app/user/signUp/welcome.jsp");
		result.setRedirect(false); // 포워드 사용

		// 세션 초기화 (선택적)
		session.invalidate();
		request.setAttribute("userNickname", userNickname);

		return result;
	}
}
