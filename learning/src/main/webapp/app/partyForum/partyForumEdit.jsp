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
	href="${pageContext.request.contextPath}/assets/css/partyForum/partyForumWriting.css">
<script defer
	src="${pageContext.request.contextPath}/assets/js/preset/mainLogin.js"></script>
<title>파티 모집 글 수정</title>
</head>
<body>
	<jsp:include page="/app/preset/header.jsp" />
	<div class="container">
		<c:forEach var="forumDetail" items="${forumDetail}">
			<form id="write-form"
				action="${pageContext.request.contextPath}/app/partyForum/partyForumEditEnd.fo"
				method="post" enctype="multipart/form-data">

				<!-- 히든 필드로 게시글 번호 포함 -->
				<input type="hidden" name="postNum"
					value="${forumDetail.forumNumber}" />

				<h1>글 수정</h1>

				<div class="form-group">
					<label for="title">제목</label> <input type="text" id="title"
						name="forumTitle" value="${forumDetail.forumTitle}" required />
				</div>

				<div class="form-group">
					<label for="content">내용</label>
					<textarea id="content" name="forumContent" required><c:out
							value="${forumDetail.forumContent}" /></textarea>
				</div>

				<!-- 파일 업로드 영역 추가 (기존 글쓰기와 동일) -->
				<div class="form-group">
					<label for="file">파일 수정</label>

					<div class="image-upload-wrap">
						<input type="file" id="file" name="boardFile" />
						<div class="image-upload-box">
							<div class="upload-text">
								<div class="upload-icon">
									<svg viewBox="0 0 48 48">
                        <path fill-rule="evenodd" clip-rule="evenodd"
											d="M25.9087 8.12155L36.4566 18.3158C37.2603 18.7156 38.2648 18.6156 38.968 18.3158C39.6712 17.5163 39.6712 16.4169 38.968 15.7173L25.3059 2.5247C24.6027 1.8251 23.4977 1.8251 22.7945 2.5247L9.03196 15.8172C8.32877 16.5168 8.32877 17.6162 9.03196 18.3158C9.73516 19.0154 10.9406 19.0154 11.6438 18.3158L22.2922 8.12155V28.4111C22.2922 29.4106 23.0959 30.2091 24.1005 30.2091C25.105 30.2091 25.9087 29.4106 25.9087 28.4111V8.12155ZM5.61644 29.4104C5.61644 28.4109 4.81279 27.6104 3.80822 27.6104C2.80365 27.6104 2 28.5099 2 29.5093V44.202C2 45.2015 2.80365 46 3.80822 46H44.1918C45.1963 46 46 45.2015 46 44.202V29.5093C46 28.5099 45.1963 27.7113 44.1918 27.7113C43.1872 27.7113 42.3836 28.5099 42.3836 29.5093V42.3021H5.61644V29.4104Z"></path></svg>
								</div>
								<div class="upload-count">
									이미지 업로드(<span class="cnt">0</span>/1)
								</div>
							</div>
							<div class="upload-text">최대 1개까지 업로드 가능</div>
							<div class="upload-text">파일 형식 : jpg, png</div>
							<div class="upload-text">※ 이미지를 등록하면 즉시 반영됩니다.</div>
						</div>
					</div>
					<div class="img-controller-box">
						<ul class="file-list">
							<!-- 기존 업로드된 파일을 보여주는 부분 (서버 연동 필요) -->
							<c:if test="${not empty fileDetail}">
							    <c:forEach var="fileDetail" items="${fileDetail}">
							        <li>
							            <div class="show-img-box">
							                <img src="${pageContext.request.contextPath}/upload/${fileDetail.fileOriginalName}">
							            </div>
							            <div class="btn-box">
							                <button type='button' class='img-cancel-btn' data-name='${fileDetail.fileOriginalName}'>삭제</button>
							            </div>
							        </li>
							    </c:forEach>
							</c:if>
						</ul>
					</div>
				</div>

				<div class="btn-group">
					<button type="submit" class="submit-btn">수정 완료</button>
					<button type="button" class="cancle-btn" onclick="history.back();">취소</button>
				</div>
			</form>
		</c:forEach>
	</div>
	<%--     <main class="partyForumEdit-main">
        <div class="partyForumEdit-main-container">
            <div class="partyForumEdit-main-container-title">
                <h1 class="partyForumEdit-main-title">파티 모집 글 수정하기</h1>
                <h3>신청자가 있다면 게시글 삭제 불가능 합니다!!</h3>
            </div>
            <form action="partyForumEditEnd.fo" method="post">
            <input type="hidden" name="postNum" value="<%= request.getParameter("postNum") %>">
                <div class="partyForumEdit-title">
                    <p class="partyForumEdit-title-text">제목</p>
                    <input type="text" name="forumTitle" id="title" placeholder="제목을 입력하세요(50자)">
                </div>
                <div class="partyForumEdit-content">
                    <p class="partyForumEdit-content-text">내용</p>
                    <div class="partyForumEdit-content-text-content" contentEditable="true"></div>
                    <input type="hidden" name="forumContent" id="hiddenForumContent">
                </div>
                <div class="partyForumEdit-file">
                    <input type="file" accept=".gif, .jpg, .png" style="display:none;" class="partyForumEdit-file-select-button" onchange="selectFile()" style="visibility:hidden">
                    <i class="icon-file-image" style="visibility:hidden"></i>
                    <p class="partyForumEdit-file-select" style="visibility:hidden"></p>
                    <button type="button" class="partyForumEdit-editCancel-button">수정취소</button>
                    <button type="submit" class="partyForumEdit-editComplete-button">수정완료</button>
                </div>
            </form>
        </div>
    </main> --%>
	<jsp:include page="/app/preset/footer.jsp" />
	<script>
    const contextPath = '<%=request.getContextPath()%>';
        const forumDetail = [
            <c:forEach var="forumDetail" items="${forumDetail}">{
                forumNumber: "${forumDetail.forumNumber}",
                forumTitle: "${forumDetail.forumTitle}",
                forumContent: "${forumDetail.forumContent}",
            }
            </c:forEach>
        ];
        <c:if test="${not empty fileDetail}">
			<c:forEach var="fileDetail" items="${fileDetail}">
				const fileOriginalName = `${fileDetail.fileOriginalName}`;
			</c:forEach>
			console.log(fileOriginalName);
		</c:if>

    </script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/js/partyForum/partyForumEdit.js"></script>
</body>
</html>
