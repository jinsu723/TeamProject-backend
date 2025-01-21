<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>비밀번호 재설정</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/user/findPass/findPass2.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/preset/preset.css">
</head>

<body>
  <div class="total-container">
    <div class="findPass2-container">
      <header>
        <p>LEARNING</p>
      </header>
      <main>
        <p class="findPass2-text1">새로운 비밀번호를 입력해 주세요.</p>
        <!-- 비밀번호 변경 요청 처리 -->
        <form action="${pageContext.request.contextPath}/findPass2.us" method="post">
          <div class="findPass2-input-container1">
            <input 
              type="password" 
              name="newPw" 
              id="password" 
              placeholder="새로운 비밀번호를 입력해 주세요(8~16 영문+숫자+특수기호)" 
              maxlength="16"
               
              required>
              <!-- pattern="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,16}$" -->
          </div>
          <p id="password-error1" class="findPass2-error-message1"></p>
          
          <div class="findPass2-input-container2">
            <input 
              type="password" 
              id="confirm-password" 
              placeholder="새로운 비밀번호를 다시 입력해 주세요" 
              maxlength="16"
              
              required>
             <!--  pattern="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,16}$"  -->
          </div>
          <p id="password-error2" class="findPass2-error-message2"></p>

          <ul class="findPass2-info-list">
            <li>비밀번호는 8~16자리, 영문, 숫자, 특수기호를 포함해야 합니다.</li>
            <li>안전한 비밀번호를 설정하여 계정을 보호하세요.</li>
          </ul>

          <div class="findPass2-buttons-container">
            <button type="submit" class="findPass2-next-button" disabled>다음</button>
          </div>
        </form>
      </main>
      <footer class="findPass2-footer">
        <a href="#">이용약관</a> | 
        <a href="#">개인정보 처리 방침</a> | 
        <a href="#">고객센터</a>
      </footer>
    </div>
  </div>
  <!--포워드 방식-->
  <script>
    document.addEventListener("DOMContentLoaded", () => {
        // 서버에서 전달된 메시지를 읽음
        const message = '<%= request.getAttribute("message") != null ? request.getAttribute("message") : "" %>';

        if (message) {
            alert(message); // 메시지 출력
        }
    });
</script>

  <script defer src="${pageContext.request.contextPath}/assets/js/user/findPass/findPass2.js"></script>
</body>

</html>
