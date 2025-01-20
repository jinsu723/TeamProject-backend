<%@page import="com.learning.app.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <header class="main-header">
      <nav class="main-header-container">
         <div class="main-header-content">
            <div class="main-header-logo">
               <a href="${pageContext.request.contextPath}/app/preset/main.jsp">learning</a>
            </div>
            <div class="main-header-post-container">
               <a href="${pageContext.request.contextPath}/app/partyForum/partyForum.jsp">
                  <li>파티 모집</li>
               </a> <a href="${pageContext.request.contextPath}/app/communityForum/communityForum.cf">
                  <li>커뮤니티</li>
               </a>
            </div>
         </div>
         <c:choose>
            <c:when test="${not empty sessionScope.userDTO}">
               <div class="main-header-dropdown-container">
                  <div class="main-header-user-box">
                     <i class="icon-down-dir"></i><%= ((UserDTO)session.getAttribute("userDTO")).getUserNickname() %><i class="icon-user-circle-o"></i>
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
                  <li class="main-nlog-header-join"><a href="${pageContext.request.contextPath}/app/user/login/login.jsp">로그인</a></li>
                  <li class="main-nlog-header-join"><a href="${pageContext.request.contextPath}/app/user/signUp/signUp1.jsp">회원가입</a></li>
               </div>
            </c:otherwise>
         </c:choose>

      </nav>
   </header>