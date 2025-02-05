package com.learning.app.user;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.learning.app.Execute;
import com.learning.app.Result;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class JoinSMSController implements Execute {
    
    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        SmsService smsService = new SmsService();
        
        // JSON 응답 설정
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try {
            // JSON 데이터 읽기
            BufferedReader reader = request.getReader();
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            // JSON 파싱
            JsonObject json = JsonParser.parseString(sb.toString()).getAsJsonObject();
            String phoneNumber = json.get("phoneNumber").getAsString();

            // 디버깅 로그
            System.out.println("📌 전송 요청된 번호: " + phoneNumber);

            // SMS 전송 및 인증번호 저장
            String verificationCode = smsService.sendVerificationSms(phoneNumber);
            HttpSession session = request.getSession();
            session.setAttribute("verificationCode", verificationCode);

            // JSON 응답 반환
            response.getWriter().write("{\"success\": true, \"message\": \"인증번호가 발송되었습니다.\"}");
            
        } catch (CoolsmsException e) {
            // 오류 발생 시 JSON 응답 반환
            response.getWriter().write("{\"success\": false, \"error\": \"SMS 전송 실패\"}");
        }

        return null;
    }
}
