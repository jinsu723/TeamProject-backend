<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%-- <%@ page import="com.fasterxml.jackson.databind.ObjectMapper" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>밴 회원 관리</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/preset/adminPreset.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminBanUser.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/deleteFont/fontello.css">
  
</head>

<body>
  <!-- <div class="mng-container"> -->

  <header class="main-nonLogin-header">
    <nav>
      <div class="main-nonLogin-nav">
        <div class="main-nonLogin-logo"><a href="${pageContext.request.contextPath}/app/admin/adminMain.jsp">learning</a></div>
        <ul class="main-nonLogin-contents main-nonLogin-ul">
            <div class="mng-users-contentes-drop">
              <div class="mng-users-text"><a href="${pageContext.request.contextPath}/ben.ad">밴 회원 관리</a>  
                <div id="mng-users-dropText"><a href="${pageContext.request.contextPath}/app.admin/adminUser.jsp">회원 관리</a></div>
              </div>
            </div>
          <li id="mng-contents-drop">게시글 관리
              <div class="mng-header-drop">
                <div id="mng-header-dropDown1"><a href="${pageContext.request.contextPath}/app/admin/adminParty.jsp">파티 관리</a></div>
                <div id="mng-header-dropDown2"><a href="${pageContext.request.contextPath}/app/admin/adminCommunity.jsp">커뮤니티</a></div>
              </div>
          </li>
        </ul>
      </div>
      <ul class="main-nonLogin-join-box main-nonLogin-ul">
        <li class="main-nonLogin-join"><a href="${pageContext.request.contextPath}/adminlogoutOk.ad">로그아웃</a></li>
      </ul>
    </nav>
  </header>
  <main class="mng-main">
    <div class="manager-ban-user-main-container">
      <div class="manager-ban-user-main-container-title">
        <h1 class="manager-ban-user-main-title">밴 회원 관리</h1>
      </div>

      <div class="manager-ban-user-options-container">
        <button type="button" class="reset-search-button">초기화</button>
        <div class="manager-ban-user-options-search">
          <i class="icon-search"></i>
          <input type="text" name="search" id="manager-ban-user-search" placeholder="내용 검색">
          <i class="icon-down-dir"></i>
        </div>
        <!-- <div class="manager-ban-user-write-button">
          <button type="button" class="manager-ban-user-write-btn">글쓰기</button>
        </div> -->
      </div>

      <div class="manager-ban-user-list-header-container">
        <hr class="manager-ban-user-list-line">
        <div class="manager-ban-user-list-main">
          <div class="manager-ban-user-main-list-user-id">
            <p>아이디</p>
          </div>
          <div class="manager-ban-user-main-list-ban-nickname">
            <p>닉네임</p>
          </div>
          <div class="manager-ban-user-main-list-ban-content">
            <p>밴 사유</p>
          </div>
          <div class="ban-date">
          <div class="manager-ban-user-main-list-ban-start-date">
            <p>시작일</p>
          </div>
          <div class="manager-ban-user-main-list-ban-end-date">
            <p>종료일</p>
          </div>
          <div class="manager-ban-user-main-list-ban-remaining-time">
            <p>남은기간</p>
          </div>
        </div>
          <div class="manager-ban-user-main-list-ban-controll-button">
            <p>관리버튼</p>
          </div> 
        </div>
        <hr class="manager-ban-user-list-line">
        <ul class="manager-ban-user-list">
        </ul>
      </div>
    </div>
    <div class="manager-ban-user-page-number-container">
      <div class="manager-ban-user-page-number-button">
        <i class="icon-angle-double-left"></i>
        <i class="icon-left-open"></i>
        <div class="manager-ban-user-page-numbers"></div>
        <i class="icon-right-open"></i>
        <i class="icon-angle-double-right"></i>
      </div>
    </div>
  </main>
  <footer class="mng-footer">
    <div class="mng-footer-text">
      <span id="mng-provision"><a href="">이용약관</a></span> | <span id="mng-userInfor"><a href="">개인정보 처리 방침</a></span> |
      <span id="mng-center"><a href="">고객센터</a></span>
    </div>
  </footer>
  <script defer src="${pageContext.request.contextPath}/assets/js/admin/adminBanUser.js"></script>
  <script type="text/javascript">
  const benUserCount = {
		  benedUsertNumber: ${benedUserNumber}
  };
  
  const bensList = [
	  <c:forEach var="ben" items="${benList}">
	  	{
	  		userId: "${ben.userId}",
	  		userNickname: "${ben.userNickname}",
	  		benReason: "${ben.benReason}",
	  		benStartDate: "${ben.benStartDate}",
	  		benEndDate: "${ben.benEndDate}",
	  		benPeriod: "%{ben.benPeriod}"
	  	}<c:if test="${ben ne benList[benList.size()-1]}">,</c:if>
	  </c:forEach>
	  ];
  </script>
</body>

</html>