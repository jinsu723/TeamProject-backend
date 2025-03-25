package com.learning.app.partyforum;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.partyForumDAO;
import com.learning.app.dto.PartyForumDTO;
import com.learning.app.dto.UserDTO;

public class PartyForumCommentAddController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		partyForumDAO partyforumDAO = new partyForumDAO();
		UserDTO userDTO = (UserDTO) session.getAttribute("userDTO");

//		System.out.println(userDTO.getUserId());

		request.setCharacterEncoding("utf-8");
		Gson gson = new Gson();

		BufferedReader reader = request.getReader();
		JsonObject jsonObject = JsonParser.parseString(reader.lines().collect(Collectors.joining())).getAsJsonObject();

		if (!jsonObject.has("postNum") || !jsonObject.has("userId") || !jsonObject.has("replyContent")) {
			response.setContentType("application/json; charser=utf-8");
			response.getWriter().write(gson.toJson(Map.of("status", "fail", "message", "필수 데이터가 없습니다")));
			return null;
		}

//		Map<String, String> map = new HashMap<String, String>();
//		map.put("postNum", jsonObject.get("postNum").getAsString());
//		map.put("userNum", jsonObject.get("userId").getAsString());
//		map.put("commentContent", jsonObject.get("replyContent").getAsString());

		PartyForumDTO partyForumDTO = new PartyForumDTO();

		int userNumber = partyforumDAO.FindUserNum(jsonObject.get("userId").getAsString());
//		System.out.println(jsonObject.get("postNum").getAsInt());
//		System.out.println(jsonObject.get("userId").getAsString());
//		System.out.println("오류");
//		System.out.println(userNumber);

		partyForumDTO.setForumNumber(jsonObject.get("postNum").getAsInt());
		partyForumDTO.setUserNumber(userNumber);
		partyForumDTO.setCommentContent(jsonObject.get("replyContent").getAsString());

		partyforumDAO.commentAdd(partyForumDTO);

		response.setContentType("application/json; charset=utf-8");
		response.getWriter().write(gson.toJson(Map.of("status", "success", "message", "댓글이 성공적으로 저장되었습니다")));

		return null;
	}

}
