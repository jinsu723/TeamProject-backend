package com.learning.app.community;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.CommunityDAO;
import com.learning.app.dto.CommunityDTO;
import com.learning.app.dto.UserDTO;

class Person {
	String name;
	int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
}

public class CommunityDetailController implements Execute {
	
	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("커뮤니티 상세페이지 게시글 이동 자바 파일 실행");
		String json = "{\"name\":\"John\",\"age\":30}";
		
		Gson gson = new Gson(); //JS에서 넘어온 값을 JSON방식으로 처리하기 위한 객체 생성
		Person person = gson.fromJson(json, Person.class);
		Result result = new Result();
		
		System.out.println("name: "+ person.name);
		System.out.println("age: "+ person.age);
		
		result.setPath("/app/communityForum/communityForumDetail.jsp");
		result.setRedirect(false);
		
		
		return result;
		
	}
}
