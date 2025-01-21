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
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityFourm/communityForumEdit.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/preset/mainLogin.js"></script>

  <title>커뮤니티 글 수정</title>
</head>

<body>
  <!-- <div class="communityForum-container"> -->


  <jsp:include page="/app/preset/header.jsp" />
  <main class="communityForumEdit-main">
    <div class="communityForumEdit-main-container">
      <div class="communityForumEdit-main-container-title">
        <h1 class="communityForumEdit-main-title">커뮤니티 글 수정하기</h1>
      </div>

      <div class="communityForumEdit-category">
        <p class="communityForumEdit-category-text">카테고리</p>
        <input type="radio" name="edit-category" id="free">
        <p class="communityForumEdit-category-free-text">자유</p>
        <input type="radio" name="edit-category" id="strategy">
        <p class="communityForumEdit-category-strategy-text">공략</p>
      </div>
      <div class="communityForumEdit-title">
        <p class="communityForumEdit-title-text">제목</p>
        <input type="text" name="communityForumEdit-title-text-value" id="title" placeholder="제목을 입력하세요(50자)">
      </div>
      <div class="communityForumEdit-content">
        <p class="communityForumEdit-content-text">내용</p>
        <div class="communityForumEdit-content-text-content" contentEditable="true">
          <!-- <textarea name="communityForumEdit-content-text-value" id="content" placeholder="내용을 입력하세요(1000자)">
제가 25살에 브론즈를 찍게 된 이유를 설명할게요
사실 롤을 시작한건 40년전이였는데 이때 내가 첫 컴퓨터 게임이 롤이였습니다
그러다가 랭크 열심히 돌려서 어쩌구 저쩌구
이렇게 되었습니다
마지막은 노루가 노루를 핥는 "노루스름한 맛"을 보고 가십쇼</textarea> -->
          <!-- <img class="communityForumEdit-content-text-content-image" src="https://img.danawa.com/images/descFiles/4/191/3190277_1465825876125.jpeg" alt="없음"> -->
        </div>


      </div>
      <div class="communityForumEdit-file">
        <input type="file" accept=".gif, .jpg, .png" style="display:none;" class="communityForumEdit-file-select-button"
          onchange="selectFile()">
        <i class="icon-file-image"></i>
        <p class="communityForumEdit-file-select"></p>
        <button class="communityForumEdit-editCancel-button">수정취소</button>
        <button class="communityForumEdit-editComplete-button">수정완료</button>
      </div>
    </div>
  </main>

  <jsp:include page="/app/preset/footer.jsp" />


  <script src="${pageContext.request.contextPath}/assets/js/communityForum/communityForumEdit.js"></script>
</body>

</html>