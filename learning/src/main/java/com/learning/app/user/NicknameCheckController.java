package com.learning.app.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.UserDAO;

public class NicknameCheckController implements Execute {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        String nickname = request.getParameter("userNickname");
        boolean isDuplicate = userDAO.checkNickname(nickname);

        response.setContentType("application/json; charset=UTF-8");
        response.getWriter().write("{\"isDuplicate\": " + isDuplicate + "}");
        return null; // AJAX 요청이므로 별도의 페이지 이동 없음
    }
}
