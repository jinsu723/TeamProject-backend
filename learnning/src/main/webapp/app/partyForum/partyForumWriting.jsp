<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

	<header class="main-header">
		<nav class="main-header-container">
			<div class="main-header-content">
				<div class="main-header-logo">
					<a href="">learnning</a>
				</div>
				<div class="main-header-post-container">
					<a href="../partyForum/partyForum.html">
						<li>파티 모집</li>
					</a> <a href="../communityForum/communityForum.html">
						<li>커뮤니티</li>
					</a>
				</div>
			</div>
			<div class="main-header-dropdown-container">
				<div class="main-header-user-box">
					<i class="icon-down-dir"></i>사용자<i class="icon-user-circle-o"></i>
				</div>
				<div class="main-header-dropdown">
					<a href="../myPage/checkPass.html">• 개인 정보 수정</a>
					<hr />
					<a href="../myPage/myPageRecruitment.html">• 모집 현황</a>
					<hr />
					<a href="../myPage/myPageMyPost.html">• 내 게시물</a>
					<hr />
					<a href="./mainNonLogin.html">• 로그 아웃</a>
				</div>
			</div>
		</nav>
	</header>


	<main class="partyForumWriting-main">
		<!-- forumDTO.setForumCategory(request.getParameter("forumCategory"));
		forumDTO.setForumTitle(request.getParameter("forumTitle"));
		forumDTO.setForumContent(request.getParameter("forumContent")); -->

		<div class="partyForumWriting-main-container">
			<div class="partyForumWriting-main-container-title">
				<h1 class="partyForumWriting-main-title">파티 모집 글쓰기</h1>
			</div>

			<form action="WritingEnd.fo" method="post">
				<div class="partyForumWriting-title">
					<p class="partyForumWriting-title-text">제목</p>
					<input type="text" name="forumTitel" id="title"
						placeholder="제목을 입력하세요(50자)">
				</div>
				<div class="partyForumWriting-content">
					<p class="partyForumWriting-content-text">내용</p>
					<div class="partyForumWriting-content-text-content"
						name="forumContent" contentEditable="true"></div>
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

	<footer class="main-footer">
		<div class="main-login-footer-text">
			<span><a href="">이용약관</a></span> | <span><a href="">개인정보
					처리 방침</a></span> | <span><a href="">고객센터</a></span>
		</div>
	</footer>


	<script src="${pageContext.request.contextPath}/assets/js/partyForum/partyForumWriting.js"></script>
</body>

</html>