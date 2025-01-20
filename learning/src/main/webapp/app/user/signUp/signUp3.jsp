<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>닉네임 설정</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/user/signUp/signUp3.css">
  <link rel="stylesheet" href ="${pageContext.request.contextPath}/assets/css/preset/preset.css">
</head>
<body>
  <div class="total-container">
    <div class="signup3-container">
      <header>
        <p>LEARNING</p>
      </header>
      <main>
        <p class="signup3-text1">커뮤니티에서 활동하기 위해<br> 닉네임을 결정해 주세요.</p>
        <form action="${pageContext.request.contextPath}/signUp3.us" method="post">
          <div class="signup3-input-container">
            <input type="text" name="userNickname" id="nickname" placeholder="닉네임을 입력해주세요(최대 글자)" maxlength="10" pattern="^[a-zA-Z0-9가-힣]{1,7}$" required>
            <button type="button" class="signup3-certify-button">중복검사</button>
          </div>
  
          <div class="signup3-hidden">
            <p id="nickname-error" class="signup3-error-message"></p>
          </div>
  
          <ul class="signup3-info-list">
            <li>투명하고 건강한 소통을 위해 닉네임을 꼭! 설정해주세요.</li>
            <li>욕설 및 비속어, 선정적 표현은 닉네임으로 사용할 수 없습니다.</li>
            <li>닉네임 설정 시 보여지는 "사용 가능한 닉네임입니다."는 중복 및 기본 필터링에 대한 안내입니다.</li>
          </ul>
          <div class="signup3-buttons-container">
            <button type="submit" class="signup3-next-button" disabled>다음</button>
          </div>
          
        </form>
      </main>
      <footer class="signup3-footer">
        <a href="#">이용약관</a> | <a href="#">개인정보 처리 방침</a> | <a href="#">고객센터</a>
      </footer>
    </div>
  </div>
  
  <script defer src="${pageContext.request.contextPath}/assets/js/user/signUp/signUp3.js"></script>
</body>
</html>