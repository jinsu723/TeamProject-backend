package com.learning.app.community;

import java.io.IOException;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.CommunityDAO;
import com.learning.app.dto.CommunityDTO;


public class CommunityDetailCommentAddController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("댓글 작성 요청 받음");
		System.out.println("게시글 넘버: "+request.getParameter("postNumber"));
		System.out.println("댓글 작성자: "+request.getParameter("commentUser"));
		System.out.println("게시글 댓글 내용: "+request.getParameter("commentText"));
		
		Result result = new Result();
		CommunityDAO communityDAO = new CommunityDAO();
		CommunityDTO communityDTO = new CommunityDTO();
		
		int postNum = Integer.parseInt(request.getParameter("postNumber"));
		String commentText = request.getParameter("commentText");
		String commentUser = request.getParameter("commentUser");
		
		communityDTO.setForumNumber(postNum);
		communityDTO.setUserNickName(commentUser);
		communityDTO.setCommentContent(commentText);

		boolean successCode = communityDAO.commentAddDetail(communityDTO);
		if(successCode) {
			System.out.println("댓글 저장 완료");
		} else {
			System.out.println("댓글 저장 실패");
		}

		result.setPath("/app/communityForum/communityForumDetail.cf?postNum="+postNum);
		result.setRedirect(false);
		return result;
	}

}
