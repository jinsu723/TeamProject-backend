package com.learning.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learning.app.Result;

public class AdminFrontController extends HttpServlet {
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
		System.out.println("admin 서블릿");
		String target = request.getRequestURI().substring(request.getContextPath().length());

		Result result = null;

		// URL에 따른 요청 분기
		System.out.println("target : " + target);
		switch (target) {
//		/app/user/login
		case "/adminloginOk.ad":
			System.out.println("login");
			result = new AdminLoginOkController().execute(request, response);
			break;

		case "/adminlogoutOk.ad":
			System.out.println("logout");
			result = new AdminLogoutOkController().execute(request, response);
			break;

		case "/adminMain.ad":
			System.out.println("관리자 메인 페이지");
			result = new AdminMainController().execute(request, response);
			break;

		// 전체 회원 목록 조회
		case "/adminUser.ad":
			System.out.println("회원 목록 조회");
			result = new AdminUserController().execute(request, response);
			break;

		case "/adminParty.ad":
			System.out.println("게시글 목록 조회");
			result = new AdminPartyController().execute(request, response);
			break;

		case "/adminCommunity.ad":
			System.out.println("커뮤니티 게시글 목록");
			result = new AdminCommunityController().execute(request, response);
			break;

			// 밴 된 회원 목록 조회
		case "/ben.ad":
			System.out.println("ben");
			result = new AdminBenController().execute(request, response);
			break;

		// 밴 취소
		case "/cancelBen.ad":
			System.out.println("cancelBan.ad");
			new CancelBenController().execute(request, response);
			break;

		// 밴
		case "/adminDoBen.ad":
			System.out.println("adminDoBen.ad");
			result = new AdminDoBenController().execute(request, response);
			break;

		case "/searchUser.ad":
			System.out.println("searchUser.ad");
			result = new AdminSearchUserController().execute(request, response);
			break;

		case "/deleteForum.ad":
			System.out.println("deleteForum.ad");
			new AdminDeleteForumController().execute(request, response);
			break;
			
		case "/adminUserSearch.ad":
			System.out.println("UserSearch.ad");
			result = new AdminUserSearchController().execute(request, response);
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
