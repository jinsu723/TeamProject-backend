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
	href="${pageContext.request.contextPath}/assets/css/partyForum/partyForum.css">
<script defer
	src="${pageContext.request.contextPath}/assets/js/preset/mainLogin.js"></script>

<title>파티 모집 게시글 목록</title>
</head>

<body>
	<c:if test="${not empty sessionScope.message}">
		<script>
			alert("${sessionScope.message}"); // 메시지 출력
		</script>
		<c:remove var="message" scope="session" />
		<!-- 세션에서 메시지 삭제 -->
	</c:if>


	<jsp:include page="/app/preset/header.jsp" />

	<main class="partyForum-main">
		<div class="partyForum-main-container">
			<div class="partyForum-main-container-title">
				<h1 class="partyForum-main-title">파티 모집</h1>
			</div>

			<!-- 검색 및 글쓰기 버튼 -->
			<div class="partyForum-options-container">
				<div class="partyForum-options-search">
					<form
						action="${pageContext.request.contextPath }/app/partyForum/partyForum.fo"
						method="get">
						<input type="hidden" name="page" value="1"> <i
							class="icon-search"></i> <input type="text" name="FindTitle"
							id="partyForum-search" placeholder="제목 검색"
							value="${requestScope.FindTitle}">
					</form>
				</div>

				<c:if test="${sessionScope.userDTO != NULL}">
					<form action="partyWriting.fo" method="post">
						<div class="partyForum-write-button">
							<button type="submit" class="partyForum-write-btn">글쓰기</button>
						</div>
					</form>
				</c:if>
				<c:if test="${sessionScope.userDTO == NULL}">
					<form action="partyWriting.fo" method="post">
						<div class="partyForum-write-button">
							<button type="submit" class="partyForum-write-btn" disabled>글쓰기</button>
						</div>
					</form>
				</c:if>
			</div>

			<!-- 게시글 목록 -->
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

				<ul class="partyForum-list">
					<c:forEach var="forum" items="${forumList}">
						<li class="partyForum-list-item"
							onclick="location.href='${pageContext.request.contextPath}/app/partyForum/partyForumDetail.fo?postNum=${forum.forumNumber}'">
							<div class="partyForum-list-writer">
								<c:out value="${forum.userNickname}" />
							</div>
							<div class="partyForum-list-userSkill">
								<c:out value="${forum.userTier}" />
							</div>
							<div class="partyForum-list-title">
								<c:if test="${forum.forumTitle.length() > 25}">
									<c:out value="${fn:substring(forum.forumTitle, 0, 25)}" />...
								</c:if>
								<c:if test="${forum.forumTitle.length() <= 25}">
									<c:out value="${forum.forumTitle}" />
								</c:if>
							</div> <c:if test="${forum.forumUpdate != NULL }">
								<div class="partyForum-list-write-time">
									(최근 수정됨)
									<c:out value="${forum.forumUpdate.substring(0, 16)}" />
								</div>
							</c:if> <c:if test="${forum.forumUpdate == NULL }">
								<div class="partyForum-list-write-time">
									<c:out value="${forum.forumDate.substring(0, 16)}" />
								</div>
							</c:if>
						</li>
						<div class="partyForum-list-item-line">
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
						href="${pageContext.request.contextPath}/app/partyForum/partyForum.fo?page=${startPage - 1}&FindTitle=${requestScope.FindTitle}"
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
								href="${pageContext.request.contextPath}/app/partyForum/partyForum.fo?page=${i}&FindTitle=${requestScope.FindTitle}">
									<c:out value="${i}" />
							</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<!-- 다음 페이지 버튼 -->
				<c:if test="${next}">
					<li><a
						href="${pageContext.request.contextPath}/app/partyForum/partyForum.fo?page=${endPage + 1}&FindTitle=${requestScope.FindTitle}"
						class="next">&gt;</a></li>
				</c:if>
			</ul>
		</div>
	</main>

	<jsp:include page="/app/preset/footer.jsp" />

</body>
</html>
