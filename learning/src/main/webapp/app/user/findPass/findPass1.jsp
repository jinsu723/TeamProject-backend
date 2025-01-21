<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>비밀번호 재설정</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/user/signUp/signUp2.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/preset/preset.css">
</head>
<body>
  <div class="total-container">
    <div class="signup2-container">
      <header>
        <p>LEARNING</p>
      </header>
      <main>
        <p class="signup2-text1">비밀번호 재설정을 위해<br> 전화번호를 입력해 주세요.</p>
        <form action="${pageContext.request.contextPath}/findPass1.us" method="post">
          <div class="signup2-input-container">
            <input type="text" name="userPhone" id="phone-number" placeholder="전화번호를 입력해주세요" maxlength="13" pattern="^010-\d{4}-\d{4}$" required>
            <button type="button" class="signup2-certify-button1">인증요청</button>
          </div>
          <div id="signup2-certify-section" class="signup2-hidden">
            <input type="text" id="certify-code" placeholder="인증번호를 입력해 주세요" maxlength="5" pattern="[0-9]*" required>
            <button type="button" id="certify-check" class="signup2-certify-button2">인증확인</button>
          </div>
          <ul class="signup2-info-list">
            <li>전화번호는 비밀번호 재설정을 위해 필요합니다.</li>
            <li>정확히 입력하지 않으면 인증 문자를 받을 수 없습니다.</li>
          </ul>
          <div class="signup2-buttons-container">
            <button type="submit" class="signup2-next-button" disabled>다음</button>
          </div>
        </form>
      </main>
      <footer class="signup2-footer">
        <a href="#">이용약관</a> | <a href="#">개인정보 처리 방침</a> | <a href="#">고객센터</a>
      </footer>
    </div>
  </div>
  <script defer src="${pageContext.request.contextPath}/assets/js/user/findPass/findPass1.js"></script>
  <script>
    const phone = {
      user: <%= request.getAttribute("checkPhone") %>
    };
  </script>
</body>
</html>
