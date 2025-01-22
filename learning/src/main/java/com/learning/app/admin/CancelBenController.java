package com.learning.app.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.BenDAO;

public class CancelBenController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("BenCancelController");
		
		BenDAO benDAO = new BenDAO();
		Result result = new Result();
		
		String userNickname = request.getParameter("userNickname");
		
		System.out.println(userNickname);
		
		benDAO.cancelBen(userNickname);
		
		System.out.println("삭제 완료");
		
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
		PrintWriter out = response.getWriter();
//        out.print(jsonResponse);
        out.flush();
		
		return null;
	}

}
