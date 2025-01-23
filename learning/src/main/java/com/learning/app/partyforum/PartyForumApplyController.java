package com.learning.app.partyforum;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.partyForumDAO;
import com.learning.app.dto.UserDTO;

public class PartyForumApplyController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();

//      System.out.println((request.getParameter("userId")));
//      System.out.println((request.getParameter("userId")).getClass());
//      System.out.println(request.getParameter("postNum"));
//      System.out.println(request.getParameter("postNum").getClass());

		int postNum = Integer.parseInt(request.getParameter("postNum"));

		partyForumDAO partyForumDAO = new partyForumDAO();
		int userId = partyForumDAO.ApplyUserNum((request.getParameter("userId")));
		HttpSession session = request.getSession();
		UserDTO userDTO = (UserDTO) session.getAttribute("userDTO");

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("userId", userId);
		map.put("postNum", postNum);

		if (userDTO != null) {
			// 로그인 상태
			String userId1 = userDTO.getUserId();
//         System.out.println("User ID: " + userId);

			Map<String, String> map1 = new HashMap<String, String>();
			map1.put("userId", userId1);
			map1.put("postNum", request.getParameter("postNum"));
			int duplication = partyForumDAO.ApplyDuplication(map1);
			if (duplication != 0) {
				result.setRedirect(false);
				result.setPath("/app/partyForum/partyForumDetail.fo?postNum=" + postNum);
			} else {

				partyForumDAO.partyForumApply(map);

				result.setRedirect(false);
				result.setPath("/app/partyForum/partyForumDetail.fo?postNum=" + postNum);
			}
		} else {
			// 비회원/ 로그아웃 상태
		}

		return result;
	}

}
