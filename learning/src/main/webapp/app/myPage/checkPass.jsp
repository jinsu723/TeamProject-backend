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
  <%-- <script defer src="${pageContext.request.contextPath}/assets/js/myPageMain/checkPass.js"></script> --%>
</head>

<body>
  <div class="total-container">
    <div class="checkPass-container">
      <header>
        <p>LEARNING</p>
      </header>
      <main>
        <p class="checkPass-text1">회원님의 개인정보를 지키는 중입니다<br> 비밀번호를 입력해 주세요</p>
        <form action="${pageContext.request.contextPath}/checkPass.my" method="post">
          <div class="checkPass-input-container1">
            <input type="password" id="password" name="password" placeholder="비밀번호를 입력해주세요" maxlength="16" required>
          </div>
          <p id="pass-error" class="checkPass-error-message1"></p>


          <ul class="checkPass-info-list">
            <li>전화번호는 본인인증을 진행하기 위해 입력해주세요.</li>
            <li>인증 문자가 오지 않는다면 스팸번호를 확인 해 주세요.</li>
            <li>선택 약관동의에 따라 광고성 및 이벤트성 알림이 해당 전화번호로 전송될 수 있습니다.</li>
          </ul>
          <div class="checkPass-buttons-container">
            <button type="submit" class="checkPass-next-button">다음</button>
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