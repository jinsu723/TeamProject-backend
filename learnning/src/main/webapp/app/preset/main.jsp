<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>main page</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/preset/preset.css">
<script defer src="${pageContext.request.contextPath}/assets/js/preset/mainLogin.js"></script>
</head>

<body class="main-body-container">

   <header class="main-header">
      <nav class="main-header-container">
         <div class="main-header-content">
            <div class="main-header-logo">
               <a href="${pageContext.request.contextPath}/app/preset/main.jsp">learnning</a>
            </div>
            <div class="main-header-post-container">
               <a href="${pageContext.request.contextPath}/app/partyForum/partyForum.jsp">
                  <li>파티 모집</li>
               </a> <a href="${pageContext.request.contextPath}/app/communityForum/communityForum.cf">
                  <li>커뮤니티</li>
               </a>
            </div>
         </div>
         <c:choose>
            <c:when test="${not empty sessionScope.userDTO}">
               <div class="main-header-dropdown-container">
                  <div class="main-header-user-box">
                     <i class="icon-down-dir"></i><%= session.getAttribute("userNickname") %><i class="icon-user-circle-o"></i>
                  </div>
                  <div class="main-header-dropdown">
                     <a href="${pageContext.request.contextPath}/app/myPage/checkPass.jsp">• 개인 정보 수정</a>
                     <hr />
                     <a href="${pageContext.request.contextPath}/app/myPage/myPageRecruitment.jsp">• 모집 현황</a>
                     <hr />
                     <a href="${pageContext.request.contextPath}/myPageMyPost.my">• 내 게시물</a>
                     <hr />
                     <a href="${pageContext.request.contextPath}/logoutOk.us">• 로그 아웃</a>
                  </div>
               </div>
            </c:when>
            <c:otherwise>
               <div class="main-nlog-header-container">
                  <li class="main-nlog-header-join"><a href="${pageContext.request.contextPath}/app/user/login/login.jsp">로그인</a></li>
                  <li class="main-nlog-header-join"><a href="${pageContext.request.contextPath}/app/user/signUp/signUp1.jsp">회원가입</a></li>
               </div>
            </c:otherwise>
         </c:choose>

      </nav>
   </header>

   <main class="main-container">
      <div class="main-title-box">
         <p class="main-title">WELOME</p>
         <p class="main-title">MY NEWBIE</p>
         <p class="main-sub-title main-one">고인물들은 당신을 기다리고 있습니다</p>
         <p class="main-sub-title">더 나은 뉴비를 위한 동행</p>
      </div>
   </main>
   <footer class="main-footer">
      <div class="main-login-footer-text">
         <span><a href="">이용약관</a></span> | <span><a href="">개인정보
               처리 방침</a></span> | <span><a href="">고객센터</a></span>
      </div>
   </footer>
   
</body>

</html>