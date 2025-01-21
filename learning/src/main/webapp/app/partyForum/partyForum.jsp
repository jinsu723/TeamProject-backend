<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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

<jsp:include page="/app/preset/header.jsp" />

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
				<form action="partyWriting.fo" method="post">
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

	<jsp:include page="/app/preset/footer.jsp" />
	
<script>
const forumCount = {
	forumNumber: ${ partyForumCount }	
};

const forumList = [
  <c:forEach var="forum" items="${forumList}">{
			forumNumber: "${forum.forumNumber}",
 			userNickname: "${forum.userNickname}",
 			userTier: "${forum.userTier}",
  			forumTitle: "${forum.forumTitle}",
  			forumDate: "${forum.forumDate}",
	  	}<c:if test="${forum ne forumList[forumList.size()-1]}">,</c:if>
	  </c:forEach>
	  ];
</script>

	<script src="${pageContext.request.contextPath}/assets/js/partyForum/partyForum.js"></script>
</body>

</html>