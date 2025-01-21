<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/preset/preset.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/partyForum/partyForumWriting.css">
<script defer src="${pageContext.request.contextPath}/assets/js/preset/mainLogin.js"></script>

<title>파티 모집 글쓰기</title>
</head>

<body>

	<jsp:include page="/app/preset/header.jsp" />

	<main class="partyForumWriting-main">

		<div class="partyForumWriting-main-container">
			<div class="partyForumWriting-main-container-title">
				<h1 class="partyForumWriting-main-title">파티 모집 글쓰기</h1>
			</div>

			<form action="WritingEnd.fo" method="post">
				<div class="partyForumWriting-title">
					<p class="partyForumWriting-title-text">제목</p>
					<input type="text" name="forumTitle" id="title"
						placeholder="제목을 입력하세요(50자)">
				</div>
				<div class="partyForumWriting-content">
					<p class="partyForumWriting-content-text">내용</p>
					<div class="partyForumWriting-content-text-content"
						name="forumContent" contentEditable="true"></div>
					<input type="hidden" name="forumContent" id="hiddenForumContent">
					<script>
					document.querySelector('form').onsubmit = function(event) {
					    // contentEditable 영역의 내용을 가져옴
					    const content = document.querySelector('.partyForumWriting-content-text-content').innerHTML;
					    
					    // hidden input에 내용 할당
					    document.querySelector('#hiddenForumContent').value = content;

					    // 디버깅: 값을 콘솔에 출력하여 제대로 복사됐는지 확인
					    console.log('Title:', document.querySelector('#title').value);  // title 값 확인
					    console.log('Content:', document.querySelector('#hiddenForumContent').value);  // content 값 확인
					};

					form.addEventListener('submit', function () {
					    hiddenInput.value = contentDiv.innerHTML; // contentEditable 내용을 hidden input에 복사
					});
					</script>
				</div>
				<div class="partyForumWriting-file">

					<input type="file" accept=".gif, .jpg, .png" style="display: none;"
						class="partyForumWriting-file-select-button"
						onchange="selectFile()"> <i class="icon-file-image"></i>
					<p class="partyForumWriting-file-select"></p>
					<button type="submit" class="partyForumWriting-button">작성</button>

				</div>
			</form>
		</div>

	</main>

	<jsp:include page="/app/preset/footer.jsp" />


	<script src="${pageContext.request.contextPath}/assets/js/partyForum/partyForumWriting.js"></script>
</body>

</html>