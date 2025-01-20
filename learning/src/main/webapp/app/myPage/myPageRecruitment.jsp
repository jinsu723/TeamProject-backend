<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% if(session.getAttribute("userDTO")==null){
	System.out.println("없음");
	response.sendRedirect(request.getContextPath()+"/app/user/login/login.jsp");
}%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/preset/preset.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/myPage/myPageRecruitment.css">
  <script src="https://kit.fontawesome.com/06edfe60eb.js" crossorigin="anonymous"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/myPageMain/myPageRecruitment.js"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/preset/mainLogin.js"></script>
  <title>내 모집 관리</title>
</head>

<body>
    <!-- 헤더 -->
   <jsp:include page="/app/preset/header.jsp" />

  <main>
    <div class="myPage-container">
      <h1 class="myPage-forum-text">모집 현황</h1>

      <div class="myPage-changePage">
        <div class="myPage-changePageBtn">
          <span>모집</span>
          <i class="myPage-changePageToggle fa-solid fa-toggle-off"></i>
          <span>신청</span>
        </div>
      </div>

      <hr style="width: 70%;">
      <div class="myPage-content" style="width: 70%;">
        <span class="nick">닉네임</span>
        <span class="tear">티어</span>
        <span class="title">제목</span>
        <span class="date">작성시간</span>
        <span class="approve">승인</span>
      </div>
      <hr style="width: 70%;">
      <div class="myPage-main"></div>
    </div>


    <div class="myPage-pageNation">
      <span><i class="fa-solid fa-angles-left"></i></span>
      <span><i class="fa-solid fa-chevron-left"></i></span>
      <div class="myPage-pageNation-number"></div>
      <span><i class="fa-solid fa-chevron-right"></i></span>
      <span><i class="fa-solid fa-angles-right"></i></span>
    </div>
  </main>

  <!-- 푸터 -->
   <jsp:include page="/app/preset/footer.jsp" />
</body>
<script>
  const pageBtn = document.querySelector(".myPage-changePageBtn");
  const pageToggle = document.querySelector(".myPage-changePageToggle");
  const pageList = document.querySelector(".myPage-main");
  const pageSize = 10;
  const pageItems = 3;
  const pageCount = Math.ceil(pageItems / pageSize);
  const pageType = '신청';
  let current = 1;
</script>

</html>