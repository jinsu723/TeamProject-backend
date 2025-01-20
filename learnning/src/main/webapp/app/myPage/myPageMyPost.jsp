<%@page import="com.learning.app.dto.MyForumDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.learning.app.dto.ForumDTO"%>
<%@page import="com.learning.app.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% if(session.getAttribute("userDTO")==null){
	System.out.println("없음");
	response.sendRedirect(request.getContextPath()+"/app/user/login/login.jsp");
}%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/preset/preset.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/myPage/myPageMyPost.css">
  <script src="https://kit.fontawesome.com/06edfe60eb.js" crossorigin="anonymous"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/myPageMain/myPageMyPost.js"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/preset/mainLogin.js"></script>
  <title>내 게시글</title>
</head>

<body>
  <header class="main-header">
    <nav class="main-header-container">
      <div class="main-header-content">
        <div class="main-header-logo">
          <a href="${pageContext.request.contextPath}/app/preset/main.jsp">learnning</a>
        </div>
        <div class="main-header-post-container">
          <a href="${pageContext.request.contextPath}/app/partyForum/partyForum.jsp">
            <li>파티 모집</li>
          </a> <a href="${pageContext.request.contextPath}/app/communityForum/communityForum.jsp">
            <li>커뮤니티</li>
          </a>
        </div>
      </div>
      <c:choose>
        <c:when test="${not empty sessionScope.userDTO}">
          <div class="main-header-dropdown-container">
            <div class="main-header-user-box">
              <i class="icon-down-dir"></i>
              <%= session.getAttribute("userNickname") %><i class="icon-user-circle-o"></i>
            </div>
            <div class="main-header-dropdown">
              <a href="${pageContext.request.contextPath}/app/myPage/checkPass.jsp">• 개인 정보 수정</a>
              <hr />
              <a href="${pageContext.request.contextPath}/app/myPage/myPageRecruitment.jsp">• 모집 현황</a>
              <hr />
              <a href="${pageContext.request.contextPath}/myPageMyPost.my">• 내 게시물</a>
              <hr />
              <a href="${pageContext.request.contextPath}/logoutOk.us">• 로그 아웃</a>
            </div>
          </div>
        </c:when>
        <c:otherwise>
          <div class="main-nlog-header-container">
            <li class="main-nlog-header-join"><a
                href="${pageContext.request.contextPath}/app/user/login/login.jsp">로그인</a></li>
            <li class="main-nlog-header-join"><a
                href="${pageContext.request.contextPath}/app/user/signUp/signUp1.jsp">회원가입</a></li>
          </div>
        </c:otherwise>
      </c:choose>
    </nav>
  </header>
  <main>
    <div class="myPage-container">
      <h1 class="myPage-forum-text">나의 게시물 관리</h1>
      <hr style="width: 70%;">
      <div class="myPage-content" style="width: 70%;">
        <span class="nick">닉네임</span>
        <span class="tear">티어</span>
        <span class="categori">카테고리</span>
        <span class="title">제목</span>
        <span class="comment">댓글 수</span>
        <span class="date">작성시간</span>
      </div>
      <hr style="width: 70%;">
      <div class="myPage-main"></div>

    </div>
    <div class="myPage-pageNation">
      <span><i class="fa-solid fa-angles-left"></i></span>
      <span><i class="fa-solid fa-chevron-left"></i></span>
      <div class="myPage-pageNation-number"></div>
      <span><i class="fa-solid fa-chevron-right"></i></span>
      <span><i class="fa-solid fa-angles-right"></i></span>
    </div>
  </main>
  <footer class="main-footer">
    <div class="main-login-footer-text">
      <span><a href="">이용약관</a></span> | <span><a href="">개인정보 처리 방침</a></span> | <span><a href="">고객센터</a></span>
    </div>
  </footer>
</body>

<script type="text/javascript">
let current = 1;
let arr = [];
<% 
if(session.getAttribute("userDTO")!=null){
	List<MyForumDTO> list = (List<MyForumDTO>) request.getAttribute("posts");
	if(list != null){
		for(int i = 0; i < list.size(); i++){
			MyForumDTO data = list.get(i);
			%>arr[<%=i%>] = <%=data%>;<%
		}
	}
%>
const pageList = document.querySelector(".myPage-main");
const pageSize = 10;
const pageItems = <%if (list != null) {%>"<%= list.size() %>"<%}%>;
const pageCount = Math.ceil(pageItems / pageSize);

console.log(arr);
for (i in arr) {
  console.log(arr[i]);
}
console.log(arr[3]);

</script>

</html>
<%}%>