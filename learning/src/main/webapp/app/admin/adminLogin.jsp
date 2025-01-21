<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인 페이지</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminLogin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/preset/preset.css">
</head>

<body>
    <div class="adminLogin-container">
        <p class="adminLogin-logo">LEARNING</p>
        <p class="adminLogin-subtitle">CREW</p>
        <form id="adminLogin-form" action="${pageContext.request.contextPath}/adminloginOk.ad" method="post">
            <div class="adminLogin-input-container">
                <input type="text" name="adminId" id="adminLogin-id" placeholder="관리자 아이디" required>
                <input type="password" name="adminPw" id="adminLogin-password" placeholder="관리자 비밀번호" required>
            </div>
            
            <button type="submit" class="adminLogin-button">관리자 로그인</button>
        </form>
        <footer class="adminLogin-footer">
            <a href="#">이용약관</a> |
            <a href="#">개인정보 처리 방침</a> |
            <a href="#">고객센터</a>
        </footer>
    </div>
    <!-- <script defer src="${pageContext.request.contextPath}/assets/js/admin/adminLogin.js"></script> -->
</body>

</html>