package com.learning.app.community;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learning.app.Result;
import com.learning.app.dao.CommunityDAO;
import com.learning.app.dto.CommunityDTO;

//JSTL로 값을 HTML에 넘겨주고 그걸 JS로 넘겨준다
//JAVA>JSTL>HTML>Javscript순으로 적용이 된다 
public class CommunityFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CommunityFrontController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Community 프론트 컨트롤러 실행");
		String target = request.getRequestURI().substring(request.getContextPath().length());
		Result result = null;
		int postNum = 0;
		System.out.println("target: " + target);
		
		switch (target) {
		case "/app/communityForum/communityForum.cf":
			System.out.println("커뮤니티 게시글 페이지로 이동");
			result = new CommunityListController().execute(request, response);
			break;
			
		case "/app/communityForum/communityForumDetail.cf":
			System.out.println("상세글 값 넘겨주기: "+request.getParameter("postNum"));
			postNum = Integer.parseInt(request.getParameter("postNum"));
			result = new CommunityDetailController().execute(request, response);
			break;
		case "/app/communityForum/communityForumDetailDelete.cf":
			System.out.println("게시글 삭제 후 리스트 페이지로 이동 함수 실행");
			System.out.println("삭제 값 넘겨주기: "+request.getParameter("postNum"));
			
			result = new CommunityDetailDeleteController().execute(request, response);
			break;
		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		if (result != null) {
			if (result.isRedirect()) {
				response.sendRedirect(result.getPath());
			} else {
				request.getRequestDispatcher(result.getPath()).forward(request, response);
			}
		}
	}
}
//
