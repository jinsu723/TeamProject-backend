package com.learning.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.AdminDAO;
import com.learning.app.dto.AdminDTO;

public class AdminLoginOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    // DAO와 DTO 객체 생성
	    System.out.println("AdminLoginOkController 실행");
	    AdminDAO dao = new AdminDAO();
	    AdminDTO dto;

	    // 폼 데이터 가져오기
	    String adminId = request.getParameter("adminId");
	    String adminPw = request.getParameter("adminPw");
	    System.out.println("입력된 관리자 ID: " + adminId + ", 비밀번호: " + adminPw);

	    // 데이터베이스에서 사용자 검증
	    System.out.println("DAO 호출 전");
	    dto = dao.adminlogin(adminId, adminPw);
	    System.out.println("DAO 호출 후 dto: " + dto);

	    // 결과 객체 생성
	    Result result = new Result();

	    if (dto != null) { // 로그인 성공
	        System.out.println("로그인 성공");
	        HttpSession session = request.getSession();
	        session.setAttribute("adminDTO", dto);
	        result.setPath(request.getContextPath() + "/app/admin/adminMain.jsp");
	        result.setRedirect(true);
	    } else { // 로그인 실패
	        System.out.println("로그인 실패");
	        result.setPath(request.getContextPath() + "/app/admin/adminLogin.jsp");
	        result.setRedirect(true);
	    }

	    System.out.println("Result Path: " + result.getPath());
	    return result;

	}
}

