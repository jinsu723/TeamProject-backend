package com.learning.app.partyforum;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.partyForumDAO;
import com.learning.app.dto.UserDTO;
import com.learning.app.dto.partyForumDTO;

public class PartyForumDetailController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();

//		System.out.println(Integer.parseInt(request.getParameter("postNum")));
//		System.out.println((request.getParameter("postNum")).getClass());

		HttpSession session = request.getSession();
		UserDTO userDTO = (UserDTO) session.getAttribute("userDTO");

		partyForumDAO partyForumDAO = new partyForumDAO();
		List<partyForumDTO> forumDetail = partyForumDAO
				.getForumDetail(Integer.parseInt(request.getParameter("postNum")));
		List<partyForumDTO> forumComment = partyForumDAO
				.getpartyComment(Integer.parseInt(request.getParameter("postNum")));
		int duplication = 0;
		if (userDTO != null) {
			// 로그인 상태
			String userId = userDTO.getUserId();
//			System.out.println("User ID: " + userId);

			Map<String, String> map = new HashMap<String, String>();
			map.put("userId", userId);
			map.put("postNum", request.getParameter("postNum"));
			duplication = partyForumDAO.ApplyDuplication(map);
		} else {
			// 비회원/ 로그아웃 상태
		}
		int ApplyNum = partyForumDAO.ApplyNum(request.getParameter("postNum"));

		request.setAttribute("forumDetail", forumDetail);
		request.setAttribute("forumComment", forumComment);
		request.setAttribute("duplication", duplication);
		request.setAttribute("ApplyNum", ApplyNum);

//		System.out.println(duplication);
//		System.out.println(ApplyNum);

		result.setRedirect(false);
		result.setPath("/app/partyForum/partyForumDetail.jsp");

		return result;
	}

}
