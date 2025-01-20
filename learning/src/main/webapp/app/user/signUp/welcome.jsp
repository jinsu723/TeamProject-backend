<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>환영 페이지지</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/user/signUp/welcome.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/preset/preset.css">
  <script>
      const contextPath = '<%= request.getContextPath() %>';
  </script>
</head>
<body>
  <div class="total-container">
    <div class="welcome-container">
      <header>
        <p>👋</p>
      </header>
      <main>
        <p class="welcome-text1">
          <span class="highlight"><%= request.getAttribute("userNickname") %></span>님 환영합니다!
        </p>
        <p class="welcome-text2">
          확인 버튼을 눌러<br>
          게임에 대한 다양한 정보,<br>
          고인물들과 함께 게임을 하여<br>
          팀을 전수받아보세요!
        </p>
        <div class="welcome-buttons-container">
          <button type="button" class="welcome-button" id="confirm-button">확인</button>
          <%-- onclick="location.href='${pageContext.request.contextPath}/app/preset/main.jsp'" 이 경로로 넣어도도됨--%>
        </div>
      </main>
      <footer class="welcome-footer">
        <a href="#">이용약관</a> | 
        <a href="#">개인정보 처리 방침</a> | 
        <a href="#">고객센터</a>
      </footer>
    </div>
  </div>
  <script defer src ="${pageContext.request.contextPath}/assets/js/user/signUp/welcome.js"></script>
</body>
</html>