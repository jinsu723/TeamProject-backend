package com.learning.app.admin;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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

		BufferedReader reader = request.getReader();
		String line = reader.readLine();
		
		JsonElement jsonElement = JsonParser.parseString(line);
		JsonObject jsonObject = jsonElement.getAsJsonObject();
		
		// 밴 유저 정보 저장
		String userNickname = jsonObject.get("userNickname").getAsString();
		String banReason = jsonObject.get("banReason").getAsString();
		String banPeriod = jsonObject.get("banPeriod").getAsString();
		
		// 벤 유저 정보
		System.out.println("밴 당하는 유저 닉네임 : " + userNickname);
		System.out.println("밴 사유 : " + banReason);
		System.out.println("기간 : " + banPeriod);
		
		// 밴 중복검사
		int checkBen = benDAO.checkBen(userNickname);
		System.out.println(checkBen);
		
		boolean isBen = false;
		if(checkBen == 1) {  // 중복 있음
			isBen = true;
			System.out.println("중복된 밴 유저 있음 : " + checkBen);
			request.setAttribute("isBen", isBen);
			System.out.println("확인 =====" + request.getAttribute("isBen"));
		} else {  // 중복 없음
			isBen = false;
			System.out.println("중복된 밴 유저 없음"+ checkBen);
			request.setAttribute("isBen", isBen);
			System.out.println("확인 =====" + request.getAttribute("isBen"));

			
			Map<String, String> banUser = new HashMap<>();
			
			banUser.put("userNickname", userNickname);
			banUser.put("banReason", banReason);
			banUser.put("banPeriod", banPeriod);
			
			benDTO.setUserNickname(userNickname);
			benDTO.setBenReason(banReason);
			benDTO.setBenPeriod(Integer.parseInt(banPeriod));
			
			benDAO.Ben(benDTO);
			
			benDAO.plusBenCnt(userNickname);
		}
		
		
		return null;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//	
//		benDTO.setBenReason("" + request.getParameter("reason"));
//		benDTO.setBenPeriod(Integer.parseInt(request.getParameter("day")));
//		benDTO.setUserNumber(Integer.parseInt(request.getParameter("pkNum")));
//		
//		System.out.println(benDTO);
//		
//		// 밴 횟수 증가시키기
//		benDAO.plusBenCnt("" + request.getParameter("pkNum"));
//		
//		// 밴 태이블에 회원 추가
//		benDAO.Ben(benDTO);
//		
//		result.setPath(request.getContextPath() + "/adminUser.ad");
//		result.setRedirect(true);
//		
//		System.out.println(request.getContextPath() + "/adminUser.ad");
//		return result;
	}

}
