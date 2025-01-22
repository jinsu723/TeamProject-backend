package com.learning.app.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.AdminDAO;

public class AdminMainController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result rs = new Result();
		AdminDAO dao = new AdminDAO();

		// 1일 전 부터 7일 전 까지 데이터
		List<Integer> days = new ArrayList<Integer>();
		for (int i = 7; i > 0; i--) {
			days.add(dao.getPostCount(i));
		}
		System.out.println(days);

//		티어별 카운트
		String[] tierName = { "언랭", "아이언", "브론즈", "실버", "골드", "플래티넘", "에메랄드", "다이아몬드", "마스터", "그랜드마스터", "챌린저" };
		List<Integer> tierList = new ArrayList<Integer>();

		for (int i = 0; i < tierName.length; i++) {
			tierList.add(dao.getTierCount(tierName[i]));
		}
		System.out.println(tierList);
		
		
////		회원-밴 회원 비율 카운트
//		List<Integer> userList = new ArrayList<Integer>();
//
//		for (int i = 0; i < 2; i++) {
//			userList.add(dao.getTierCount(i));
//		}
//		System.out.println(tierList);

//		카테고리별 카운트
		String[] categoryName = { "공략", "자유", "모집" };
		List<Integer> categoryList = new ArrayList<Integer>();

		for (int i = 0; i < categoryName.length; i++) {
			categoryList.add(dao.getCategoryCount(categoryName[i]));
		}
		System.out.println(categoryList);

		request.setAttribute("postCount", days);
		request.setAttribute("tierList", tierList);
		request.setAttribute("categoryList", categoryList);

		rs.setPath("/app/admin/adminMain.jsp");
		rs.setRedirect(false);

		return rs;
	}

}
