<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/preset/preset.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/partyForum/partyForumDetail.css">
	<script defer src="${pageContext.request.contextPath}/assets/js/preset/mainLogin.js"></script>
	 
	
<title>작성자님의 게시글</title>

</head>
<body>
  <jsp:include page="/app/preset/header.jsp" />
  
  <main class="partyForumDetail-main">
    <div class="partyForumDetail-main-container-title">
      <h1 class="partyForumDetail-main-title">파티 모집 게시판</h1>
    </div>

    <div class="partyForumDetail-title">
      <p class="partyForumDetail-title-content">제목</p>
      <p class="partyForumDetail-title-text">티어</p>
    </div>

    <div class="partyForumDetail-writer">
      <p class="partyForumDetail-writer-text">작성자 : </p>
      <p class="partyForumDetail-writer-userName">닉네임</p>
      <p class="partyForumDetail-writer-uploadTime">날짜</p>
    </div>
    

    <div class="partyForumDetail-content">
      <div class="partyForumDetail-content-text">
        값
      </div>
<!--       <img class="partyForumDetail-content-images" 
      alt="사용자 이미지"> -->
    </div>
    <div class="partyForumDetail-button-container">
		<button class="partyForumDetail-partyForum-index-button">목록</button>
<!-- 		<form action="" method="post">
			<button type="submit" class="partyForumDetail-edit-button">수정</button>
		</form>
		<form action="partyDelete.fo" method="post">
     		<button type="submit" class="partyForumDetail-delete-button">삭제</button>
     	</form> -->
			<button type="submit" class="partyForumDetail-edit-button">수정</button>
     		<button type="submit" class="partyForumDetail-delete-button">삭제</button>
    </div>
    
<c:if test="${sessionScope.userDTO != NULL}">
    <!-- userDTO가 있을 경우 참가신청 버튼을 활성화 -->
    <div class="partyForumDetail-button-userApply">
        <button class="partyForumDetail-userApply-button">참가신청</button>
    </div>
</c:if>

<c:if test="${sessionScope.userDTO == NULL}">
    <!-- userDTO가 없을 경우 참가신청 버튼을 비활성화 -->
    <div class="partyForumDetail-button-userApply">
        <button class="partyForumDetail-userApply-button" disabled>참가신청</button>
    </div>
</c:if>

    
    <br>

    <div class="partyForumDetail-comment-list-container">
      <div class="partyForumDetail-comment-input"><input type="text" placeholder="댓글을 입력해 주세요"></div>
      <button>등록</button>
    </div>
    <div class="partyForumDetail-commnet-list-container">
      <ul class="partyForumDetail-comment-list">
        <li class="partyForumDetail-comment-list-item">
          <div class="partyForumDetail-comment-list-details">
            <p class="partyForumDetail-comment-list-userName">이렐칼날긴빠이</p>
            <p class="partyForumDetail-comment-list-colon">:</p>
            <p class="partyForumDetail-comment-list-content">개추</p>
            <p class="partyForumDetail-comment-list-time">2025-01-11 22:22</p>
          </div>
          <hr class="partyForumDetail-comment-line-line">
        </li>

      </ul>
    </div>
    

  </main>

  <jsp:include page="/app/preset/footer.jsp" />

  <%
    String postNum = request.getParameter("postNum"); // 또는 model을 통해 전달된 값일 수도 있음
%>

<script>
    // JSP에서 받은 postNum 값을 JavaScript 변수로 넘기기
    var postNum = '<%= postNum %>';
    console.log("JavaScript에서 받은 postNum:", postNum);
</script>
  <script>
  const forumDetail = [
	  <c:forEach var="forumDetail" items="${forumDetail}">{
			forumTitle: "${forumDetail.forumTitle}",
 			userTier: "${forumDetail.userTier}",
			userNickname: "${forumDetail.userNickname}",
			forumDate: "${forumDetail.forumDate}",
			forumUpdate: "${forumDetail.forumUpdate}",
			forumContent: "${forumDetail.forumContent}",
		  	}
		  </c:forEach>
		  ];  
  
  </script>


	 <script src="${pageContext.request.contextPath}/assets/js/partyForum/partyForumDetail.js"></script>
</body>

</html>