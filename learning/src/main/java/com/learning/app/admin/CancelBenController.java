package com.learning.app.admin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.BenDAO;

public class CancelBenController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("BenCancelController");
		
		BenDAO benDAO = new BenDAO();
		Result result = new Result();
		
		BufferedReader reader = request.getReader();
		String line = reader.readLine();
		
		JsonElement jsonElement = JsonParser.parseString(line);
		JsonObject jsonObject = jsonElement.getAsJsonObject();
		
		String userNickname = jsonObject.get("userNickname").getAsString();
		
		System.out.println("취소 유저 닉네임 : " + userNickname);
		
		benDAO.cancelBen(userNickname);
		
		System.out.println("삭제 완료");
		
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
		PrintWriter out = response.getWriter();
//        out.print(jsonResponse);
        out.flush();
        
		return null;
	}

}
