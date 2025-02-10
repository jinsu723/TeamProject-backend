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
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/preset/adminPreset.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminUser.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/deleteFont/fontello.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminBanUser.css">
  
  <script defer src="${pageContext.request.contextPath}/assets/js/admin/adminUser.js"></script>
</head>
<title>회원 관리</title>

<body>
  <!-- <div class="mng-container"> -->

  <jsp:include page="/app/preset/adminHeader.jsp" />
  
  <main class="mng-main">
    <div class="mng-main-container">
      <div class="mng-main-container-title">
        <div class="mng-main-title">
          <h1 class="mng-user-main-title">회원 관리</h1>
        </div>
      </div>
      <div class="mng-options-container">
        <button id="reset-search-button"><a href="${pageContext.request.contextPath}/adminUser.ad">초기화</a></button>
        <div class="mng-options-search">
          <%-- <form action="${pageContext.request.contextPath}/admin/adminUser" method="get"> --%>
             <i class="icon-search"></i>
             <input type="text" name="nickname" id="manager-ban-user-search" placeholder="내용 검색" maxlength="30">
           <!-- </form> -->
        </div>
      </div>

  <div class="manager-ban-user-list-header-container">
        <hr class="manager-ban-user-list-line">
        <div class="manager-ban-user-list-main">
          <div class="manager-ban-user-main-list-user-id">
            <p>유저번호</p>
          </div>
          <div class="manager-ban-user-main-list-ban-nickname">
            <p>닉네임</p>
          </div>
          <div class="manager-ban-user-main-list-ban-content">
            <p>티어</p>
          </div>
          <div class="ban-date">
          <div class="manager-ban-user-main-list-ban-start-date">
            <p>핸드폰 번호</p>
          </div>
          <div class="manager-ban-user-main-list-ban-end-date">
            <p>회원 생성 시간</p>
          </div>
          <div class="manager-ban-user-main-list-ban-end-date">
            <p>밴 횟수</p>
          </div>
        </div>
          <div class="manager-ban-user-main-list-ban-controll-button">
            <p>관리버튼</p>
          </div> 
        </div>
        <hr class="manager-ban-user-list-line">
        <ul class="manager-ban-user-list">
	      <c:choose>
	        <c:when test="${not empty adminUser}">
	          <c:forEach var="users" items="${adminUser}">
	          	<li class="manager-ban-user-list-item">
		          <div class="manager-ban-user-list-ban-userId">
		          	<c:out value="${users.userNumber}" />
		          </div>
		          <div class="manager-ban-user-list-ban-nickName">
		          	<c:out value="${users.userNickname}" />
		          </div>
		          <div class="manager-ban-user-list-ban-text">
		          	<c:out value="${users.userTier }" />
		          </div>
			      <div class="ban-list-date">
			        <div class="manager-ban-user-list-ban-start-date">
			          <c:out value="${users.userPhone}" />
			        </div>
			        <div class="manager-ban-user-list-ban-end-date">
			          <c:out value="${fn:substring(users.userJoinDate, 0, 10)}" />
			        </div>
			        <div class="manager-ban-user-list-ban-date-count">
			          <c:out value="${users.userBenCnt}" />
			        </div>
			        <div class="manager-ban-user-ban-status">
			          <c:out value="${users.benStatus}" />
			        </div>
		          </div>
		          <button type="submit" class="ban-controll" onclick="banUser('${users.userNickname}, ${users.benStatus}')">밴</button>
	          	</li>
	          	<hr>
	          </c:forEach>
	        </c:when>
	      </c:choose>
        </ul>
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
						href="${pageContext.request.contextPath}/adminUser.ad?page=${startPage - 1}"
						class="prev">&lt;</a></li>
				</c:if>
				<c:set var="realStartPage" value="${startPage < 0 ? 0 : startPage }" />
				<c:forEach var="i" begin="${realStartPage}" end="${endPage}">
					<c:choose>
						<c:when test="${!(i == page)}">
							<li><a
								href="${pageContext.request.contextPath}/adminUser.ad?page=${i}">
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
						href="${pageContext.request.contextPath}/adminUser.ad?page=${endPage + 1}"
						class="next">&gt;</a></li>
				</c:if>
				<!-- ========== /페이징 처리 예시 ============ -->
			</ul>


		</div>
    </div>
      
      <div class="mng-box-footer">
        <div id="mng-totalcount">전체 회원 수 : ${totalUserCount}명</div>
      </div>
    </div>
    
    
  </main>
  
  <jsp:include page="/app/preset/adminFooter.jsp" />

<%-- <script type="text/javascript">
const benStatus = [
			isBen: <%= request.getAttribute("adminUser") %>
	];
</script> --%>
</body>

</html>