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


	<header class="main-header">
		<nav class="main-header-container">
			<div class="main-header-content">
				<div class="main-header-logo">
					<a href="">learnning</a>
				</div>
				<div class="main-header-post-container">
					<a href="../partyForum/partyForum.jsp">
						<li>파티 모집</li> <!-- </a> <a href="../communityForum/communityForum.jsp"> -->
						<%-- </a> <a href="${pageContext.request.contextPath}/app/communityForum/communityForum.jsp"> --%>
					</a> <a href="<%=request.getContextPath() + "/frontController"%>">
						<li>커뮤니티</li>
					</a>
				</div>
			</div>
			<c:choose>
				<c:when test="${not empty sessionScope.userDTO}">
					<div class="main-header-dropdown-container">
						<div class="main-header-user-box">
							<i class="icon-down-dir"></i>사용자<i class="icon-user-circle-o"></i>
						</div>
						<div class="main-header-dropdown">
							<a
								href="${pageContext.request.contextPath}/app/myPage/checkPass.jsp">•
								개인 정보 수정</a>
							<hr />
							<a
								href="${pageContext.request.contextPath}/app/myPage/myPageRecruitment.jsp">•
								모집 현황</a>
							<hr />
							<a
								href="${pageContext.request.contextPath}/app/myPage/myPageMyPost.jsp">•
								내 게시물</a>
							<hr />
							<a href="./mainNonLogin.html">• 로그 아웃</a>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="main-nlog-header-container">
						<li class="main-nlog-header-join"><a
							href="${pageContext.request.contextPath}/app/user/login/login.jsp">로그인</a></li>
						<li class="main-nlog-header-join"><a
							href="${pageContext.request.contextPath}/app/user/signUp/signUp1.jsp">회원가입</a></li>
					</div>
				</c:otherwise>
			</c:choose>

		</nav>
	</header>
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
	<footer class="main-footer">
		<div class="main-login-footer-text">
			<span><a href="">이용약관</a></span> | <span><a href="">개인정보
					처리 방침</a></span> | <span><a href="">고객센터</a></span>
		</div>
	</footer>

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
		  		userNickname: "${post.userNicname}",
		  		postCategory: "${post.forumCategory}",
		  		postTitle: "${post.forumTitle}",
		  		postData: "${post.forumDate}"
		  	}<c:if test="${post ne posts[posts.size()-1]}">,</c:if>
		  </c:forEach>
		  ];
  </script>

</body>

</html>