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
import com.learning.app.dao.FileDAO;
import com.learning.app.dao.partyForumDAO;
import com.learning.app.dto.CommunityDTO;
import com.learning.app.dto.FileDTO;
import com.learning.app.dto.PartyForumDTO;
import com.learning.app.dto.UserDTO;

public class CommunityForumEditController implements Execute{
	
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		HttpSession session = request.getSession();
		UserDTO userDTO = (UserDTO) session.getAttribute("userDTO");
		
		CommunityDAO communityDAO = new CommunityDAO();
		FileDAO fileDAO = new FileDAO();

		if (userDTO.getUserNumber() == communityDAO.FindUserNum(Integer.parseInt(request.getParameter("postNum")))) {
			List<CommunityDTO> forumDetail = communityDAO
					.getForumDetail(Integer.parseInt(request.getParameter("postNum")));
			List<FileDTO> fileDTO = fileDAO.select(Integer.parseInt(request.getParameter("postNum")));
			request.setAttribute("forumDetail", forumDetail);
			request.setAttribute("fileDetail", fileDTO);

			result.setRedirect(false);
			result.setPath("/app/communityForum/communityForumEdit.jsp");
		} else {

			result.setRedirect(true);
			result.setPath(request.getContextPath() + "/app/communityForum/communityForum.cf?page=1&FindTitle=");
		}

		return result;
	}

}