<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	href="${pageContext.request.contextPath}/assets/css/partyForum/partyForumDetail.css">
<script defer
	src="${pageContext.request.contextPath}/assets/js/preset/mainLogin.js"></script>


<title>작성자님의 게시글</title>

</head>
<body>
	<jsp:include page="/app/preset/header.jsp" />

	<div class="container">
		<c:forEach var="forumDetail" items="${forumDetail}">
			<div class="view-wrap">
				<div class="view-title">
					<h1>
						<c:out value="${forumDetail.forumTitle}" />
						<!-- +++++++++ -->
					</h1>
				</div>
				<div class="view-info">
					<div class="info-title">
						<div class="title-wrap">
							<span class="writer">작성자</span>
							<!-- 임시 작성자 -->
							<div class="content-writer">
								<c:out value="${forumDetail.userNickname}" />
								<!-- +++++++++ -->
							</div>
						</div>
						<div class="title-wrap">
							<span class="date">작성일</span>
							<div class="content-date">
								<c:out value="${forumDetail.forumDate}" />
								<!-- +++++++++ -->
							</div>
						</div>
						<%-- <div class="title-wrap">
						<span class="hit">조회수</span>
						<!-- 임시 조회수 -->
						<div class="content-hit">
							<c:out value="${community.getBoardReadCount()}" />
							<!-- +++++++++ -->
						</div>
					</div> --%>
					</div>
				</div>
				<!-- 임시 내용 -->
				<div class="view-content">
					<c:out value="${forumDetail.forumContent}" />
					<!-- +++++++++ -->
				</div>
				<!-- 임시 첨부 파일 -->
				<div class="view-attach">
					<!-- 수정중 -->
					<c:forEach var="forumFiles" items="${forumFiles}">
						<div class="img-box">
							<img
								src="${pageContext.request.contextPath}/upload/${forumFiles.fileOriginalName}" />
						</div>
					</c:forEach>
				</div>
				<div class="btn-group">
					<!-- 목록 버튼 -->
					<button type="button" class="list-btn"
						onclick="location.href='${pageContext.request.contextPath}/app/partyForum/partyForum.fo'">목록</button>

					<!-- 수정 및 삭제 버튼 (로그인한 사용자가 작성자인 경우에만 표시) -->
					<c:if test="${sessionScope.userDTO!=null and sessionScope.userDTO.userNumber==forumDetail.userNumber}">
						<c:if test="true">
							<%-- test="${(sessionScope.userDTO).getUserNumber() == community.getUserNumber()}"> --%>
							<button type="button" class="modify-btn"
								onclick="location.href='${pageContext.request.contextPath}/app/partyForum/partyForumEdit.fo?postNum=${forumDetail.forumNumber}'">수정</button>
							<button type="button" class="delete-btn"
								onclick="location.href='${pageContext.request.contextPath}/app/partyForum/partyForumDelete.fo?postNum=${forumDetail.forumNumber}'">삭제</button>
						</c:if>
					</c:if>
				</div>

				<div class="btn-apply">
					<button type="button" class="apply-btn">참가 신청</button>
				</div>

				<!-- 댓글 수정중 -->
				<div class="comment-form">
					<form id="comment-form">
						<input type="hidden" name="forumNumber"
							value="${forumDetail.forumNumber}">
						<div class="form-group">
							<textarea name="content" id="content" placeholder="댓글 내용을 입력하세요."></textarea>
						</div>
						<button type="button" class="submit-btn">댓글 작성</button>
					</form>
				</div>

				<div class="comment-list">
					<!-- 리스트 예시 -->
					<ul id="comment-list">
						<li>
							<div class="comment-info">
								<span class="writer"></span> <span class="date"></span>
							</div>
							<div class="comment-content-wrap">
								<div class="comment-content">
									<p></p>
								</div>
								<div class="comment-btn-group">
									<button type=button class="comment-delete">삭제</button>
								</div>
							</div>
						</li>
					</ul>
					<!-- /리스트 예시 -->
				</div>

				<!-- 댓글 수정중 -->


			</div>
		</c:forEach>
	</div>

	<jsp:include page="/app/preset/footer.jsp" />
	<script>
	const contextPath = '<%=request.getContextPath()%>';
	const userId = `${userDTO.userId}`;
	<c:forEach var="forumDetail" items="${forumDetail}">
		const postNum = `${forumDetail.forumNumber}`;
	</c:forEach> 
	/* console.log(userId + "userId출력확인"); */
	</script>
	<script
		src="${pageContext.request.contextPath}/assets/js/partyForum/partyForumDetail.js"></script> 
</body>

</html>