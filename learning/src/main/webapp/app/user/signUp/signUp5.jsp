<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>아이디 및 비밀번호 설정</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/user/signUp/signUp5.css">
  <link rel="stylesheet" href ="${pageContext.request.contextPath}/assets/css/preset/preset.css">
</head>
<body>
  <div class="total-container">
    <div class="signup5-container">
      <header>
        <p>LEARNNING</p>
      </header>
      <main>
        <p class="signup5-text1">이제 마지막 단계입니다<br> 본인의 게임 티어를 선택해 주세요.</p>
        <form action="${pageContext.request.contextPath}/signUp5.us" method="post">
          <p class="signup5-choose-message"> 현재 본인의 게임 티어를 선택해 주세요</p>

          <div class="signup5-choose-container">
            <select name="userTier" id="tier-select" required>
              <option value="" disabled selected>본인 게임 티어</option>
              <option value="언랭">언랭</option>
              <option value="브론즈">브론즈</option>
              <option value="실버">실버</option>
              <option value="골드">골드</option>
              <option value="플래티넘">플래티넘</option>
              <option value="에메랄드">에메랄드</option>
              <option value="다이아몬드">다이아몬드</option>
              <option value="마스터">마스터</option>
              <option value="그랜드마스터">그랜드마스터</option>
              <option value="챌린저">챌린저</option>
            </select>
          </div>
          
          <ul class="signup5-info-list">
            <li>솔직한 자신의 티어를 입력해주세요.</li>
            <li>추후 거짓 정보로 확인 시 강제로 탈퇴 처리됩니다.</li>
          </ul>
          <div class="signup5-buttons-container">
            <button type="submit" class="signup5-complete-button" disabled>완료</button>
          </div>
          
        </form>
      </main>
      <footer class="signup5-footer">
        <a href="#">이용약관</a> | <a href="#">개인정보 처리 방침</a> | <a href="#">고객센터</a>
      </footer>
    </div>
  </div>
  
  <script defer src="${pageContext.request.contextPath}/assets/js/user/signUp/signUp5.js"></script>
</body>
</html> 