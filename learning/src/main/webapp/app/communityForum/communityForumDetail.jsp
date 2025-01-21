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
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/preset/preset.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityFourm/communityForumDetail.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/preset/mainLogin.js"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/communityForum/communityForumDetail.js"></script>

  <title>키보드워리어님의 게시글</title>
</head>

<body>
  <!-- <div class="communityForum-container"> -->


    <jsp:include page="/app/preset/header.jsp" />
  <main class="communityForumDetail-main">
    <div class="communityForumDetail-main-container-title">
      <h1 class="communityForumDetail-main-title">커뮤니티 게시판</h1>
    </div>

    <div class="communityForumDetail-title">
      <p class="communityForumDetail-title-content"></p>
      <p class="communityForumDetail-title-text"></p>
    </div>

    <div class="communityForumDetail-writer">
      <p class="communityForumDetail-writer-text">작성자 : </p>
      <p class="communityForumDetail-writer-userName"></p>
      <p class="communityForumDetail-writer-uploadTime"></p>
    </div>

    <div class="communityForumDetail-content">
      <div class="communityForumDetail-content-text"></div>
      <img class="communityForumDetail-content-images" alt="사용자 이미지">
    </div>
    <div class="communityForumDetail-button-container">
      <button class="communityForumDetail-communityForum-index-button">목록</button>
      <button class="communityForumDetail-edit-button">수정</button>
      <form action="" method=""><button class="communityForumDetail-delete-button" type="submit">삭제</button></form>
    </div>

    <div class="communityForumDetail-comment-list-container">
      <div class="communityForumDetail-comment-input"><input type="text" placeholder="댓글을 입력해 주세요"></div>
      <button>등록</button>
    </div>
    <div class="communityForumDetail-commnet-list-container">
      <ul class="communityForumDetail-comment-list">
        <li class="communityForumDetail-comment-list-item">
          <div class="communityForumDetail-comment-list-details">
            <p class="communityForumDetail-comment-list-userName"></p>
            <p class="communityForumDetail-comment-list-colon"></p>
            <p class="communityForumDetail-comment-list-content"></p>
            <p class="communityForumDetail-comment-list-time"></p>
          </div>
          <hr class="communityForumDetail-comment-line-line">
        </li>

        <!-- <li class="communityForumDetail-comment-list-item">
          <div class="communityForumDetail-comment-list-details">
            <p class="communityForumDetail-comment-list-userName">키보드워리어</p>
            <p class="communityForumDetail-comment-list-colon">:</p>
            <p class="communityForumDetail-comment-list-content">브론즈ㅋㅋㅋㅋ 웃기네요</p>
            <p class="communityForumDetail-comment-list-time">2025-01-11 22:22</p>
            <button class="communityForumDetail-comment-delete">삭제</button>
          </div>
          <hr class="communityForumDetail-comment-line-line">
        </li> -->
      </ul>
    </div>
  </main>

  <jsp:include page="/app/preset/footer.jsp" />

<script type="text/javascript">
  	const postDetails = [
  		<c:forEach var="detail" items="${details}">
  			{
  				detailTitle: "${detail.forumTitle}",
  				detailUserNickName: "${detail.userNickName}",
  				detailCategory: "${detail.forumCategory}",
  				detailData: "${detail.forumDate}",
  				detailContent: "${detail.forumContent}"
  			}<c:if test="${detail ne details[details.size()-1]}">,</c:if>
  		</c:forEach>
  	];
  	const detailsComment = [
  		<c:forEach var="comment" items="${comments}">
  			{
  				commentUserNickName: "${comment.userNickName}",
  				commentContent: "${comment.commentContent}",
  				commentDate: "${comment.commentDate}"
  			}<c:if test="${comment ne comments[comments.size()-1]}">,</c:if>
  		</c:forEach>
  	];
  	const loginUserName = {
  			userName: "${loginUserName}"
  	};
  	const postDetailsNumber = {
  			postNumber: "${postNum}"
  	};
  </script>

</body>

</html>