<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/preset/preset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/partyForum/partyForumEdit.css">
    <script defer src="${pageContext.request.contextPath}/assets/js/preset/mainLogin.js"></script>
    <title>파티 모집 글 수정</title>
</head>
<body>
    <jsp:include page="/app/preset/header.jsp" />
    <main class="partyForumEdit-main">
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
    </main>
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
    </script>
    <script src="${pageContext.request.contextPath}/assets/js/partyForum/partyForumEdit.js"></script>
</body>
</html>
