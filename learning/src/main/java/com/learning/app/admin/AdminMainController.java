package com.learning.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.AdminDAO;
import com.learning.app.dto.AdminDTO;

public class AdminMainController implements Execute{

   @Override
   public Result execute(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      System.out.println("AdminMain컨트롤러 실행");
      //DAO와 DTO 객체 생성
      AdminDAO dao = new AdminDAO();
      AdminDTO dto = new AdminDTO();
      
      
      
      return null;
   }
   
}
