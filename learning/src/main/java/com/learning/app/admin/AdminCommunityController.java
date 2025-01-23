package com.learning.app.admin;

import java.io.IOException;
import java.util.List;

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
      
      System.out.println("adminCommunity 컨트롤러 실행");
      //DAO와 DTO 객체 생성
      AdminDAO admindao = new AdminDAO();
      
      //전체 커뮤니티 게시글 수
      int totalCommunityCount =  admindao.selectCommunityParty();
      System.out.println("전체 커뮤니티 게시글 수 : " + totalCommunityCount);
      //전체 커뮤니티 목록 조회
      List<AdminPartyDTO> adminCommunity = admindao.adminCommunity();
      System.out.println("전체 커뮤니티 목록 : " + adminCommunity);
      System.out.println(request.getContextPath());
      
      //result 객체 생성
      Result result = new Result();
      
      result.setPath(request.getContextPath() + "/app/admin/adminCommunity.jsp");
      result.setRedirect(true);
      
   return result;
}
}
