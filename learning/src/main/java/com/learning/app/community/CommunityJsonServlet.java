package com.learning.app.community;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.learning.app.Result;
import com.learning.app.dao.CommunityDAO;
import com.learning.app.dto.CommunityDTO;

/**
 * Servlet implementation class CommunityJsonServlet
 */
//@WebServlet("/CommunityJsonServlet")
public class CommunityJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CommunityJsonServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * response.setContentType("application/json");
		 * response.setCharacterEncoding("UTF-8");
		 * 
		 * CommunityDAO communityDAO = new CommunityDAO(); // 객체 생성 CommunityDTO
		 * communityDTO = new CommunityDTO(); // 객체 생성 Result result = new Result();
		 * //Gson gson = new Gson(); Gson gson = new
		 * GsonBuilder().setPrettyPrinting().create(); int communityPostCount =
		 * communityDAO.communityPostCount();
		 * 
		 * //System.out.println("총 게시글: "+communityDAO.communityPostCount()); //DB에 저장된
		 * 게시글 가져오기 List<CommunityDTO> posts = communityDAO.getCommunityPosts(); // DB에
		 * 저장된 tbl_forum 컬럼을 목록화(리스트 사용) String postJson = gson.toJson(posts);
		 * System.out.println(gson.toJson(posts));
		 * 
		 * // response.getWriter().write(postJson); PrintWriter out =
		 * response.getWriter(); out.print(postJson); out.flush();
		 * System.out.println("JSON값 표시전용 서블릿");
		 */
	}

}