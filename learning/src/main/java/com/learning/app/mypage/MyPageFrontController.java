package com.learning.app.mypage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learning.app.Result;
import com.learning.app.dto.UserDTO;

/**
 * Servlet implementation class MyPage
 */
@WebServlet("/MyPage")
public class MyPageFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyPageFrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("\nmypage 서블릿");

		String target = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(target);

		Result result = null;

		switch (target) {
		case "/checkPass.my":
			System.out.println("비밀번호 확인");

			result = new MyPageCheckPass().execute(request, response);
			break;

		case "/changeTier.my":
			System.out.println("티어 : " + request.getParameter("tier"));
			System.out.println("유저 넘버 : " + ((UserDTO) request.getSession().getAttribute("userDTO")).getUserNumber());

			result = new MyPageChangeTier().execute(request, response);
			break;

		case "/deleteUser.my":
			System.out.println(request.getRequestURI());
			result = new MyPageDeleteUser().execute(request, response);
			break;

		case "/myPageMyPost.my":
			System.out.println(request.getRequestURI());
			result = new MyPageMyPost().execute(request, response);
			break;

		case "/myPageRecruitment.my":
			System.out.println(request.getRequestURI());
			
			break;
		}
		System.out.println("result : " + result);
		if (result != null) {
			if (result.isRedirect()) {
				System.out.println(result.getPath());
				response.sendRedirect(result.getPath());
			} else {
				System.out.println(result.getPath());
				request.getRequestDispatcher(result.getPath()).forward(request, response);
			}

		}
	}
}
