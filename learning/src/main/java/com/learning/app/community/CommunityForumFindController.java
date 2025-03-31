package com.learning.app.community;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.CommunityDAO;
import com.learning.app.dto.CommunityDTO;

public class CommunityForumFindController implements Execute {
	public Result execute(HttpServletRequest request, HttpServletResponse response) {
//		partyForumDAO partyForumDAO = new partyForumDAO();
		CommunityDAO communityDAO = new CommunityDAO();
		Result result = new Result();

		String FindTitle = request.getParameter("FindTitle");
		String temp = request.getParameter("page");

		int page;
		if (temp == null || temp.isEmpty()) {
			page = 1;
		} else {
			page = Integer.parseInt(temp);
		}

		int rowCount = 10; // 한 페이지당 게시글 수
		int pageCount = 10; // 페이지 버튼 수

		// 페이징을 위한 시작 및 끝 행 계산
		int startRow = (page - 1) * rowCount + 1;
		int endRow = startRow + rowCount - 1;

		// 데이터베이스 조회를 위한 매개변수 설정
		int total = 0;
		List<CommunityDTO> forumList = null;

		if (FindTitle != null && !FindTitle.isEmpty()) {
			// FindTitle 검색 시
			Map<String, Object> pageMap = new HashMap<>();
			pageMap.put("FindTitle", FindTitle);
			pageMap.put("startRow", startRow);
			pageMap.put("endRow", endRow);

			forumList = communityDAO.getForumTitleList(pageMap);
			request.setAttribute("FindTitle", FindTitle);
			total = communityDAO.getFindUserAll(FindTitle);

		} else {
			// FindTitle이 없을 때
			Map<String, Integer> pageMap = new HashMap<>();
			pageMap.put("startRow", startRow);
			pageMap.put("endRow", endRow);

			forumList = communityDAO.getForumList(pageMap);
			total = communityDAO.getFindAll();
		}

		// 전체 게시글 수 조회 및 실제 마지막 페이지 계산
		int realEndPage = (int) Math.ceil(total / (double) rowCount);
		int endPage = (int) (Math.ceil(page / (double) pageCount) * pageCount);
		int startPage = endPage - (pageCount - 1);

		// startPage 최소값 보정
		startPage = Math.max(startPage, 1);
		endPage = Math.min(endPage, realEndPage); // endPage가 realEndPage보다 크면 보정

		// prev, next 버튼 활성화 여부 확인
		boolean prev = startPage > 1;
		boolean next = endPage < realEndPage;

		// JSP에서 사용할 값 설정
		request.setAttribute("forumList", forumList);
		request.setAttribute("page", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);

//        // 디버깅용 출력
//        System.out.println("==== 마지막 확인 ====");
//        System.out.println("FindTitle : " + (FindTitle != null ? FindTitle : "null"));
//        System.out.println("forumList : " + forumList);
//        System.out.println("page : " + page);
//        System.out.println("startPage : " + startPage + ", endPage : " + endPage + ", prev : " + prev + ", next : " + next);
//        System.out.println("====================");

		// 결과 페이지 설정
		result.setRedirect(false);
		result.setPath("communityForum.jsp");

		return result;
	}
}