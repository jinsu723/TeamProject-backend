package com.learning.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learning.app.Execute;
import com.learning.app.Result;

public class LogoutOkController implements Execute{

   @Override
   public Result execute(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      
      Result result = new Result();
      
      HttpSession session = request.getSession();
      System.out.println("로그아웃");
      
      session.invalidate();
      
      result.setPath(request.getContextPath() + "/app/preset/main.jsp");
      result.setRedirect(true);
      System.out.println("로그아웃 성공");
      
      return result;
   }

}
