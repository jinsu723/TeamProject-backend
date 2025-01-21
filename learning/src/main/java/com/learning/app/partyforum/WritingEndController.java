package com.learning.app.partyforum;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.partyForumDAO;
import com.learning.app.dto.UserDTO;
import com.learning.app.dto.partyForumDTO;

public class WritingEndController implements Execute {
	
	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 지금 작성된 것들이 타고 왔음 그러면 내가 게시글제목이랑 게시글 내용을 적어서 서버에 줘야함
		System.out.println(request.getParameter("forumTitle"));
		System.out.println(request.getParameter("forumContent"));
		
		HttpSession session = request.getSession();
		UserDTO userDTO = (UserDTO)session.getAttribute("userDTO");
		
		System.out.println(userDTO);
		
		System.out.println(userDTO.getUserId());
		System.out.println(userDTO.getUserTier());

		// DAO와 DTO 객체 생성
		System.out.println("오류");
		partyForumDAO partyforumDAO = new partyForumDAO();
		System.out.println("오류");
		partyForumDTO partyforumDTO = new partyForumDTO();
		System.out.println("오류");
		// 결과 객체 생성
		Result result = new Result();
		
//        INSERT INTO tbl_forum (forum_number, user_number, forum_category, forum_title, forum_date, forum_update, forum_content)

		partyforumDTO.setUserNumber(userDTO.getUserNumber());
		partyforumDTO.setuserTier(userDTO.getUserTier());
		partyforumDTO.setForumTitle(request.getParameter("forumTitle"));
		partyforumDTO.setForumContent(request.getParameter("forumContent"));
		
		partyforumDAO.WritingEnd(partyforumDTO);

		result.setRedirect(true); // ++++ Result 객체 추가 후 작성
		result.setPath(request.getContextPath()); // ++++ Result 객체 추가 후 작성

		return result;
	}
}
