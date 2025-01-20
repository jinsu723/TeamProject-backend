package com.learning.app.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.UserDAO;
import com.learning.app.dto.UserDTO;

public class ManagerUserController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			System.out.println("adminUserController 실행");
			//DAO와 DTO 객체 생성
			UserDAO userdao = new UserDAO();
					
			//전체 회원 수 조회
			int totalUserCount = userdao.selectCount();
			System.out.println("전체 회원 수 : " + totalUserCount);
			//전체 회원 목록 조회
			List<UserDTO> userList = userdao.managerUser();
			System.out.println("전체 목록");
			//결과 객체 생성
			Result result = new Result();
			
			request.setAttribute("totalUserCount", totalUserCount);
			request.setAttribute("userList", userList);
			
			result.setPath(request.getContextPath() + "/app/admin/adminUser.jsp");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException("관리자 페이지 데이터 오류", e);
		}
	}
	
}
