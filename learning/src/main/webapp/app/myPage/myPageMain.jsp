<%@page import="com.learning.app.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% if(session.getAttribute("userDTO")==null){
	System.out.println("없음");
	response.sendRedirect(request.getContextPath()+"/app/user/login/login.jsp");
}%>
<% UserDTO dto = (UserDTO) session.getAttribute("userDTO"); %>
<!DOCTYPE html>
<html lang="ko">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>마이페이지</title>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/myPage/myPageMain.css">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/preset/preset.css">
   <script defer src="${pageContext.request.contextPath}/assets/js/myPageMain/myPageMain.js"></script>
   <script defer src="${pageContext.request.contextPath}/assets/js/preset/mainLogin.js"></script>
   
   <style type="text/css">
   	hr{
   		margin: 0px;
   		padding: 0px;
   		width: 100%;
   	}
   </style>
</head>

<body>
   <!-- 헤더 -->
   <jsp:include page="/app/preset/header.jsp" />

   <!-- 메인 -->
   <main class="myPage-main">
      <div class="myPage-Header">
         <h1>마이페이지</h1>
         <br>
         <h3><span style="color: #0048ff;"><% if(session.getAttribute("userDTO")!=null){%><%= dto.getUserNickname() %><%} %></span>님의 개인정보는는 안전하게 지키고 있습니다 !</h3>
         <p>
         <p style="font-size: 16px;color: gray;">사용자의 정보를 수정하거나, 회원 탈퇴 등 사용자의 개인정보를 수정할 수 있는 마이페이지 입니다.<br>
            회원 탈퇴 진행 시 계정에 대한 복구를 진행할 수 없기 때문에 신중하게 선택 해 주세요. <br>
            닉네임에 불건전한 단어가 포함될 시 관리자에 의해 닉네임 재설정 후 활동 정지 당할 수 있습니다.
         </p>
         <br><br>
      </div>

      <div class="myPage-container">
         <!-- 닉네임 -->
         <div class="myPage-container-box">
            <h2>닉네임</h2>
            <div><% if(session.getAttribute("userDTO")!=null){%><%= dto.getUserNickname() %><%} %></div>
               <button class="myPage-nickBtn">닉네임 변경</button>
            
         </div>

         <!-- 비밀번호 -->
         <div class="myPage-container-box">
            <h2>비밀번호</h2>
            <button class="myPage-pwBtn">비밀번호 변경</button>
         </div>

         <!-- 티어 -->
         <div class="myPage-container-box">
            <h2>티어</h2>
            <div class="myPage-box-text">
               티어를 변경합니다. 허위적으로 기재 시 불이익이 있을 수 있습니다.
            </div>
            <form action="${pageContext.request.contextPath}/changeTier.my" method="get">
            <select class="myPage-drop" name="tier">
               <option class="myPage-drop-op" value="언랭">언랭</option>
               <option class="myPage-drop-op" value="아이언">아이언</option>
               <option class="myPage-drop-op" value="브론즈">브론즈</option>
               <option class="myPage-drop-op" value="실버">실버</option>
               <option class="myPage-drop-op" value="골드">골드</option>
               <option class="myPage-drop-op" value="플래티넘">플래티넘</option>
               <option class="myPage-drop-op" value="에메랄드">에메랄드</option>
               <option class="myPage-drop-op" value="다이아몬드">다이아몬드</option>
               <option class="myPage-drop-op" value="마스터">마스터</option>
               <option class="myPage-drop-op" value="그랜드마스터">그랜드마스터</option>
               <option class="myPage-drop-op" value="챌린저">챌린저</option>
            </select>
            <button type="submit" class="myPage-tearBtn">티어 저장</button>
            </form>
         </div>

         <!-- 전화번호 -->
         <div class="myPage-container-box">
            <h2>전화번호</h2>
            <div class="myPage-box-text">
               전화번호를 변경합니다. 새로 입력하는 전화번호로 본인인증이 진행됩니다.
            </div>
            <div>
            	<input type="text" class="myPage-phoneText">
            	<button class="myPage-phoneBtn">인증번호 받기</button>
            </div>
            <div class="myPage-phoneCheck">
               <br>
               <input type="text" class="myPage-phoneCheckText">
               <button class="myPage-phoneCheckBtn">인증번호 확인</button><br>
               <hr class="myPage-phoneCheckbar">
            </div>
         </div>

         <!-- 회원 탈퇴 -->
         <div class="myPage-container-box">
            <h2>회원 탈퇴</h2>
            <div class="myPage-box-text">
               계정을 삭제합니다. 삭제시 복구가 불가능하며 작성했던 게시글, 댓글 등 데이터가 전부 삭제됩니다.<br>
               계정 삭제가 진행되면 회원의 정보가 모두 삭제되며, 약관에 대한 계약이 모두 철회됩니다.
            </div>
            	<button class="myPage-delBtn">회원 탈퇴</button>
         </div>
      </div>
   </main>
   <!-- 푸터 -->
   <jsp:include page="/app/preset/footer.jsp" />

</body>
<script type="text/javascript">
  const selec = document.querySelectorAll(".myPage-drop-op");
  for (let i = 0; i < selec.length; i++) {
   if(selec[i].textContent == "<% if(session.getAttribute("userDTO")!=null){%><%= dto.getUserTier() %><%} %>"){
      selec[i].selected="true";
      break;
    }
  }
  const contextPath = "<%= request.getContextPath() %>";
  let isChangeNickName = "<%= request.getAttribute("nickChanged") %>";
  if(isChangeNickName==="true"){
	  alert("닉네임이 변경되었습니다");
  }else if(isChangeNickName==="false"){
	  alert("변경실패했습니다\n닉네임이 이미 존재합니다");
  }
  isChangeNickName = "";
  <% request.removeAttribute("nickChanged"); %>
</script>
</html>