<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>

<head>

  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/preset/adminPreset.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminUser.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/deleteFont/fontello.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminBanUser.css">
</head>
<title>회원 관리</title>

<body>
  <!-- <div class="mng-container"> -->

  <header class="main-nonLogin-header">
    <nav>
      <div class="main-nonLogin-nav">
        <div class="main-nonLogin-logo"><a href="${pageContext.request.contextPath}/adminMain.ad">learning</a></div>
        <ul class="main-nonLogin-contents main-nonLogin-ul">
            <div class="mng-users-contentes-drop">
              <div class="mng-users-text"><a href="${pageContext.request.contextPath}/adminUser.ad">회원 관리</a>  
                <div id="mng-users-dropText"><a href="${pageContext.request.contextPath}/ben.ad">밴 회원 관리</a></div>
              </div>
            </div>
          <li id="mng-contents-drop">게시글 관리
              <div class="mng-header-drop">
                <div id="mng-header-dropDown1"><a href="${pageContext.request.contextPath}/adminParty.ad">파티 관리</a></div>
                <div id="mng-header-dropDown2"><a href="${pageContext.request.contextPath}/adminCommunity.ad">커뮤니티</a></div>
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
        <button id="reset-search-button"><a href="${pageContext.request.contextPath}/adminUser.ad">초기화</a></button>
        <div class="mng-options-search">
          <%-- <form action="${pageContext.request.contextPath}/admin/adminUser" method="get"> --%>
             <i class="icon-search"></i>
             <input type="text" name="nickname" id="manager-ban-user-search" placeholder="내용 검색" maxlength="30">
           <!-- </form> -->
        </div>
      </div>

  <div class="manager-ban-user-list-header-container">
        <hr class="manager-ban-user-list-line">
        <div class="manager-ban-user-list-main">
          <div class="manager-ban-user-main-list-user-id">
            <p>유저번호</p>
          </div>
          <div class="manager-ban-user-main-list-ban-nickname">
            <p>닉네임</p>
          </div>
          <div class="manager-ban-user-main-list-ban-content">
            <p>티어</p>
          </div>
          <div class="ban-date">
          <div class="manager-ban-user-main-list-ban-start-date">
            <p>핸드폰 번호</p>
          </div>
          <div class="manager-ban-user-main-list-ban-end-date">
            <p>회원 생성 시간</p>
          </div>
          <div class="manager-ban-user-main-list-ban-end-date">
            <p>밴 횟수</p>
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
      
      <div class="mng-box-footer">
        <div id="mng-totalcount">전체 회원 수 : ${totalUserCount}명</div>
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
  <footer class="main-footer">
    <div class="main-nonLogin-footer-text">
      <span><a href="">이용약관</a></span> | <span><a href="">개인정보 처리 방침</a></span> | <span><a href="">고객센터</a></span>
    </div>
  </footer>

    <script type="text/javascript">
  const UserCount = {
		  UsertNumber: ${totalUserCount}
  };
  
  console.log("jsp ${adminUser}");
  const userList = [
	  <c:forEach var="user" items="${adminUser}">
	  	{
	  		userNumber: "${user.userNumber}",
	  		userNickname: "${user.userNickname}",
	  		userTier: "${user.userTier}",
	  		userPhone: "${user.userPhone}",
	  		userJoinDate: "${user.userJoinDate}",
	  		userBenCnt: "${user.userBenCnt}"
	  	}
	  	<c:if test="${user ne userList[userList.size()-1]}">,</c:if>
	  </c:forEach>
	  ];
	//console.log(userList.userNickname);
  </script>
  <script defer src="${pageContext.request.contextPath}/assets/js/admin/adminUser.js"></script>
</body>

</html>