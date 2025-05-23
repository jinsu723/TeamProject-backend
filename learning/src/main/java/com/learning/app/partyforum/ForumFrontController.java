package com.learning.app.partyforum;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learning.app.Result;

public class ForumFrontController extends HttpServlet {
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
//		System.out.println("partyforum 서블릿");
		String target = request.getRequestURI().substring(request.getContextPath().length());
		Result result = null;

		// URL에 따른 요청 분기
		System.out.println("target : " + target);
		switch (target) {

		// 게시글 목록을 불러오기
		case "/app/partyForum/partyForum.fo":
			System.out.println("partyForum");
			result = new PartyForumFindController().execute(request, response);
			break;

		// 파티모집 글쓰기 페이지로 이동하기
		case "/app/partyForum/partyWriting.fo":
			System.out.println("partyWriting");
			result = new PartyWritingController().execute(request, response);
			break;

		// 파티모집 글쓰기 페이지에서 작성 완료시
		case "/app/partyForum/WritingEnd.fo":
			System.out.println("WritingEnd");
			result = new PartyWritingEndController().execute(request, response);
			break;

		// 파티모집 게시판에서 게시글을 클릭했을 때
		case "/app/partyForum/partyForumDetail.fo":
			System.out.println("partyForumDetail");
			result = new PartyForumDetailController().execute(request, response);
			break;

		// 파티모집 게시판에서 작성자가 게시글을 삭제했을 때
		case "/app/partyForum/partyForumDelete.fo":
			System.out.println("partyForumDelete");
			result = new PartyForumDeleteController().execute(request, response);
			break;

		// 파티모집 게시판에 게시글에 있는 댓글들 목록 보기
		case "/app/partyForum/partyForumCommentList.fo":
			System.out.println("partyForumCommentList");
			new PartyForumCommentListController().execute(request, response);
			return;

		// 파티모집 게시판에서 댓글 추가
		case "/app/partyForum/partyForumCommentAdd.fo":
			System.out.println("partyForumCommentAdd");
			new PartyForumCommentAddController().execute(request, response);
			return;

		// 파티모집 게시판에서 댓글 삭제
		case "/app/partyForum/partyForumCommentDelete.fo":
			System.out.println("partyForumCommentDelete");
			new PartyForumCommentDeleteController().execute(request, response);
			return;

		// 파티모집 게시판 참가신청
		case "/app/partyForum/partyForumApply.fo":
			System.out.println("partyForumApply");
			result = new PartyForumApplyController().execute(request, response);
			return;

		case "/app/partyForum/partyForumEdit.fo":
			System.out.println("partyForumEdit");
			result = new PartyForumEditController().execute(request, response);
			break;

		case "/app/partyForum/partyForumEditEnd.fo":
			System.out.println("partyForumEditEnd");
			result = new PartyForumEditEndController().execute(request, response);
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
