package com.learning.app.community;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.CommunityDAO;
import com.learning.app.dto.CommunityDTO;
import com.learning.app.dto.UserDTO;

public class CommunityListController implements Execute {
	
	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("리스트 불러오기 실행");
	
		CommunityDAO communityDAO = new CommunityDAO();	//객체 생성
		CommunityDTO communityDTO = new CommunityDTO();	//객체 생성
		Result result = new Result();
		HttpSession session = request.getSession(false);
		int communityPostCount = communityDAO.communityPostCount();
		System.out.println("총 게시글: "+communityDAO.communityPostCount()); //DB에 저장된 게시글 가져오기
		List<CommunityDTO> posts = communityDAO.getCommunityPosts(); //DB에 저장된 tbl_forum 컬럼을 목록화(리스트 사용)
		request.setAttribute("communityPostCount", communityPostCount);
		request.setAttribute("posts", posts);
//		result.setPath(request.getContextPath() + "/app/communityForum/communityForum.jsp");
		result.setPath("/app/communityForum/communityForum.jsp");
		result.setRedirect(false);
		System.out.println("경로 테스트: "+request.getContextPath());
		System.out.println("리스트 페이지로 이동");
		
		if(session != null) {
			UserDTO userDTO = (UserDTO) session.getAttribute("userDTO");
			if(userDTO != null) {
				request.setAttribute("userCheckLogins", true);
				System.out.println("로그인 한 사용자: "+userDTO.getUserNickname());
			} else {
				request.setAttribute("userCheckLogins", false);
				System.out.println("로그인 하지 않음");
			}
		} else {
			System.out.println("세션 불량입니다.");
		}
		
		return result;
		
	}
}
