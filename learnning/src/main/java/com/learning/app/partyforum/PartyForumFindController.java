package com.learning.app.partyforum;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learning.app.Result;
import com.learning.app.dao.partyForumDAO;
import com.learning.app.dto.ForumDTO;
import com.learning.app.dto.partyForumDTO;

public class PartyForumFindController {
	public Result getPartyForumList(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();

		// ForumDAO를 통해 게시글 목록 조회
		partyForumDAO partyForumDAO = new partyForumDAO();
		List<partyForumDTO> forumList = partyForumDAO.getForumList();
//		for (ForumDTO a : forumList) {
//			System.out.println(a.getUserNickname());
//			System.out.println(a.getForumTitle());
//			System.out.println(a.getForumContent());
//		}
		System.out.println(forumList.size());

		// 조회된 데이터를 request에 저장하여 JSP에서 사용할 수 있도록 함
		request.setAttribute("partyForumCount", forumList.size());
		request.setAttribute("forumList", forumList);

		// 결과 페이지로 포워드
		result.setRedirect(false);
		result.setPath("partyForum.jsp");

		return result;
	}
}