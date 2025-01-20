<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% session.invalidate(); %>
<!DOCTYPE html>
<html lang="ko">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/myPage/myPageWithdraw.css">
   <script src="https://kit.fontawesome.com/06edfe60eb.js" crossorigin="anonymous"></script>
   <title>회원탈퇴 완료</title>
</head>

<body>
   <header></header>
   <main>
      <div><i class="fa-solid fa-face-sad-tear" style="color: #FFD43B;font-size: 50px;"></i></div>
      <div>
         <h2>회원탈퇴가</h2>
         <h2>정상적으로 진행되었습니다</h2>
         <h2>그동안 저희와 함께 해 주셔서 감사합니다</h2>
      </div>
      <div>
         <h3>회원님의 개인정보는 안전하게</h3>
         <h3>삭제처리 되었습니다</h3>
      </div>
      <div style="height: 100px;"></div>
      <button class="withDrawBtn">확인</button>
   </main>
   <footer class="main-footer">
      <div class="nonLogin-footer-text">
         <span><a href="">이용약관</a></span> | <span><a href="">개인정보 처리 방침</a></span> | <span><a href="">고객센터</a></span>
      </div>
   </footer>
</body>
<script type="text/javascript">
	document.querySelector(".withDrawBtn").addEventListener("click", () => location.href = '<%= request.getContextPath() %>/app/preset/main.jsp');
</script>
</html>