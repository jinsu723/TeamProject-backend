package com.learning.app.mypage;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.learning.app.Execute;
import com.learning.app.Result;

public class MyPageCheckVerifyCode implements Execute {
	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BufferedReader reader = request.getReader(); // getReader() HTTP 요청 본문을 읽을 수 있는 BufferedReader 반환
		String line = reader.readLine();// JSON 데이터의 첫번째 줄을 읽음
		JsonElement jsonElement = JsonParser.parseString(line);// JsonObject 형태로 변환하여 key-value 값을 추출
		JsonObject jsonObj = jsonElement.getAsJsonObject();
		String userCode = jsonObj.get("code").getAsString();
		System.out.println("code" + userCode);

		HttpSession session = request.getSession();

		String sessionCode = (String) session.getAttribute("verificationCode");
		System.out.println("sessionCode" + sessionCode);

		if (sessionCode != null && sessionCode.equals(userCode)) {
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("{\"success\" : " + true + "}");
			System.out.println("인증 성공");
		} else {
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("{\"success\" : " + false + "}");
			System.out.println("인증 실패");
		}
		return null;
	}
}
