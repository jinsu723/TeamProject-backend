<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <header class="main-header">
      <nav class="main-header-container">
        <div class="main-header-content">
          <div class="main-header-logo">
          	<a href="${pageContext.request.contextPath}/app/preset/main.jsp">learnning</a>
          </div>
          <div class="main-header-post-container">
            <a href="../partyForum/partyForum.html">
              <li>파티 모집</li>
            </a>
            <a href="../communityForum/communityForum.html">
              <li>커뮤니티</li>
            </a>
          </div>
        </div>
        <div class="main-header-dropdown-container">
          <div class="main-header-user-box">
            <i class="icon-down-dir"></i>사용자<i class="icon-user-circle-o"></i>
          </div>
          <div class="main-header-dropdown">
            <a href="${pageContext.request.contextPath}/app/myPage/checkPass.jsp">• 개인 정보 수정</a>
            <hr>
            <a href="${pageContext.request.contextPath}/app/myPage/myPageRecruitment.jsp">• 모집 현황</a>
            <hr>
            <a href="${pageContext.request.contextPath}/myPageMyPost.my">• 내 게시물</a>
            <hr>
            <a href="${pageContext.request.contextPath}/logoutOk.us">• 로그 아웃</a>
          </div>
        </div>
      </nav>
    </header>

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

  <footer class="main-footer">
    <div class="main-login-footer-text">
      <span><a href="">이용약관</a></span> | <span><a href="">개인정보 처리 방침</a></span> | <span><a href="">고객센터</a></span>
    </div>
  </footer>
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