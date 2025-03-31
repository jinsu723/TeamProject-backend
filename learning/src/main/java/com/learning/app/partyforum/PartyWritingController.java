package com.learning.app.partyforum;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dto.UserDTO;

public class PartyWritingController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();

		HttpSession session = request.getSession();
		UserDTO userDTO = (UserDTO) session.getAttribute("userDTO");

		if (userDTO == null) {
			
			result.setRedirect(true);
			result.setPath(request.getContextPath() + "/app/partyForum/partyForum.fo?page=1&FindTitle=");

		} else {

			result.setRedirect(false);
			result.setPath("/app/partyForum/partyForumWriting.jsp");

		}

		return result;
	}

}
