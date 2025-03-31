package com.learning.app.partyforum;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.partyForumDAO;
import com.learning.app.dto.PartyForumDTO;
import com.learning.app.dto.UserDTO;

public class PartyForumApplyController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		partyForumDAO partyForumDAO = new partyForumDAO();
		PartyForumDTO partyForumDTO = new PartyForumDTO();
		HttpSession session = request.getSession();
		Gson gson = new Gson();

		// 로그인 상태
		if (session.getAttribute("userDTO") != null) {

			UserDTO userDTO = (UserDTO) session.getAttribute("userDTO");
			partyForumDTO.setUserNumber((userDTO.getUserNumber()));
			partyForumDTO.setForumNumber(Integer.parseInt(request.getParameter("postNum")));

			List<PartyForumDTO> ForumDTO = partyForumDAO
					.getForumDetail(Integer.parseInt(request.getParameter("postNum")));
			int forumUserNum = 0;
			for (PartyForumDTO a : ForumDTO) {
				forumUserNum = a.getUserNumber();
				System.out.println(a);
			}
			int duplication = partyForumDAO.ApplyDuplication(partyForumDTO);

			if (userDTO.getUserNumber() == forumUserNum) {

				response.setContentType("application/json; charset=utf-8");
				response.getWriter().write(gson.toJson(Map.of("status", "fail1", "message", "본인 게시글에는 신청 불가합니다.")));

			} else if (duplication != 0) {
				response.setContentType("application/json; charset=utf-8");
				response.getWriter().write(gson.toJson(Map.of("status", "fail2", "message", "이미 참가 신청 한 게시글 입니다.")));
			}

			else {

				partyForumDAO.partyForumApply(partyForumDTO);

				response.setContentType("application/json; charset=utf-8");
				response.getWriter().write(gson.toJson(Map.of("status", "success", "message", "참가신청 성공")));

			}
		} else {
			System.out.println("여기");
			response.setContentType("application/json; charset=utf-8");
			response.getWriter().write(gson.toJson(Map.of("status", "fail3", "message", "로그인 후 이용가능 합니다.")));

		}

		return null;
	}

}
