package com.learning.app.community;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.CommunityDAO;
import com.learning.app.dao.FileDAO;
import com.learning.app.dao.partyForumDAO;
import com.learning.app.dto.CommunityDTO;
import com.learning.app.dto.FileDTO;
import com.learning.app.dto.PartyForumDTO;

public class CommunityForumDetailController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();

		CommunityDAO communityDAO = new CommunityDAO();
		FileDAO fileDAO = new FileDAO();

		List<FileDTO> files = fileDAO.select(Integer.parseInt(request.getParameter("postNum")));
//		System.out.println("======파일 확인======");
//		System.out.println(files);

		List<CommunityDTO> forumDetail = communityDAO
				.getForumDetail(Integer.parseInt(request.getParameter("postNum")));
		List<CommunityDTO> forumComment = communityDAO
				.getpartyComment(Integer.parseInt(request.getParameter("postNum")));

		request.setAttribute("forumDetail", forumDetail);
		request.setAttribute("forumFiles", files);

		request.setAttribute("forumComment", forumComment);
		System.out.println(forumDetail);


		result.setRedirect(false);
		result.setPath("/app/communityForum/communityForumDetail.jsp");

		return result;
	}

}
