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

public class SignUp1Controller implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 결과 객체 생성
        Result result = new Result();

        System.out.println("sign1");
		// 다음 페이지로 이동
		result.setPath("/app/user/signUp/signUp2.jsp");
		result.setRedirect(false); // 포워드 방식 사용

		return result;
	}

}
