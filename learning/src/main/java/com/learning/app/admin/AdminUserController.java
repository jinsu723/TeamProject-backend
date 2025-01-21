package com.learning.app.admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.AdminDAO;
import com.learning.app.dto.UserDTO;

public class AdminUserController implements Execute {

   @Override
   public Result execute(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
//      try {
         System.out.println("adminUserController 실행");
         //DAO와 DTO 객체 생성
         AdminDAO admindao = new AdminDAO();         
         
         //전체 회원 수 조회
         int totalUserCount = admindao.selectCount();
         System.out.println("전체 회원 수 : " + totalUserCount);
         //전체 회원 목록 조회
         List<UserDTO> adminUser = admindao.adminUser();
         System.out.println("전체 목록 : " + adminUser);
         System.out.println(request.getContextPath());

         
         //전체 회원 목록에서 닉네임으로 검색하기
         //검색어 닉네임 파라미터 받아오기
         String nickname = request.getParameter("nickname");
         //닉네임을 map에 넣기
         Map<String, Object> paramMap = new HashMap<>();
         paramMap.put("nickname", nickname);
         System.out.println("닉네임 검색 완료 : " + paramMap);
         
         // 닉네님이 존재하면 해당 닉네임으로 회원 검색하기
         List<UserDTO> adminUserNN = admindao.nickNameSearch(paramMap);
         
         // result 객체 생성
         Result result = new Result();
         
         //회원 목록 불러오기
         request.setAttribute("adminUser", adminUser);
         
         //회원 수 
         request.setAttribute("totalUserCount", totalUserCount);
         
         result.setRedirect(false);
         result.setPath("/app/admin/adminUser.jsp");
         return result;
//      } catch (Exception e) {
//         e.printStackTrace();
//         throw new ServletException("관리자 페이지 데이터 오류", e);
//      }
   }
   
}
