<%@page import="com.learning.app.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>비밀번호 확인</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/myPage/checkPass.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/preset/preset.css">
</head>

<body>
  <div class="total-container">
    <div class="checkPass-container">
      <header>
        <p>LEARNING</p>
      </header>
      <main>
        <p class="checkPass-text1"> 인증하신 전화번호로 변경합니다</p>
        <form action="${pageContext.request.contextPath}/changePhoneNumber.my" method="post">
          <div class="checkPass-input-container1">
            <input type="text" id="password" name="phoneNumber" value="<%= request.getParameter("phone") %>" readonly="readonly">
          </div>
          <p id="pass-error" class="checkPass-error-message1"></p>


          <ul class="checkPass-info-list">
            <li>전화번호는 11자리 숫자만 입력가능합니다.</li>
            <li>중복되지 않는 번호를 입력해 주세요.</li>
          </ul>
          <div class="checkPass-buttons-container">
            <button type="submit" class="checkPass-next-button active">다음</button>
          </div>
        </form>
      </main>
      <footer class="checkPass-footer">
        <a href="#">이용약관</a> | <a href="#">개인정보 처리 방침</a> | <a href="#">고객센터</a>
      </footer>
    </div>
  </div>

</body>

</html>