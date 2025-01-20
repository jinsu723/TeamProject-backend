package com.learning.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learning.app.Result;

public class UserFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 요청 데이터 인코딩 설정
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// URL에서 요청 경로 추출
		System.out.println("user 서블릿");
		String target = request.getRequestURI().substring(request.getContextPath().length());

		Result result = null;

		// URL에 따른 요청 분기
		System.out.println("target : " + target);
		switch (target) {
		case "/loginOk.us":
			System.out.println("login");
			result = new LoginOkController().execute(request, response);
			break;

		case "/logoutOk.us":
			System.out.println("logoutOk");
			result = new LogoutOkController().execute(request, response);
			break;

		// 회원가입 약관 동의 후 다음 버튼 누름
		// forward 방식으로 넘기기 위해 서블릿으로 넘어옴
		case "/signUp1.us":
			System.out.println("signUp1");
			result = new SignUp1Controller().execute(request, response);
			break;

		case "/signUp2.us":
			System.out.println("signUp2");
			result = new SignUp2Controller().execute(request, response);
			break;

		case "/signUp3.us":
			System.out.println("signUp3");
			result = new SignUp3Controller().execute(request, response);
			break;

		case "/signUp4.us":
			System.out.println("signUp4");
			result = new SignUp4Controller().execute(request, response);
			break;

		case "/signUp5.us":
			System.out.println("signUp5");
			result = new SignUp5Controller().execute(request, response);
			break;
			
		case "/nicknameCheck.us":
			System.out.println("닉네임 중복 검사");
			new NicknameCheckController().execute(request, response);
			break;

		case "/idCheck.us":
			System.out.println("아이디 중복 검사");
			new IdCheckController().execute(request, response);
			break;

//		case "/phoneCheck.us":
//			System.out.println("전화번호 중복 검사");
//			new PhoneCheckController().execute(request, response);
//			break;	

		case "/findPass1.us":
			System.out.println("findPassOk");
			break;

		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND); // 잘못된 URL 처리
			return;
		}

		// 결과에 따라 리다이렉트 또는 포워드 처리
		if (result != null) {
			if (result.isRedirect()) {
				System.out.println("Redirect");
				response.sendRedirect(result.getPath());
			} else {
				System.out.println("Forward");
				request.getRequestDispatcher(result.getPath()).forward(request, response);
			}
		} else {
			System.out.println("result=null");
		}
	}
}
