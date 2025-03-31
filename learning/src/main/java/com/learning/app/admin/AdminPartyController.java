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
import com.learning.app.dto.AdminPartyDTO;

public class AdminPartyController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("========== adminParty 컨트롤러 실행 =========");
		AdminDAO adminDAO = new AdminDAO();
		AdminPartyDTO partyDTO = new AdminPartyDTO();

		// 검색된 파티 닉네임 검사
		String searchedPartyNick = request.getParameter("nickname");
		
		if(searchedPartyNick == null) {
			searchedPartyNick = "";
		}
		System.out.println("searchedPartyNick : " + searchedPartyNick);
		
		// 페이징 처리
		String temp = request.getParameter("page");
		int page = (temp == null) ? 1 : Integer.valueOf(temp); // 페이지 번호 기본값 1로 설정
		int rowCount = 10; // 한 페이지당 게시글 수
		int pageCount = 5; // 페이지 버튼 수
		
		int startRow = (page - 1) * rowCount + 1; // 시작행(1, 11, 21)
		int endRow = startRow + rowCount - 1; // 끝 행(10, 20)

		//String 으로 형변환
		String startRowStr = startRow + "";
		String endRowStr = endRow + "";
		
		System.out.println("startRow : " + startRow);
		System.out.println("endRow : " + endRow);
		
		Map<String, String> pageMap = new HashMap<>();
		pageMap.put("startRow", startRowStr);
		pageMap.put("endRow", endRowStr);
		pageMap.put("searchedPartyNick", searchedPartyNick);

		//전체 파티 수 조회
		int totalPartyCount = adminDAO.selectPartyCount(searchedPartyNick);
		System.out.println("전체 파티 수 : " + totalPartyCount);
		
		// 전체 파티 게시글 목록 조회
		List<AdminPartyDTO> adminParty = adminDAO.adminParty(pageMap);
		request.setAttribute("전체 목록 : ", adminParty);
		System.out.println(request.getContextPath());

		// 페이징 정보 설정
		int realEndPage = (int) Math.ceil(totalPartyCount / (double) rowCount);
		int endPage = (int) (Math.ceil(page / (double) pageCount) * pageCount);
		int startPage = endPage - (pageCount - 1);

		startPage = Math.max(startPage, 0);
		endPage = Math.min(endPage, realEndPage);

		// prev, next 버튼 활성화 여부 확인
		boolean prev = startPage > 1;
		boolean next = endPage < realEndPage;

		request.setAttribute("page", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);
		request.setAttribute("nickname", searchedPartyNick);
		
		// result 객체 생성
		Result result = new Result();
		
		//파티 게시글 목록 불러오기 
		request.setAttribute("adminParty", adminParty);
		
		//파티 게시글 수
		request.setAttribute("totalPartyCount", totalPartyCount);
		
		result.setPath("/app/admin/adminParty.jsp");
		result.setRedirect(false);
		return result;
	}

}
