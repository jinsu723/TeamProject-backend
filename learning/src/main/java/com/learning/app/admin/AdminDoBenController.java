package com.learning.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.BenDAO;
import com.learning.app.dto.BenDTO;

public class AdminDoBenController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("AdminDoBenController");
		
		Result result = new Result();
		BenDAO benDAO = new BenDAO();
		BenDTO benDTO = new BenDTO();
	
		benDTO.setBenReason("" + request.getParameter("reason"));
		benDTO.setBenPeriod(Integer.parseInt(request.getParameter("day")));
		benDTO.setUserNumber(Integer.parseInt(request.getParameter("pkNum")));
		
		System.out.println(benDTO);
		
		// 밴 횟수 증가시키기
		benDAO.plusBenCnt("" + request.getParameter("pkNum"));
		
		// 밴 태이블에 회원 추가
		benDAO.Ben(benDTO);
		
		result.setPath(request.getContextPath() + "/adminUser.ad");
		result.setRedirect(true);
		
		System.out.println(request.getContextPath() + "/adminUser.ad");
		return result;
	}

}
