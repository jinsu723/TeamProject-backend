package com.learning.app.community;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learning.app.Result;

public class CommunityFrontController extends HttpServlet {
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
		System.out.println("communityForum 서블릿");
		String target = request.getRequestURI().substring(request.getContextPath().length());
		Result result = null;

		// URL에 따른 요청 분기
		System.out.println("target : " + target);
		switch (target) {

		// 게시글 목록을 불러오기
		case "/app/communityForum/communityForum.cf":
			System.out.println("communityForum");
			result = new CommunityForumFindController().execute(request, response);
			break;

		// 파티모집 글쓰기 페이지로 이동하기
		case "/app/communityForum/communityWriting.cf":
			System.out.println("CommunityWriting");
			result = new CommunityWritingController().execute(request, response);
			break;

		// 파티모집 글쓰기 페이지에서 작성 완료시
		case "/app/communityForum/WritingEnd.cf":
			System.out.println("WritingEnd");
			result = new CommunityWritingEndController().execute(request, response);
			break;
			
			

		// 파티모집 게시판에서 게시글을 클릭했을 때
		case "/app/communityForum/communityForumDetail.cf":
			System.out.println("communityForumDetail");
			result = new CommunityForumDetailController().execute(request, response);
			break;

		// 파티모집 게시판에서 작성자가 게시글을 삭제했을 때
		case "/app/communityForum/communityForumDelete.cf":
			System.out.println("communityForumDelete");
			result = new CommunityForumDeleteController().execute(request, response);
			break;

		// 파티모집 게시판에 게시글에 있는 댓글들 목록 보기
		case "/app/communityForum/communityForumCommentList.cf":
			System.out.println("communityForumCommentList");
			new CommunityForumCommentListController().execute(request, response);
			return;

		// 파티모집 게시판에서 댓글 추가
		case "/app/communityForum/communityForumCommentAdd.cf":
			System.out.println("communityForumCommentAdd");
			new CommunityForumCommentAddController().execute(request, response);
			return;

		// 파티모집 게시판에서 댓글 삭제
		case "/app/communityForum/communityForumCommentDelete.cf":
			System.out.println("communityForumCommentDelete");
			new CommunityForumCommentDeleteController().execute(request, response);
			return;

		case "/app/communityForum/communityForumEdit.cf":
			System.out.println("communityForumEdit");
			result = new CommunityForumEditController().execute(request, response);
			break;

		case "/app/communityForum/communityForumEditEnd.cf":
			System.out.println("communityForumEditEnd");
			result = new CommunityForumEditEndController().execute(request, response);
			break;

		}

		// 결과에 따라 리다이렉트 또는 포워드 처리
		System.out.println("리다이렉트 결과 : " + result.isRedirect() + "   포워딩 경로: " + result.getPath());
		if (result != null) {
			if (result.isRedirect()) {
				response.sendRedirect(result.getPath());
			} else {
				request.getRequestDispatcher(result.getPath()).forward(request, response);
			}
		}
	}
}
