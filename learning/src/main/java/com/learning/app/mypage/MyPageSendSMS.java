package com.learning.app.mypage;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.learning.app.Execute;
import com.learning.app.Result;

import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class MyPageSendSMS implements Execute {
	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BufferedReader reader = request.getReader();
		String line = reader.readLine();
		JsonElement jsonElement = JsonParser.parseString(line);
		JsonObject jsonObj = jsonElement.getAsJsonObject();
		String phoneNumber = jsonObj.get("phoneNumber").getAsString();

		SmsService sms = new SmsService();

		try {
			String verificationCode = sms.sendVerificationSms(phoneNumber);

			HttpSession session = request.getSession();
			session.setAttribute("verificationCode", verificationCode);
		} catch (CoolsmsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}
}
