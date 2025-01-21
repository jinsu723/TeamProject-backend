package com.learning.app.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.BenDAO;
import com.learning.app.dto.BenDTO;

public class AdminBenController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("AdminBenController");
		
		Result result = new Result();
		BenDTO benDTO = new BenDTO();
		BenDAO benDAO = new BenDAO();
		
		int benedUserNumber = benDAO.getBenedUsers();
		System.out.println("밴된 유저 수 : " + benedUserNumber);
		
		List<BenDTO> benList = benDAO.benList();
		
		System.out.println(benList);
		
		request.setAttribute("benedUserNumber", benedUserNumber);
		request.setAttribute("benList", benList);
		
		result.setPath("/app/admin/adminBanUser.jsp");
		result.setRedirect(false);
		
		return result;
	}

}
