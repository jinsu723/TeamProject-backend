<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>main page</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/preset/preset.css">
<script defer src="${pageContext.request.contextPath}/assets/js/preset/mainLogin.js"></script>
</head>

<body class="main-body-container">

   <!-- 헤더 -->
   <jsp:include page="/app/preset/header.jsp" />

   <main class="main-container">
      <div class="main-title-box">
         <p class="main-title">WELCOME</p>
         <p class="main-title">MY NEWBIE</p>
         <p class="main-sub-title main-one">고인물들은 당신을 기다리고 있습니다</p>
         <p class="main-sub-title">더 나은 뉴비를 위한 동행</p>
      </div>
   </main>
   <!-- 푸터 -->
   <jsp:include page="/app/preset/footer.jsp" />
   
</body>

</html>