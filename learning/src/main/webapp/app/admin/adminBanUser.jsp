<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.util.List"%>
<% if(session.getAttribute("adminDTO")==null){
	response.sendRedirect(request.getContextPath()+"/app/admin/adminLogin.jsp");
}%>
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

  <jsp:include page="/app/preset/adminHeader.jsp" />
  
  <main class="mng-main">
    <div class="manager-ban-user-main-container">
      <div class="manager-ban-user-main-container-title">
        <h1 class="manager-ban-user-main-title">밴 회원 관리</h1>
      </div>

      <div class="manager-ban-user-options-container">
        <button type="button" class="reset-search-button">초기화</button>
        <div class="manager-ban-user-options-search">
          <i class="icon-search"></i>
          <input type="text" name="search" id="manager-ban-user-search" placeholder="내용 검색"  maxlength="30">
          <i class="icon-down-dir"></i>
        </div>
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
          <c:choose>
            <c:when test="${not empty benList}">
              <c:forEach var="users" items="${benList}">
                <li class="manager-ban-user-list-item">
              	  <div class="manager-ban-user-list-ban-userId"></div>
              	  <div class="manager-ban-user-list-ban-nickName"></div>
              	  <div class="manager-ban-user-list-ban-text"></div>
              	  <div class="ban-list-date">
              	    <div class="manager-ban-user-list-ban-start-date"></div>
              	    <div class="manager-ban-user-list-ban-end-date"></div>
              	    <div class="manager-ban-user-list-ban-date-count"></div>
              	  </div>
              	  <button type="submit" class="ban-controll">밴 취소</button>
                </li>
              </c:forEach>
            </c:when>
          </c:choose>
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
  
  <jsp:include page="/app/preset/footer.jsp" />
  
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
	  		benPeriod: "${ben.benPeriod}"
	  	}<c:if test="${ben ne benList[benList.size()-1]}">,</c:if>
	  </c:forEach>
	  ];
  </script>
</body>

</html>