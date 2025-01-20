package com.learning.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learning.app.Execute;
import com.learning.app.Result;

public class SignUp3Controller implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		 // 결과 객체 생성
        Result result = new Result();

        // 폼 데이터 가져오기
        String userNickname = request.getParameter("userNickname");

        // 세션에 닉네임 저장
        HttpSession session = request.getSession();
        session.setAttribute("userNickname", userNickname);

        // 다음 페이지로 이동
        result.setPath("/app/user/signUp/signUp4.jsp");
        result.setRedirect(false); // 포워드 방식 사용

        return result;
	}
}
