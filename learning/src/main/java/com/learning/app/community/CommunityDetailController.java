package com.learning.app.community;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.CommunityDAO;
import com.learning.app.dto.CommunityDTO;
import com.learning.app.dto.UserDTO;

public class CommunityDetailController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("커뮤니티 상세페이지 게시글 이동 자바 파일 실행");
		System.out.println("값 넘겨받음: "+request.getParameter("postNum"));
		int postNumber = Integer.parseInt(request.getParameter("postNum"));
		CommunityDTO communityDTO = new CommunityDTO();
		CommunityDAO communityDAO = new CommunityDAO();
		Result result = new Result();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		List<CommunityDTO> postDetail = communityDAO.communityDetils(postNumber);
		List<CommunityDTO> detailComment = communityDAO.communityDetailComment(postNumber);
		
		System.out.println("===상세게시글==="+gson.toJson(postDetail));
		System.out.println("===댓글==="+gson.toJson(detailComment));
		
		
		
		int viewPostNumber = postNumber;
		System.out.println("해당 게시글 PK값: "+viewPostNumber);
		
		
		/*
		 * for (CommunityDTO detail : postDetail) { System.out.println("게시글 상세 정보:");
		 * System.out.println("포럼 번호: " + detail.getForumNumber());
		 * System.out.println("카테고리: " + detail.getForumCategory());
		 * System.out.println("제목: " + detail.getForumTitle());
		 * System.out.println("날짜: " + detail.getForumDate());
		 * System.out.println("내용: "+ detail.getForumContent());
		 * System.out.println("댓글 번호: " + detail.getCommentNumber());
		 * System.out.println("댓글 내용: " + detail.getCommentContent());
		 * System.out.println("댓글 날짜: " + detail.getCommentDate());
		 * System.out.println("작성자 닉네임: " + detail.getUserNicname());
		 * System.out.println("댓글: " + detail.getCommentContent()); }
		 */
		 
		
		request.setAttribute("details", postDetail);
		request.setAttribute("comments", detailComment);
		request.setAttribute("postNum", viewPostNumber);


		result.setPath("/app/communityForum/communityForumDetail.jsp");
		result.setRedirect(false);
		
		HttpSession session = request.getSession(false);
		if(session != null) {
			UserDTO userDTO = (UserDTO) session.getAttribute("userDTO");
			if(userDTO != null) {
				request.setAttribute("loginUserName", userDTO.getUserNickname());
				System.out.println("로그인 한 사용자: "+userDTO.getUserNickname());
			} else {
				request.setAttribute("loginUserName", false);
				System.out.println("로그인 하지 않음");
			}
		} else {
			System.out.println("세션 불량입니다.");
		}

		return result;

	}
}
