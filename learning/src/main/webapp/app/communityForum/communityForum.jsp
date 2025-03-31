<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/preset/preset.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/communityForum/communityForum.css">
<script defer
	src="${pageContext.request.contextPath}/assets/js/preset/mainLogin.js"></script>

<title>커뮤니티 게시글 목록</title>
</head>

<body>

	<jsp:include page="/app/preset/header.jsp" />

	<main class="communityForum-main">
		<div class="communityForum-main-container">
			<div class="communityForum-main-container-title">
				<h1 class="communityForum-main-title">커뮤니티</h1>
			</div>

			<!-- 검색 및 글쓰기 버튼 -->
			<div class="communityForum-options-container">
				<div class="communityForum-options-search">
					<form action="${pageContext.request.contextPath }/app/communityForum/communityForum.cf" method="get">
						<input type="hidden" name="page" value="1"> 
						<i class="icon-search"></i>
						<input type="text" name="FindTitle" id="communityForum-search" placeholder="제목 검색" value="${requestScope.FindTitle}">
					</form>
				</div>

				<c:if test="${sessionScope.userDTO != NULL}">
					<form action="communityWriting.cf" method="post">
						<div class="communityForum-write-button">
							<button type="submit" class="communityForum-write-btn">글쓰기</button>
						</div>
					</form>
				</c:if>
				<c:if test="${sessionScope.userDTO == NULL}">
					<form action="communityWriting.cf" method="post">
						<div class="communityForum-write-button">
							<button type="submit" class="communityForum-write-btn" disabled>글쓰기</button>
						</div>
					</form>
				</c:if>
			</div>

			<!-- 게시글 목록 -->
			<div class="communityForum-list-header-container">
				<hr class="communityForum-list-line">
				<div class="communityForum-list-main">
					<div class="communityForum-main-list-writer">
						<p>작성자</p>
					</div>
					<div class="communityForum-main-list-userSkill">
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
					<c:forEach var="forum" items="${forumList}">
						<li class="communityForum-list-item"
							onclick="location.href='${pageContext.request.contextPath}/app/communityForum/communityForumDetail.cf?postNum=${forum.forumNumber}'">
							<div class="communityForum-list-writer">
								<c:out value="${forum.userNickname}" />
							</div>
							<div class="communityForum-list-userSkill">
								<c:out value="${forum.forumCategory}" />
							</div>
							<div class="communityForum-list-title">
								<c:if test="${forum.forumTitle.length() > 25}">
									<c:out value="${fn:substring(forum.forumTitle, 0, 25)}" />...
								</c:if>
								<c:if test="${forum.forumTitle.length() <= 25}">
									<c:out value="${forum.forumTitle}" />
								</c:if>
							</div>
							<c:if test="${forum.forumUpdate != NULL }">
								<div class="communityForum-list-write-time">
									(최근 수정됨) <c:out value="${forum.forumUpdate.substring(0, 16)}" />
								</div>
							</c:if>
							<c:if test="${forum.forumUpdate == NULL }">
								<div class="communityForum-list-write-time">
									<c:out value="${forum.forumDate.substring(0, 16)}" />
								</div>					
							</c:if>
						</li>
						<div class="communityForum-list-item-line">
							<hr>
						</div>
					</c:forEach>
				</ul>
			</div>
		</div>

		<!-- 페이지네이션 -->
		<div class="pagination">
			<ul>
				<!-- 이전 페이지 버튼 -->
				<c:if test="${prev}">
					<li><a
						href="${pageContext.request.contextPath}/app/communityForum/communityForum.cf?page=${startPage - 1}&FindTitle=${requestScope.FindTitle}"
						class="prev">&lt;</a></li>
				</c:if>

				<c:set var="realStartPage" value="${startPage < 1 ? 1 : startPage}" />

				<!-- 페이지 번호 -->
				<c:forEach var="i" begin="${realStartPage}" end="${endPage}">

					<c:choose>
						<c:when test="${i == page}">
							<li><a href="#" class="active">${i}</a></li>
						</c:when>
						<c:otherwise>
							<li><a
								href="${pageContext.request.contextPath}/app/communityForum/communityForum.cf?page=${i}&FindTitle=${requestScope.FindTitle}">
									<c:out value="${i}" />
							</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<!-- 다음 페이지 버튼 -->
				<c:if test="${next}">
					<li><a
						href="${pageContext.request.contextPath}/app/communityForum/communityForum.cf?page=${endPage + 1}&FindTitle=${requestScope.FindTitle}"
						class="next">&gt;</a></li>
				</c:if>
			</ul>
		</div>
	</main>

	<jsp:include page="/app/preset/footer.jsp" />

</body>
</html>
