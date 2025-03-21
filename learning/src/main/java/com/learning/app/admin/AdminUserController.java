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

         System.out.println("adminUserController 실행");
         //DAO와 DTO 객체 생성
         AdminDAO admindao = new AdminDAO();
         UserDTO userDTO = new UserDTO();
         
         // 검색된 유저 닉네임 검사
         String searchedUserNick = request.getParameter("nickname");
         
         if(searchedUserNick == null) {
        	 searchedUserNick = "";
         }
         
         System.out.println("serchedUserNick : " + searchedUserNick);
         
         // 페이징 처리
         String temp = request.getParameter("page");
         int page = (temp == null) ? 1 : Integer.valueOf(temp);
         int rowCount = 10;
         int pageCount = 5;
         
         int startRow = (page - 1) * rowCount + 1;
         int endRow = startRow + rowCount - 1;
         
         String startRowStr = startRow + "";
         String endRowStr = endRow + "";
         
         System.out.println("startRow : " + startRow);
         System.out.println("endRow : " + endRow);
         
         Map<String, String> pageMap = new HashMap<>();
         pageMap.put("startRow", startRowStr);
         pageMap.put("endRow", endRowStr);
         pageMap.put("searchedUserNick", searchedUserNick);
         
         //전체 회원 수 조회
         int totalUserCount = admindao.selectCount(searchedUserNick);
         System.out.println("전체 회원 수 : " + totalUserCount);
         
         //전체 회원 목록 조회
         List<UserDTO> adminUser = admindao.adminUser(pageMap);
         System.out.println("전체 목록 : " + adminUser);
         System.out.println(request.getContextPath());
         
         // 페이징 정보 설정
         int realEndPage = (int)Math.ceil(totalUserCount / (double)rowCount);
         int endPage = (int)(Math.ceil(page / (double)pageCount) * pageCount);
         int startPage = endPage - (pageCount - 1);
         
         startPage = Math.max(startPage, 0);
         endPage = Math.min(endPage,  realEndPage);
         
         boolean prev = startPage > 1;
         boolean next = endPage < realEndPage;
         
         request.setAttribute("page", page);
         request.setAttribute("startPage", startPage);
         request.setAttribute("endPage", endPage);
         request.setAttribute("prev", prev);
         request.setAttribute("next", next);
         request.setAttribute("nickname", searchedUserNick);

         // result 객체 생성
         Result result = new Result();
         
         //회원 목록 불러오기
         request.setAttribute("adminUser", adminUser);
         
         //회원 수 
         request.setAttribute("totalUserCount", totalUserCount);
         
         result.setRedirect(false);
         result.setPath("/app/admin/adminUser.jsp");
         return result;

   }
   
}
