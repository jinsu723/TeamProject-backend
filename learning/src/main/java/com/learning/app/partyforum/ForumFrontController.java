package com.learning.app.partyforum;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learning.app.Result;

public class ForumFrontController extends HttpServlet{
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
		System.out.println("partyforum 서블릿");
		String target = request.getRequestURI().substring(request.getContextPath().length());

		Result result = null;

		// URL에 따른 요청 분기
		System.out.println("target : " + target);
		switch (target) {
		case "/app/partyForum/partyWriting.fo":
			System.out.println("partyWriting");
			request.getRequestDispatcher("/app/partyForum/partyForumWriting.jsp").forward(request, response);
			break;
		case "/app/partyForum/WritingEnd.fo":
			System.out.println("WritingEnd");
			result = new WritingEndController().execute(request, response);

			break;
			
        case "/app/partyForum/partyForum.fo": // 게시글 목록을 보여주는 URL
            result = new PartyForumFindController().getPartyForumList(request, response); // 게시글 목록 조회 서비스 호출
            System.out.println("나오냐");
            break;
            
		case "/app/user/login/findPassOk.us":
			System.out.println("find pass");

			break;
		}

		// 결과에 따라 리다이렉트 또는 포워드 처리
		System.out.println(result);
		System.out.println(result.isRedirect());
		System.out.println("포워딩 경로: " + result.getPath());
		if (result != null) {
			if (result.isRedirect()) {
				response.sendRedirect(result.getPath());
			} else {
				request.getRequestDispatcher(result.getPath()).forward(request, response);
			}
		}
	}
}
