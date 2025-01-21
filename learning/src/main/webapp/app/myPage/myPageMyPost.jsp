<%@page import="java.util.List"%>
<%@page import="com.learning.app.dto.MyForumDTO"%>
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
  <!-- 헤더 -->
   <jsp:include page="/app/preset/header.jsp" />
   
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
  
  <!-- 푸터 -->
   <jsp:include page="/app/preset/footer.jsp" />
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
const contextPath = '<%= request.getContextPath() %>';
</script>

</html>
<%}%>