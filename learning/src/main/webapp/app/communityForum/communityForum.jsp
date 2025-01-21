<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%-- <%@ page import="com.fasterxml.jackson.databind.ObjectMapper" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/preset/preset.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/communityFourm/communityForum.css">
<script defer
	src="${pageContext.request.contextPath}/assets/js/communityForum/communityForum.js"></script>
<script defer
	src="${pageContext.request.contextPath}/assets/js/preset/mainLogin.js"></script>

<title>커뮤니티 게시글 목록</title>
</head>

<body>
	<!-- <div class="communityForum-container"> -->


	<jsp:include page="/app/preset/header.jsp" />
	<main class="communityForum-main">
		<div class="communityForum-main-container">
			<div class="communityForum-main-container-title">
				<h1 class="communityForum-main-title">커뮤니티</h1>
			</div>

			<div class="communityForum-options-container">
				<div class="communityForum-options-search">
					<i class="icon-search"></i> <input type="text" name="search"
						id="communityForum-search" placeholder="내용 검색"> <i
						class="icon-down-dir"></i>
				</div>
				<div class="communityForum-write-button">
					<button type="button" class="communityForum-write-btn">글쓰기</button>
				</div>
			</div>

			<div class="communityForum-list-header-container">
				<hr class="communityForum-list-line">
				<div class="communityForum-list-main">
					<div class="communityForum-main-list-writer">
						<p>작성자</p>
					</div>
					<div class="communityForum-main-list-category">
						<p>카테고리</p>
					</div>
					<div class="communityForum-main-list-title">
						<p>제목</p>
					</div>
					<div class="communityForum-main-list-write-time">
						<p>작성시간</p>
					</div>
				</div>
				<hr class="communityForum-list-line">
				<ul class="communityForum-list">
				</ul>
			</div>
		</div>
		<div class="communityForum-page-number-container">
			<div class="communityForum-page-number-button">
				<i class="icon-angle-double-left"></i> <i class="icon-left-open"></i>
				<div class="communityForum-page-numbers"></div>
				<i class="icon-right-open"></i> <i class="icon-angle-double-right"></i>
			</div>
		</div>
	</main>
	<jsp:include page="/app/preset/footer.jsp" />

	<script type="text/javascript">
	const loginStatus = {
			userLoginStatus: ${userCheckLogins}
	};
  const postCount = {
		  postNumber: ${communityPostCount}
  };
  const postList = [
		  <c:forEach var="post" items="${posts}">
		  	{
		  		postNumber: "${post.forumNumber}",
		  		userNickname: "${post.userNickName}",
		  		postCategory: "${post.forumCategory}",
		  		postTitle: "${post.forumTitle}",
		  		postData: "${post.forumDate}"
		  	}<c:if test="${post ne posts[posts.size()-1]}">,</c:if>
		  </c:forEach>
		  ];
  </script>

</body>

</html>