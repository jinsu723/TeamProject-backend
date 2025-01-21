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

public class FindPass1Controller implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// DAO 객체 생성
		UserDAO userDAO = new UserDAO();

		// 결과 객체 생성
		Result result = new Result();

		// 폼 데이터 가져오기
		String userPhone = request.getParameter("userPhone");

		// 전화번호로 사용자 정보 조회
		UserDTO userDTO = userDAO.findUserByPhone(userPhone);

		if (userDTO != null) { // 사용자 정보가 존재하면
			// 세션에 전화번호 저장
			HttpSession session = request.getSession();
			session.setAttribute("userPhone", userPhone); // 인증된 전화번호 저장
			
			// 요청에 인증 완료 메시지 저장
		    request.setAttribute("message", "인증이 완료되었습니다.");
		    
			// 다음 페이지로 이동
			result.setPath("/app/user/findPass/findPass2.jsp"); // 비밀번호 입력 페이지
			result.setRedirect(false); // forward 방식
		} else {
			// 전화번호가 등록되지 않은 경우
			request.setAttribute("checkPhone", 0); // 인증 실패 메시지 설정
			result.setPath("/app/user/findPass/findPass1.jsp");
			result.setRedirect(false); // forward 방식
		}

		return result;
	}
}
