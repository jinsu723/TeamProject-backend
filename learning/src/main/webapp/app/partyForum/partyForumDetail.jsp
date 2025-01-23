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

	<main class="partyForumDetail-main">
		<div class="partyForumDetail-main-container-title">
			<h1 class="partyForumDetail-main-title">파티 모집 게시판</h1>
		</div>

		<div class="partyForumDetail-title">
			<p class="partyForumDetail-title-content">제목</p>
			<p class="partyForumDetail-title-text">티어</p>
		</div>

		<div class="partyForumDetail-writer">
			<p class="partyForumDetail-writer-text">작성자 :</p>
			<p class="partyForumDetail-writer-userName">닉네임</p>
			<p class="partyForumDetail-writer-uploadTime">날짜</p>
		</div>


		<div class="partyForumDetail-content">
			<div class="partyForumDetail-content-text">값</div>
			<!--       <img class="partyForumDetail-content-images" 
      alt="사용자 이미지"> -->
		</div>
		<c:forEach var="forumDetail" items="${forumDetail}">
			<div class="partyForumDetail-button-container">
				<button class="partyForumDetail-partyForum-index-button">목록</button>

				<c:if
					test="${forumDetail.userId == sessionScope.userDTO.userId and ApplyNum == 0}">
					<button class="partyForumDetail-edit-button">수정</button>
					<button class="partyForumDetail-delete-button">삭제</button>
				</c:if>

				<c:if
					test="${forumDetail.userId == sessionScope.userDTO.userId and ApplyNum != 0}">
					<button class="partyForumDetail-edit-button">수정</button>
					<button class="partyForumDetail-delete-button" disabled
						style="cursor: default;">삭제</button>
				</c:if>

				<c:if
					test="${sessionScope.userDTO == NULL or forumDetail.userId != sessionScope.userDTO.userId}">
					<button class="partyForumDetail-edit-button" disabled
						style="display: none;">수정</button>
					<button class="partyForumDetail-delete-button" disabled
						style="display: none">삭제</button>
				</c:if>
			</div>


			<%--    세션에 저장된 userId: ${sessionScope.userDTO.userId} --%>
			<c:if
				test="${sessionScope.userDTO != NULL and duplication == 0 and forumDetail.userId != sessionScope.userDTO.userId}">
				<!-- userDTO가 있을 경우 참가신청 버튼을 활성화 -->
				<form action="partyForumApply.fo" method="get"
					onsubmit="return confirm('참가 하시겠습니까??');">
					<input type="hidden" name="userId"
						value="${sessionScope.userDTO.userId}"> <input
						type="hidden" name="postNum" value="${param.postNum}">
					<div class="partyForumDetail-button-userApply">
						<button class="partyForumDetail-userApply-button">참가신청</button>
					</div>
				</form>
			</c:if>

			<c:if
				test="${sessionScope.userDTO == NULL or duplication != 0 or forumDetail.userId == sessionScope.userDTO.userId}">
				<!-- userDTO가 없을 경우 참가신청 버튼을 비활성화 -->
				<div class="partyForumDetail-button-userApply">
					<button class="partyForumDetail-userApply-button" disabled>참가신청</button>
				</div>
			</c:if>




			<br>
			<c:if test="${sessionScope.userDTO != NULL}">
				<div class="partyForumDetail-comment-list-container">
					<div class="partyForumDetail-comment-input">
						<input id="commentInput" type="text" placeholder="댓글을 입력해 주세요">
					</div>
					<button>등록</button>
				</div>
			</c:if>
			<c:if test="${sessionScope.userDTO == NULL}">
				<div class="partyForumDetail-comment-list-container">
					<div class="partyForumDetail-comment-input">
						<input type="text" placeholder="댓글을 입력해 주세요" disabled>
					</div>
					<button disabled style="cursor: default;">등록</button>
				</div>
			</c:if>
		</c:forEach>

		<div class="partyForumDetail-commnet-list-container">
			<ul class="partyForumDetail-comment-list">
				<c:forEach var="comment" items="${forumComment}">
					<li class="partyForumDetail-comment-list-item"
						data-comment-number="${comment.commentNumber}">
						<div class="partyForumDetail-comment-list-details">
							<p class="partyForumDetail-comment-list-userName">${comment.userNickname}</p>
							<p class="partyForumDetail-comment-list-colon">:</p>
							<p class="partyForumDetail-comment-list-content">${comment.commentContent}</p>
							<p class="partyForumDetail-comment-list-time">${comment.commentDate}</p>
							<c:if test="${comment.userId == sessionScope.userDTO.userId}">
								<button class="partyForumDetail-comment-delete">삭제</button>
							</c:if>
						</div>
						<hr class="partyForumDetail-comment-line-line">
					</li>
				</c:forEach>
			</ul>
		</div>


	</main>

	<jsp:include page="/app/preset/footer.jsp" />

	<script>
	const contextPath = '<%=request.getContextPath()%>';
    var postNum = '${param.postNum}';
    console.log("JavaScript에서 받은 postNum:", postNum);
    
    const userId = '${sessionScope.userDTO.userId}';
    console.log("JavaScript에서 받은 userId:", userId);
    
	  const forumDetail = [
		  <c:forEach var="forumDetail" items="${forumDetail}">{
			 	 forumNumber: "${forum.forumNumber}",
				forumTitle: "${forumDetail.forumTitle}",
	 			userTier: "${forumDetail.userTier}",
				userNickname: "${forumDetail.userNickname}",
				forumDate: "${forumDetail.forumDate}",
				forumUpdate: "${forumDetail.forumUpdate}",
				forumContent: "${forumDetail.forumContent}",
			  	}
			  </c:forEach>
			  ];  
  
	  forumDetail.forEach((forum) => {
	      console.log(forum.forumUpdate);
	      console.log(forum.forumDate);
	  });
	  const forumComment = [
		  <c:forEach var="forumComment" items="${forumComment}">{
			  userNickname: "${forumComment.userNickname}",
			  userId: "${forumComment.userId}",
			  commentContent: "${forumComment.commentContent}",
			  commentDate: "${forumComment.commentDate}",
			  	},
			  </c:forEach>
			  ]; 
  
  </script>


	<script
		src="${pageContext.request.contextPath}/assets/js/partyForum/partyForumDetail.js"></script>
</body>

</html>