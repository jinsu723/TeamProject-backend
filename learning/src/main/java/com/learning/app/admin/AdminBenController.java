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
		
		String searchedUserNick = request.getParameter("nickname");
		
		if(searchedUserNick == null) {
			searchedUserNick = "";
		}
		
		System.out.println("serchedUserNick : " + searchedUserNick);
		
		// 페이징 처리
        String temp = request.getParameter("page");
        
        System.out.println("temp : " + temp);
        
        int page = (temp == null) ? 1 : Integer.valueOf(temp);
        int rowCount = 10;
        int pageCount = 5;
        
        int startRow = (page - 1) * rowCount + 1;
        int endRow = startRow + rowCount - 1;
        
        String startRowStr = startRow + "";
        String endRowStr = endRow + "";
        
        System.out.println("startRow : " + startRowStr);
        System.out.println("endRow : " + endRowStr);
        
        Map<String, String> pageMap = new HashMap<>();
        pageMap.put("startRow", startRowStr);
        pageMap.put("endRow", endRowStr);
        pageMap.put("searchedUserNnick", searchedUserNick);
		
        // 밴 된 유저 수 조회
		int benedUserNumber = benDAO.getBenedUsers(searchedUserNick);
		System.out.println("밴된 유저 수 : " + benedUserNumber);
		
		// 밴 된 유저 목록 조회
		List<BenDTO> benList = benDAO.benList(pageMap);
		System.out.println("benList: " + benList);
		
		request.setAttribute("benedUserNumber", benedUserNumber);
		request.setAttribute("benList", benList);
		
		// 페이징 정보 설정
		int realEndPage = (int)Math.ceil(benedUserNumber / (double)rowCount);
		int endPage = (int)(Math.ceil(page / (double)pageCount) * pageCount);
		int startPage = endPage - (pageCount - 1);
		
		startPage = Math.max(startPage, 0);
		endPage = Math.min(endPage,  realEndPage);
		
		boolean prev = startPage > 1;
		boolean next = endPage < realEndPage;
		
		request.setAttribute("page", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);
		request.setAttribute("nickname", searchedUserNick);
		
		result.setPath("/app/admin/adminBanUser.jsp");
		result.setRedirect(false);
		
		
		return result;
	}

}
