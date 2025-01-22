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

public class AdminPartyController implements Execute {
   
   @Override
   public Result execute(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
   
      System.out.println("adminPartyForum컨트롤러 실행 =========");
      //DAO와 DTO 객체 생성
      AdminDAO admindao = new AdminDAO();
      
      //전체 게시글 수
      int totalPartyForumCount = admindao.selectPartyForumCount();
      System.out.println("전체 게시글 수  : " + totalPartyForumCount);
      
      //전체 게시글 목록 조회
      List<AdminPartyDTO> adminParty = admindao.adminParty();
      System.out.println("전체 게시글 목록 : " + adminParty);
      System.out.println(request.getContextPath());
      
      //result 객체 생성
      Result  result = new Result();
      
      //전체 게시글 목록
      request.setAttribute("adminParty", adminParty);
      
      //게시글 수 
      request.setAttribute("totalPartyForumCount", totalPartyForumCount);
      
      result.setRedirect(false);
      result.setPath("/app/admin/adminParty.jsp");
      return result;
      
   }
}
