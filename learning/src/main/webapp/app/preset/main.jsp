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