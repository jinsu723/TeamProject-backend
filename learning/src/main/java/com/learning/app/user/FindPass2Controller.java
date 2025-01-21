package com.learning.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.UserDAO;
import com.learning.app.dto.UserDTO;

public class FindPass2Controller implements Execute {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 결과 객체 생성
        Result result = new Result();
        HttpSession session = request.getSession();

        // 세션에서 인증된 전화번호 가져오기
        String userPhone = (String) session.getAttribute("userPhone");

        if (userPhone == null) { // 세션에 전화번호가 없을 경우
            result.setPath("/app/user/findPass/findPass1.jsp"); // 첫 페이지로 리다이렉트
            result.setRedirect(true);
            return result;
        }

        // 폼 데이터 가져오기
        String newPw = request.getParameter("newPw");
        System.out.println("새 비밀번호: " + newPw);

        // DTO와 DAO 객체 생성
        UserDTO userDTO = new UserDTO();
        UserDAO userDAO = new UserDAO();

        // DTO에 데이터 설정
        userDTO.setUserPhone(userPhone);
        userDTO.setUserPasswd(newPw); // 필드 이름에 맞는 Setter 사용

        // 비밀번호 업데이트
        boolean isUpdated = userDAO.updatePassword(userDTO);

        if (isUpdated) { // 업데이트 성공
            System.out.println("비밀번호 변경 성공");
            session.invalidate(); // 세션 무효화
            result.setPath(request.getContextPath() + "/app/preset/main.jsp?message="
                    + java.net.URLEncoder.encode("비밀번호가 성공적으로 변경되었습니다.", "UTF-8")); // 메시지를 URL에 인코딩하여 전달
            result.setRedirect(true); // 리다이렉트 방식으로 이동
        } else { // 업데이트 실패
            System.out.println("비밀번호 변경 실패");
            request.setAttribute("updateError", "비밀번호 변경에 실패했습니다. 다시 시도해주세요.");
            result.setPath("/app/user/findPass/findPass2.jsp"); // 실패 시 현재 페이지로 포워드
            result.setRedirect(false);
        }

        return result;
    }
}
