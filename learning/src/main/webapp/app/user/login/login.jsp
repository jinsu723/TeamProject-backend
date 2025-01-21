<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인 페이지</title>
    <!-- CSS 파일 경로 설정 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/user/login/login.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/preset/preset.css">
    <%-- <script defer src="${pageContext.request.contextPath}/assets/js/user/login/login.js"></script> --%>
</head>
<body>
    <div class="login-container">
        <p class="login-logo">LEARNING</p>
        <p class="login-subtitle">CREW</p>
        <!-- form action 수정 -->
        <form id="login-form" action="${pageContext.request.contextPath}/loginOk.us" method="post">
            <div class="login-input-container">
                <input type="text" name="userId" id="login-id" placeholder="아이디" required>
                <input type="password" name="userPw" id="login-password" placeholder="비밀번호" required>
            </div>
            <div class="login-links">
                <a href="${pageContext.request.contextPath}/app/user/findPass/findPass1.jsp" id="login-find-password">비밀번호 찾기</a>
                <a href="${pageContext.request.contextPath}/app/user/signUp/signUp1.jsp" id="login-signup">회원가입</a>
            </div>
            <button type="submit" class="login-button">로그인</button>
        </form>
        <footer class="login-footer">
            <a href="#">이용약관</a> | <a href="#">개인정보 처리 방침</a> | <a href="#">고객센터</a>
        </footer>
    </div>
    
    <!-- 서버의 로그인 메시지를 JavaScript로 전달 -->
    <!-- 포워드 방식 -->
   <script>
        document.addEventListener("DOMContentLoaded", () => {
            const loginMessage = '<%= request.getAttribute("loginMessage") != null ? request.getAttribute("loginMessage") : "" %>';
            
            if (loginMessage) {
                alert(loginMessage); // 로그인 실패 메시지 출력
            }
        });
    </script>
    
  <%--   <!-- 리퀘스트 방식 -->
     <script>
        document.addEventListener("DOMContentLoaded", () => {
            const loginMessage = '<%= (String) session.getAttribute("loginMessage") %>';
            
            if (loginMessage) {
                alert(loginMessage); // 메시지 출력
                <% session.removeAttribute("loginMessage"); %> // 메시지 삭제
            }
        });
    </script> --%>
  
<%-- <script defer src="${pageContext.request.contextPath}/assets/js/user/login/login.js"></script> --%>
</body>
</html>


