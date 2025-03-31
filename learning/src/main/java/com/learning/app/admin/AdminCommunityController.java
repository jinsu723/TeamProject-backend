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

public class AdminCommunityController implements Execute {
	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("========adminCommunity 컨트롤러 실행============");
		// DAO와 DTO 객체 생성
		AdminDAO admindao = new AdminDAO();
		AdminPartyDTO partydto = new AdminPartyDTO();

		// 검색된 커뮤니티 닉네임 검사
		String searchedCommunityNick = request.getParameter("nickname");
		
		if(searchedCommunityNick == null) {
			searchedCommunityNick = "";
		}
		System.out.println("searchedCommunityNick : " + searchedCommunityNick);
		
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
		pageMap.put("searchedCommunityNick", searchedCommunityNick);

		// 전체 커뮤니티 수 조회
		int totalCommunityCount = admindao.selectCommunityCount(searchedCommunityNick);
		System.out.println("전체 커뮤니티 수 : " + totalCommunityCount);
		
		// 전체 커뮤니티 목록 조회
		List<AdminPartyDTO> adminCommunity = admindao.adminCommunity(pageMap);
		request.setAttribute("전체 목록 : ", adminCommunity);
		System.out.println(request.getContextPath());

		// 페이징 정보 설정
		int realEndPage = (int) Math.ceil(totalCommunityCount / (double) rowCount);
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
		request.setAttribute("nickname", searchedCommunityNick);
		
		System.out.println("====페이징 정보확인====");
		System.out.println("pageMap : " + pageMap);
		System.out.println("adminCommunity : " + adminCommunity);
		System.out.println("startPage : " + startPage + ", endPage : " + endPage + ", prev : " + prev + ", next : " + next);
		System.out.println("====================");

		// result 객체 생성
		Result result = new Result();
		
		//커뮤니티 게시글 목록 불러오기
		request.setAttribute("adminCommunity", adminCommunity);
		
		//커뮤니티 게시글 수
		request.setAttribute("totalCommunityCount", totalCommunityCount);
		
		result.setPath("/app/admin/adminCommunity.jsp");
		result.setRedirect(false);
		return result;
	}
}
