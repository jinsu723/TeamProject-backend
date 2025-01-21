<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>

<head>

  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/preset/adminPreset.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminUser.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/deleteFont/fontello.css">
</head>
<title>회원 관리</title>

<body>
  <!-- <div class="mng-container"> -->

  <header class="main-nonLogin-header">
    <nav>
      <div class="main-nonLogin-nav">
        <div class="main-nonLogin-logo"><a href="${pageContext.request.contextPath}/app/admin/adminMain.jsp">learning</a></div>
        <ul class="main-nonLogin-contents main-nonLogin-ul">
            <div class="mng-users-contentes-drop">
              <div class="mng-users-text"><a href="${pageContext.request.contextPath}/app/admin/adminUser.jsp">회원 관리</a>  
                <div id="mng-users-dropText"><a href="${pageContext.request.contextPath}/ben.ad">밴 회원 관리</a></div>
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
    <div class="mng-main-container">
      <div class="mng-main-container-title">
        <div class="mng-main-title">
          <h1 class="mng-user-main-title">회원 관리</h1>
        </div>
      </div>
      <div class="mng-options-container">
        <button id="mng-reset-button"><a href="${pageContext.request.contextPath}/adminUser.ad">초기화</a></button>
        <div class="mng-options-search">
          <%-- <form action="${pageContext.request.contextPath}/admin/adminUser" method="get"> --%>
             <i class="icon-search"></i>
             <input type="text" name="nickname" id="mng-search" placeholder="내용 검색" maxlength="30" onkeyup="enterKey();">
           <!-- </form> -->
        </div>
      </div>

      <div class="mng-list-header-container">
        <hr class="mng-list-line">
        <div class="mng-list-main">
          <div class="mng-main-list-check">
            <p>선택</p>
          </div>
          <div class="mng-main-list-userNum">
            <p>유저 번호</p>
          </div>
          <div class="mng-main-list-nickName">
            <p>닉네임</p>
          </div>
          <div class="mng-main-list-tier">
            <p>티어</p>
          </div>
          <div class="mng-main-list-phone">
            <p>핸드폰 번호</p>
          </div>
          <div class="mng-main-list-write-time">
            <p>회원 생성 시간</p>
          </div>
        </div>
        <hr class="mng-list-line">
        <ul class="mng-list">
          <c:forEach var="user" items="${adminUser}">
             <li class="mng-list-item">
                <input type="checkbox" class="mng-list-check">
                <div class="mng-list-userNum">${user.userNumber}</div>
                <div class="mng-list-nickName">${user.userNickname}</div>
                <div class="mng-list-tier">${user.userTier}</div>
                <div class="mng-list-phone">${user.userPhone}</div>
                <div class="mng-list-write-time">"${user.userJoin}"</div>
             </li>
             <hr>
          </c:forEach>
            <!-- <div class="mng-list-writer"><p>키보드워리어</p></div>
            <div class="mng-list-category"><p>공략글</p></div>
            <div class="mng-list-title"><p>1</p></div>
            <div class="mng-list-write-time"><p>2025-1-10 22:55</p></div>
          </li>
          <hr class="mng-list-item-line"> -->
          <!-- (li.mng-list-item>(div.mng-list-writer>p{키보드워리어})(div.mng-list-category>p{공략글})(div.mng-list-title>p{$})(div.mng-list-write-time>p{2025-1-10 22:55}))hr.mng-list-item-line)*45 -->

        </ul>
      </div>
      <div class="mng-box-footer">
        <button class="icon-trash"></button>
        <button class="mng-addBen">밴 등록</button>
        <div id="mng-totalcount">전체 회원 수 : ${totalUserCount}명</div>
      </div>
    </div>
    
    <div class="mng-page-number-container">
      <div class="mng-page-number-button">
        <i class="icon-angle-double-left"></i>
        <i class="icon-left-open"></i>
        <div class="mng-page-numbers"></div>
        <i class="icon-right-open"></i>
        <i class="icon-angle-double-right"></i>
      </div>
    </div>
  </main>
  <footer class="main-footer">
    <div class="main-nonLogin-footer-text">
      <span><a href="">이용약관</a></span> | <span><a href="">개인정보 처리 방침</a></span> | <span><a href="">고객센터</a></span>
    </div>
  </footer>

  <!-- <script defer src="${pageContext.request.contextPath}/assets/js/admin/adminUser.js"></script> -->
</body>

</html>