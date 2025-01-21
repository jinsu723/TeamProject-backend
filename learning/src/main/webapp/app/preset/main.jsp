<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>main page</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/preset/preset.css">
<script defer
	src="${pageContext.request.contextPath}/assets/js/preset/mainLogin.js"></script>
</head>

<body class="main-body-container">

	<header class="main-header">
		<nav class="main-header-container">
			<div class="main-header-content">
				<div class="main-header-logo">
					<a href="${pageContext.request.contextPath}/app/preset/main.jsp">learning</a>
				</div>
				<div class="main-header-post-container">
					<a
						href="${pageContext.request.contextPath}/app/partyForum/partyForum.jsp">
						<li>파티 모집</li>
					</a> <a
						href="${pageContext.request.contextPath}/app/communityForum/communityForum.cf">
						<li>커뮤니티</li>
					</a>
				</div>
			</div>
			<c:choose>
				<c:when test="${not empty sessionScope.userDTO}">
					<div class="main-header-dropdown-container">
						<div class="main-header-user-box">
							<i class="icon-down-dir"></i><%=session.getAttribute("userNickname")%><i
								class="icon-user-circle-o"></i>
						</div>
						<div class="main-header-dropdown">
							<a
								href="${pageContext.request.contextPath}/app/myPage/checkPass.jsp">•
								개인 정보 수정</a>
							<hr />
							<a
								href="${pageContext.request.contextPath}/app/myPage/myPageRecruitment.jsp">•
								모집 현황</a>
							<hr />
							<a href="${pageContext.request.contextPath}/myPageMyPost.my">•
								내 게시물</a>
							<hr />
							<a href="${pageContext.request.contextPath}/logoutOk.us">• 로그
								아웃</a>
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

	<main class="main-container">
		<div class="main-title-box">
			<p class="main-title">WELCOME</p>
			<p class="main-title">MY NEWBIE</p>
			<p class="main-sub-title main-one">고인물들은 당신을 기다리고 있습니다</p>
			<p class="main-sub-title">더 나은 뉴비를 위한 동행</p>
		</div>
	</main>
	<footer class="main-footer">
		<div class="main-login-footer-text">
			<span><a href="">이용약관</a></span> | <span><a href="">개인정보
					처리 방침</a></span> | <span><a href="">고객센터</a></span>
		</div>
	</footer>

	<!-- 로그인 메시지 처리(리다이렉트 방식은 세션) -->
	<script>
      document.addEventListener("DOMContentLoaded", () => {
         // JSP에서 세션 속성을 JavaScript 변수로 전달
         const loginMessage = '<%=(String) session.getAttribute("loginMessage") != null ? session.getAttribute("loginMessage") : ""%>';
         
         if (loginMessage) { // loginMessage가 null 또는 빈 문자열("")이 아닌 경우에만 실행
            alert(loginMessage); // 로그인 메시지 출력
            <%session.removeAttribute("loginMessage"); // 메시지를 한 번 사용 후 삭제%>
         }
      });
   </script>
   <!-- 로그아웃 메시지 처리(url 파라미터 방식으로 리다이렉트 방식 가능) -->
<!--    <script>
    document.addEventListener("DOMContentLoaded", () => {
        // URL 파라미터에서 로그아웃 메시지를 읽어옴
        const urlParams = new URLSearchParams(window.location.search);
        const logoutMessage = urlParams.get("logoutMessage");

        // 로그아웃 메시지가 있으면 알림창으로 표시
        if (logoutMessage) {
        	/* alert(logoutMessage); // 로그아웃 메시지 출력 실패*/
        	alert(decodeURIComponent(logoutMessage)); // 로그아웃 메시지 출력
        	
        	// URL 파라미터 제거
            const currentUrl = window.location.href.split('?')[0]; // 파라미터 제거한 URL
            window.history.replaceState({}, document.title, currentUrl);
        }
    });
</script> -->

 <script>
        document.addEventListener("DOMContentLoaded", () => {
        	// URL 파라미터에서 로그아웃 메시지를 읽어옴
            const urlParams = new URLSearchParams(window.location.search);
            const message = urlParams.get("message") || urlParams.get("logoutMessage");

            if (message) {
            	/* alert(logoutMessage); // 로그아웃 메시지 출력 실패*/
                alert(decodeURIComponent(message)); // 메시지 출력
                // URL 파라미터 제거
                window.history.replaceState({}, document.title, window.location.pathname);
            }
        });
    </script>
   

<%--  	 <!-- 로그아웃 메시지 처리(포워드 방식 리퀘스트) -->
	<script>
   document.addEventListener("DOMContentLoaded", () => {
      const logoutMessage = '<%=request.getAttribute("logoutMessage") != null ? request.getAttribute("logoutMessage") : ""%>';
      
      if (logoutMessage) {
         alert(logoutMessage); // 로그아웃 메시지 출력
      }
   });
	</script> --%>
	
	
	<%--    <!-- 로그인 메시지 처리(포워드 방식 리퀘스트) -->
    <script>
        document.addEventListener("DOMContentLoaded", () => {
            const loginMessage = '<%= request.getAttribute("loginMessage") != null ? request.getAttribute("loginMessage") : "" %>';
            
            if (loginMessage) {
                alert(loginMessage); // 로그인 실패 메시지 출력
            }
        });
    </script> --%>

	
<%-- 	<!-- 로그아웃 메시지 처리(리다이렉트 방식 리퀘스트)-->
	<script>
        document.addEventListener("DOMContentLoaded", () => {
            const logoutMessage = '<%=(String) session.getAttribute("logoutMessage") != null ? session.getAttribute("logoutMessage") : ""%>';
            
            if (logoutMessage) {
                alert(logoutMessage); // 메시지 출력
                <%session.removeAttribute("logoutMessage");%> // 메시지 삭제
            }
        });
    </script> --%>

</body>

</html>