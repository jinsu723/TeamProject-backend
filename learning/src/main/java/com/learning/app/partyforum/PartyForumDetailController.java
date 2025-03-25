package com.learning.app.partyforum;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.FileDAO;
import com.learning.app.dao.partyForumDAO;
import com.learning.app.dto.FileDTO;
import com.learning.app.dto.PartyForumDTO;

public class PartyForumDetailController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();

		partyForumDAO partyForumDAO = new partyForumDAO();
		FileDAO fileDAO = new FileDAO();

		List<FileDTO> files = fileDAO.select(Integer.parseInt(request.getParameter("postNum")));
//		System.out.println("======파일 확인======");
//		System.out.println(files);

		List<PartyForumDTO> forumDetail = partyForumDAO
				.getForumDetail(Integer.parseInt(request.getParameter("postNum")));
		List<PartyForumDTO> forumComment = partyForumDAO
				.getpartyComment(Integer.parseInt(request.getParameter("postNum")));

		int ApplyNum = partyForumDAO.ApplyNum(request.getParameter("postNum"));

		request.setAttribute("forumDetail", forumDetail);
		request.setAttribute("forumFiles", files);

		request.setAttribute("forumComment", forumComment);
		request.setAttribute("ApplyNum", ApplyNum);

//		System.out.println(ApplyNum);

		result.setRedirect(false);
		result.setPath("/app/partyForum/partyForumDetail.jsp");

		return result;
	}

}
