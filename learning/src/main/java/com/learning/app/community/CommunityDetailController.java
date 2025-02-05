package com.learning.app.community;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.tag.common.fmt.RequestEncodingSupport;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.CommunityDAO;
import com.learning.app.dao.FileDAO;
import com.learning.app.dto.CommunityDTO;
import com.learning.app.dto.FileDTO;
import com.learning.app.dto.UserDTO;

public class CommunityDetailController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Result result = new Result();
		String communityNumberStr = request.getParameter("postNum"); // borderNumber가 빈문자열이나 Null인 경우

		if (communityNumberStr == null || communityNumberStr.trim().isEmpty()) {
			System.out.println("postNum값이 없습니다.");
			result.setPath("/app/communityForum/communityForum.jsp");
			result.setRedirect(true);
			return result;
		}
		int communityNumber = Integer.parseInt(communityNumberStr);
		CommunityDAO communityDAO = new CommunityDAO();
		CommunityDTO communityDTO = communityDAO.communityDetils(communityNumber);

		FileDAO fileDAO = new FileDAO();

		// 게시글이 존재하지 않는 경우 처리
		if (communityDTO == null) {
			System.out.println("존재하지 않는 게시글: " + communityNumber);
			result.setPath("/app/communityForum/communityForum.jsp");
			result.setRedirect(true);
			return result;
		}
		List<FileDTO> files = fileDAO.select(communityNumber);
		communityDTO.setFiles(files);

		// 로그인한 사용자 번호 가져오기
		if (request.getSession().getAttribute("userDTO") != null) {
			int loginNumberNumber = ((UserDTO) request.getSession().getAttribute("userDTO")).getUserNumber();
			System.out.println("로그인한 맴버 번호: " + loginNumberNumber);
		}

		// 현재 게시글의 작성자 번호 가져오기
		int boardWriterNumber = communityDTO.getUserNumber();
		System.out.println("현재 게시글 작성자 번호: " + boardWriterNumber);

		// 로그인 사용자가 작성자가 아닐 때만 조회수 증가
		/*
		 * if(!Objects.equals(loginNumberNumber, boardWriterNumber)) {
		 * CommunityDAO.updateReadCount(boardNumber); }
		 */

		request.setAttribute("community", communityDTO);
		result.setPath("/app/communityForum/communityForumDetail.jsp");
		result.setRedirect(false);

		return result;
	}

//		int postNumber = Integer.parseInt(request.getParameter("postNum"));
	/*
	 * CommunityDTO communityDTO = new CommunityDTO(); CommunityDAO communityDAO =
	 * new CommunityDAO(); Result result = new Result();
	 * 
	 * List<CommunityDTO> postDetail = communityDAO.communityDetils(postNumber);
	 * List<CommunityDTO> detailComment =
	 * communityDAO.communityDetailComment(postNumber);
	 * 
	 * String cmText = request.getParameter("commentText");
	 * System.out.println("입력된 댓글 값: "+ cmText);
	 * 
	 * int viewPostNumber = postNumber;
	 * System.out.println("해당 게시글 PK값: "+viewPostNumber);
	 * 
	 * request.setAttribute("details", postDetail); request.setAttribute("comments",
	 * detailComment); request.setAttribute("postNum", viewPostNumber);
	 * result.setPath("/app/communityForum/communityForumDetail.jsp");
	 * result.setRedirect(false);
	 * 
	 * HttpSession session = request.getSession(false); if(session != null) {
	 * UserDTO userDTO = (UserDTO) session.getAttribute("userDTO"); if(userDTO !=
	 * null) { request.setAttribute("userCheckLogins", true);
	 * request.setAttribute("loginUserName", userDTO.getUserNickname());
	 * System.out.println("로그인 한 사용자: "+userDTO.getUserNickname()); } else {
	 * request.setAttribute("userCheckLogins", false);
	 * request.setAttribute("loginUserName", false);
	 * System.out.println("로그인 하지 않음"); } } else { System.out.println("세션 불량입니다.");
	 * }
	 * 
	 * return result;
	 * 
	 * }
	 */
}
