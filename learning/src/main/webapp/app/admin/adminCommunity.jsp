<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.util.List"%>
<% if(session.getAttribute("adminDTO")==null){
   response.sendRedirect(request.getContextPath()+"/app/admin/adminLogin.jsp");
}%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/preset/adminPreset.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/adminParty.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/deleteFont/fontello.css">
</head>
<title>커뮤니티 관리</title>

<body>
	<!-- <div class="mng-container"> -->
	<%-- <jsp:include page="/app/preset/adminHeader.jsp" /> --%>
	
	<header class="main-nonLogin-header">
		<nav>
			<div class="main-nonLogin-nav">
				<div class="main-nonLogin-logo">
					<a href="${pageContext.request.contextPath}/adminMain.ad">learning</a>
				</div>
				<ul class="main-nonLogin-contents main-nonLogin-ul">
					<div class="mng-users-contentes-drop">
						<div class="mng-users-text">
							<a href="${pageContext.request.contextPath}/adminUser.ad">회원
								관리</a>
							<div id="mng-users-dropText">
								<a href="${pageContext.request.contextPath}/ben.ad">밴 회원 관리</a>
							</div>
						</div>
					</div>
					<li id="mng-contents-drop">게시글 관리
						<div class="mng-header-drop" onclick="">
							<div id="mng-header-dropDown1">
								<a href="${pageContext.request.contextPath}/adminParty.ad">파티
									관리</a>
							</div>
							<div id="mng-header-dropDown2">
								<a href="${pageContext.request.contextPath}/adminCommunity.ad">커뮤니티</a>
							</div>
						</div>
					</li>
				</ul>
			</div>
			<ul class="main-nonLogin-join-box main-nonLogin-ul">
				<li class="main-nonLogin-join"><a
					href="${pageContext.request.contextPath}/adminlogoutOk.ad">로그아웃</a></li>
			</ul>
		</nav>
	</header>
	
	
	<main class="mng-main">
		<div class="mng-main-container">
			<div class="mng-main-container-title">
				<h1 class="mng-main-title">커뮤니티 관리</h1>
			</div>

			<div class="mng-options-container">
      	<button id="reset-search-button"><a href="${pageContext.request.contextPath}/adminCommunity.ad">초기화</a></button>
				<div class="mng-options-search">
					<form action="${pageContext.request.contextPath}/adminSearchCommunity.ad"
						method="get">
						<input type="text" name="nickname" id="manager-ban-user-search" placeholder="닉네임 검색" maxlength="30" value=<%= request.getAttribute("nickname") != null? request.getAttribute("nickname") : "" %>>
					</form>
				</div>
    	</div>

				
			<div class="manager-ban-user-list-header-container">
				<hr class="manager-ban-user-list-line">
				<div class="manager-ban-user-list-main">
					<div class="manager-ban-user-main-list-user-id">
						<p>게시글 번호</p>
					</div>
					<div class="manager-ban-user-main-list-nickname">
						<p>닉네임</p>
					</div>
					<div class="manager-ban-user-main-list-tier">
						<p>티어</p>
					</div>
					<div class="ban-date">
						<div class="manager-ban-user-main-list-title">
							<p>제목</p>
						</div>
						<div class="manager-ban-user-main-list-category">
							<p>카테고리</p>
						</div>
						<div class="manager-ban-user-main-list-date">
							<p>작성시간</p>
						</div>
					</div>
					<div class="manager-ban-user-main-list-controll-button">
						<p>관리버튼</p>
					</div>
				</div>
				<hr class="manager-ban-user-list-line">
				<ul class="manager-ban-user-list">
					<c:choose>
						<c:when test="${not empty adminCommunity}">
							<c:forEach var="admin" items="${adminCommunity}">
								<li class="manager-ban-user-list-item" id="post-${admin.forumNumber}">
									<div class="manager-list-writeNum">
										<c:out value="${admin.forumNumber}" />
									</div>
									<div class="manager-list-nickName">
										<c:out value="${admin.userNickname}" />
									</div>
									<div class="manager-list-tier">
										<c:out value="${admin.userTier}" />
									</div>
									<div class="manager-list-title">
										<c:out value="${admin.forumTitle}" />
									</div>
									<div class="manager-list-category">
										<c:out value="${admin.forumCategory}" />
									</div>
									<div class="manager-list-write-time">
										<c:out value="${fn:substring(admin.forumDate, 0, 10)}" />
									</div>
									<%-- <a href="${pageContext.request.contextPath}/deleteForum.ad?forumNumber=${admin.forumNumber}" class="mng-delete-button"> --%>
									<button class="ban-controll" type="button" onclick="deletePost(${admin.forumNumber})">삭제</button>
								</li>
								<hr class="manager-ban-user-list-line" id="hr-${admin.forumNumber}">
							</c:forEach>
						</c:when>
						<%-- <c:otherwise>
							<div>
								<div colspan="5" align="center">등록된 게시물이 없습니다.</div>
							</div>
						</c:otherwise> --%>
					</c:choose>
				</ul>
			</div>
		</div>
		
		<%-- <div class="mng-box-footer">
            <div id="mng-totalcount">총 모집 게시글 수 : ${totalPartyForumCount}개</div>
         </div> --%>
		<div class="mng-box-footer">
			<div id="mng-totalcount">전체 파티 게시글 수 : ${totalCommunityCount}개</div>
		</div>
		<div class="pagination">
			<ul>
				<!-- ========== 페이징 처리 예시 ============ -->
				<!-- 				<li><a href="#" class="prev">&lt;</a></li>
					<li><a href="#" class="active">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#" class="next">&gt;</a></li> -->
				<c:if test="${prev}">
					<li><a
						href="${pageContext.request.contextPath}/adminSearchCommunity.ad?
						nickname=<%= request.getAttribute("nickname") != null ? 
						request.getAttribute("nickname") : "" %>&page=${startPage - 1}"
						class="prev">&lt;</a></li>
				</c:if>
				<c:set var="realStartPage" value="${startPage < 0 ? 0:startPage}" />
				<c:forEach var="i" begin="${realStartPage}" end="${endPage}">
					<c:choose>
						<c:when test="${!(i == page)}">
							<li><a
								href="${pageContext.request.contextPath}/adminSearchCommunity.ad?
								nickname=<%= request.getAttribute("nickname") != null ? 
								request.getAttribute("nickname") : "" %>&page=${i}">
									<c:out value="${i}" />
							</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="#" class="active"> <c:out value="${i}" />
							</a></li>
						</c:otherwise>
					</c:choose>

				</c:forEach>
				<c:if test="${next}">
					<li><a
						href="${pageContext.request.contextPath}/adminSearchCommunity.ad?
						nickname=<%= request.getAttribute("nickname") != null ? 
						request.getAttribute("nickname") : "" %>&page=${endPage + 1}"
						class="next">&gt;</a></li>
				</c:if>
				<!-- ========== /페이징 처리 예시 ============ -->
			</ul>
		</div>
	</main>
	<%-- <jsp:include page="/app/preset/adminFooter.jsp" /> --%>
	<footer class="main-footer">
		<div class="main-nonLogin-footer-text">
			<span><a href="">이용약관</a></span> | <span><a href="">개인정보
					처리 방침</a></span> | <span><a href="">고객센터</a></span>
		</div>
	</footer>
	<script>
    var contextPath = "<%= request.getContextPath() %>";
	</script>
	<script defer src="${pageContext.request.contextPath}/assets/js/admin/adminCommunity.js"></script>
</body>

</html>