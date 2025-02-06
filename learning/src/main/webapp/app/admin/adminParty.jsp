<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%-- <%@ page import="com.fasterxml.jackson.databind.ObjectMapper" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% if(session.getAttribute("adminDTO")==null){
	response.sendRedirect(request.getContextPath()+"/app/admin/adminLogin.jsp");
}%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/assets/css/preset/adminPreset.css">
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/assets/css/admin/adminParty.css">
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/assets/deleteFont/fontello.css">
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/assets/css/admin/adminBanUser.css">
</head>
<title>파티 모집 관리</title>

<body>
   <!-- <div class="mng-container"> -->

   <jsp:include page="/app/preset/adminHeader.jsp" />
   
   <main class="mng-main">
      <div class="mng-main-container">
         <div class="mng-main-container-title">
            <h1 class="mng-main-title">파티 관리</h1>
         </div>

         <div class="mng-options-container">
            <button id="reset-search-button">
               <a href="${pageContext.request.contextPath}/adminUser.ad">초기화</a>
            </button>
            <div class="mng-options-search">
               
               <i class="icon-search"></i> <input type="text" name="nickname"
                  id="manager-ban-user-search" placeholder="내용 검색" maxlength="30"
                  onkeyup="enterKey();">
            </div>
         </div>

         <div class="manager-ban-user-list-header-container">
            <hr class="manager-ban-user-list-line">
            <div class="manager-ban-user-list-main">
               <div class="manager-ban-user-main-list-user-id">
                  <p>게시글 번호</p>
               </div>
               <div class="manager-ban-user-main-list-ban-nickname">
                  <p>닉네임</p>
               </div>
               <div class="manager-ban-user-main-list-ban-content">
                  <p>티어</p>
               </div>
               <div class="ban-date">
                  <div class="manager-ban-user-main-list-ban-start-date">
                     <p>제목</p>
                  </div>
                  <div class="manager-ban-user-main-list-ban-end-date">
                     <p>카테고리</p>
                  </div>
                  <div class="manager-ban-user-main-list-ban-end-date">
                     <p>작성시간</p>
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
            <div id="mng-totalcount">총 모집 게시글 수 : ${totalPartyForumCount}개</div>
         </div>
      </div>

      <div class="manager-ban-user-page-number-container">
         <div class="manager-ban-user-page-number-button">
            <i class="icon-angle-double-left"></i> <i class="icon-left-open"></i>
            <div class="manager-ban-user-page-numbers"></div>
            <i class="icon-right-open"></i> <i class="icon-angle-double-right"></i>
         </div>
      </div>
   </main>
   
   <jsp:include page="/app/preset/footer.jsp" />
   
   <script type="text/javascript">
  const UserCount = {
        UsertNumber: ${totalPartyForumCount}
  };
  
  const forumsList = [
     <c:forEach var="forum" items="${adminParty}">
        {
           forumNumber: "${forum.forumNumber}",
           userNickname: "${forum.userNickname}",
           userTier: "${forum.userTier}",
           forumTitle: "${forum.forumTitle}",
           forumCategory: "${forum.forumCategory}",
           forumDate: "${forum.forumDate}"
        },
        <c:if test="${user ne userList[userList.size()-1]}">,</c:if>
     </c:forEach>
     ];
   //console.log(userList.userNickname);
  </script>
   <script defer
      src="${pageContext.request.contextPath}/assets/js/admin/adminParty.js"></script>
</body>

</html>