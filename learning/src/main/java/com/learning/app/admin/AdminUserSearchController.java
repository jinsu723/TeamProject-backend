package com.learning.app.admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.AdminDAO;
import com.learning.app.dto.UserDTO;

public class AdminUserSearchController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("AdminUserSearchContoller 실행");
		String nickname = request.getParameter("nickname");
		
		Result result = new Result();
		
		AdminDAO admindao = new AdminDAO();
		UserDTO userDTO = new UserDTO();
		
		// 페이징 처리
		String temp = request.getParameter("page");
		int page = (temp == null) ? 1 : Integer.valueOf(temp);
		int rowCount = 10;
		int pageCount = 5;
		
		int startRow = (page - 1) * rowCount + 1;
		int endRow = startRow = rowCount - 1;
		
		String startRowStr = startRow + "";
		String endRowStr = endRow + "";
		
		Map<String, String> pageMap = new HashMap<>();
		pageMap.put("startRow", startRowStr);
		pageMap.put("endRow", endRowStr);
		pageMap.put("nickname", nickname);
		
		// 검색된 전체 회원 수
		int totalSearchedUserCount = admindao.searchedUserCount();
		System.out.println("검색된 전체 회원 수 : " + totalSearchedUserCount);
		
		// 검색된 회원 목록 조회
		List<UserDTO> adminSearchUser = admindao.adminSearchUser(pageMap);
		System.out.println("전체 목록 : " + adminSearchUser);
		System.out.println(request.getContextPath());
		
		// 페이징 정보 설정
		int realEndPage = (int)Math.ceil(totalSearchedUserCount / (double)rowCount);
		int endPage = (int)(Math.ceil(page / (double)pageCount) * pageCount);
		int startPage = endPage - (pageCount - 1);
		
		startPage = Math.max(startPage, 0);
		endPage = Math.min(endPage, realEndPage);
		
		boolean prev = startPage > 1;
		boolean next = endPage < realEndPage;
		
		request.setAttribute("page", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);
		
		request.setAttribute("adminSearchUser", adminSearchUser);
		request.setAttribute("totalSearchedUserCount", totalSearchedUserCount);
		request.setAttribute("nickname", nickname);
		
		System.out.println(nickname);
		
		result.setRedirect(true);
		result.setPath("/app/admin/adminUser.jsp");
		
		return result;
	}

}
