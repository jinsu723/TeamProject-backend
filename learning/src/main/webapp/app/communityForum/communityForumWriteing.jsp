<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%-- <%@ page import="com.fasterxml.jackson.databind.ObjectMapper" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%-- <% if(session.getAttribute("userDTO")==null){
	System.out.println("없음");
	response.sendRedirect(request.getContextPath()+"/app/user/login/login.jsp");
}%> --%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/preset/preset.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityFourm/communityForumWriting.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/preset/mainLogin.js"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/communityForum/communityForumWriteing.js"></script>
  
  <title>커뮤니티 글쓰기</title>
</head>

<body>
  <!-- <div class="communityForum-container"> -->


  <jsp:include page="/app/preset/header.jsp" />
  
  <main class="communityForumWriting-main">
    <div class="communityForumWriting-main-container">
      <div class="communityForumWriting-main-container-title">
        <h1 class="communityForumWriting-main-title">커뮤니티 글쓰기</h1>
      </div>

      <div class="communityForumWriting-category">
        <p class="communityForumWriting-category-text">카테고리</p>
        <input type="radio" name="writing-category" id="free">
        <p class="communityForumWriting-category-free-text">자유</p>
        <input type="radio" name="writing-category" id="strategy">
        <p class="communityForumWriting-category-strategy-text">공략</p>
      </div>
      <div class="communityForumWriting-title">
        <p class="communityForumWriting-title-text">제목</p>
        <input type="text" name="communityForumWriting-title-text-value" id="title" placeholder="제목을 입력하세요(50자)">
      </div>
      <div class="communityForumWriting-content">
        <p class="communityForumWriting-content-text">내용</p>
        <div class="communityForumWriting-content-text-content" contentEditable="true" placeholder="내용을 입력해 주세요."></div>
      </div>
      <div class="communityForumWriting-file">
        <input type="file" accept=".gif, .jpg, .png" style="display:none;"
          class="communityForumWriting-file-select-button" onchange="selectFile()">
        <i class="icon-file-image"></i>
        <p class="communityForumWriting-file-select"></p>
        <button class="communityForumWriting-button">작성</button>
      </div>
    </div>
  </main>

  <jsp:include page="/app/preset/footer.jsp" />


  
</body>

</html>