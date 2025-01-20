<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/preset/preset.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/partyForum/partyForum.css">
	<script defer src="${pageContext.request.contextPath}/assets/js/preset/mainLogin.js"></script>



	<title>파티 모집 게시글 목록</title>
</head>

<body>

	<header class="main-header">
		<nav class="main-header-container">
			<div class="main-header-content">
				<div class="main-header-logo">
					<a href="${pageContext.request.contextPath}/app/preset/main.jsp">learnning</a>
				</div>
				<div class="main-header-post-container">
					<a href="${pageContext.request.contextPath}/app/partyForum/partyForum.fo">
						<li>파티 모집</li>
					</a> <a href="${pageContext.request.contextPath}/app/communityForum/communityForum.jsp">
						<li>커뮤니티</li>
					</a>
				</div>
			</div>
			<c:choose>
				<c:when test="${not empty sessionScope.userDTO}">
					<div class="main-header-dropdown-container">
						<div class="main-header-user-box">
							<i class="icon-down-dir"></i>
							<%= session.getAttribute("userNickname") %><i class="icon-user-circle-o"></i>
						</div>
						<div class="main-header-dropdown">
							<a href="${pageContext.request.contextPath}/app/myPage/checkPass.jsp">• 개인 정보 수정</a>
							<hr />
							<a href="${pageContext.request.contextPath}/app/myPage/myPageRecruitment.jsp">• 모집 현황</a>
							<hr />
							<a href="${pageContext.request.contextPath}/myPageMyPost.my">• 내 게시물</a>
							<hr />
							<a href="${pageContext.request.contextPath}/logoutOk.us">• 로그 아웃</a>
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

	<main class="partyForum-main">
		<div class="partyForum-main-container">
			<div class="partyForum-main-container-title">
				<h1 class="partyForum-main-title">파티 모집</h1>
			</div>

			<div class="partyForum-options-container">
				<div class="partyForum-options-search">
					<i class="icon-search"></i> <input type="text" name="search" id="partyForum-search" placeholder="내용 검색">
					<i class="icon-down-dir"></i>
				</div>
				<form action="partyWriting.fo" method="get">
					<div class="partyForum-write-button">
						<button type="submit" class="partyForum-write-btn">글쓰기</button>
					</div>
				</form>
			</div>


			<div class="partyForum-list-header-container">
				<hr class="partyForum-list-line">
				<div class="partyForum-list-main">
					<div class="partyForum-main-list-writer">
						<p>작성자</p>
					</div>
					<div class="partyForum-main-list-userSkill">
						<p>유저실력</p>
					</div>
					<div class="partyForum-main-list-title">
						<p>제목</p>
					</div>
					<div class="partyForum-main-list-write-time">
						<p>작성시간</p>
					</div>
				</div>
				<hr class="partyForum-list-line">

				<!-- 리스트들을 담을 ul 태그 -->
				<ul class="partyForum-list">
					<%-- <c:forEach var="forum" items="${forumList}">
						<li class="partyForum-list-item">
							<div class="partyForum-list-writer">${forum.userNickname}</div>
							<div class="partyForum-list-userSkill">언랭</div>
							<div class="partyForum-list-title">${forum.forumTitle}</div>
							<div class="partyForum-list-write-time">${forum.forumDate}</div>
						</li>
						<hr class="partyForum-list-item-line">
						</c:forEach> --%>

				</ul>
			</div>
		</div>
		<div class="partyForum-page-number-container">
			<div class="partyForum-page-number-button">
				<i class="icon-angle-double-left"></i> <i class="icon-left-open"></i>
				<div class="partyForum-page-numbers"></div>
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

<script>
const forumCount = {
	forumNumber: ${ partyForumCount }	
};

const forumList = [
  <c:forEach var="forum" items="${forumList}">{
 			userNickname: "${forum.userNickname}",
  			forumTitle: "${forum.forumTitle}",
  			forumDate: "${forum.forumDate}",
	  	}<c:if test="${forum ne forumList[forumList.size()-1]}">,</c:if>
	  </c:forEach>
	  ];
</script>

	<script src="${pageContext.request.contextPath}/assets/js/partyForum/partyForum.js"></script>
</body>

</html>