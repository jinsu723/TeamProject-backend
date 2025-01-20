<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>아이디 및 비밀번호 설정</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/user/signUp/signUp4.css">
  <link rel="stylesheet" href ="${pageContext.request.contextPath}/assets/css/preset/preset.css">
</head>
<body>
  <div class="total-container">
    <div class="signup4-container">
      <header>
        <p>LEARNING</p>
      </header>
      <main>
        <p class="signup4-text1">회원가입을 진행하기기 위해<br> 아이디 및 비밀번호를 입력해 주세요.</p>
        
        <form action="${pageContext.request.contextPath}/signUp4.us" method="post">
          <div class="signup4-input-container1">
            <input type="text" name="userId" id="id" placeholder="아이디를 입력해주세요(1~12자리 특수문자 제외)" maxlength="12" pattern="^[a-zA-Z0-9_-]{1,12}$" required>
            <button type="button" class="signup4-certify-button">중복검사</button>
          </div>
          <p id="id-error" class="signup4-error-message1"></p>
          <div class="signup4-input-container2">
            <input type="password" name="userPw" id="password" placeholder="비밀번호를 입력해 주세요(8~16 영문+숫자+특수기호)" maxlength="16" pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,16}$" required>
          </div>
          <p id="password-error1" class="signup4-error-message2"></p>
          <div class="signup4-input-container3">
            <input type="password" id="confirm-password" placeholder="비밀번호를 재입력해 주세요" maxlength="16" pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,16}$" required>
          </div>
          <p id="password-error2" class="signup4-error-message3"></p>
  
          <ul class="signup4-info-list">
            <li>입력한 아이디는 회원가입 후 로그인을 진행하기 위한 아이디입니다.</li>
            <li>경우에 따라 특수문자 및 특수기호 등의 사용이 불가합니다.</li>
          </ul>
          <div class="signup4-buttons-container">
            <button type="submit" class="signup4-next-button" disabled>다음</button>
          </div>         
        </form>
        
      </main>
      <footer class="signup4-footer">
        <a href="#">이용약관</a> | <a href="#">개인정보 처리 방침</a> | <a href="#">고객센터</a>
      </footer>
    </div>
  </div>
  
  <script defer src="${pageContext.request.contextPath}/assets/js/user/signUp/signUp4.js"></script>
</body>
</html> 