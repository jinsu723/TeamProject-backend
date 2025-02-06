<%@page import="com.learning.app.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<header class="main-nonLogin-header">
	<nav>
		<div class="main-nonLogin-nav">
			<div class="main-nonLogin-logo">
				<a href="${pageContext.request.contextPath}/adminMain.ad">learning</a>
			</div>
			<ul class="main-nonLogin-contents main-nonLogin-ul">
				<c:choose>
					<c:when
						test="${pageContext.request.requestURI eq '/learning/app/admin/adminBanUser.jsp'}">
						<div class="mng-users-contentes-drop">
							<div class="mng-users-text">
								<a href="${pageContext.request.contextPath}/ben.ad">밴 회원 관리</a>
								<div id="mng-users-dropText">
									<a href="${pageContext.request.contextPath}/adminUser.ad">회원 관리</a>
								</div>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<div class="mng-users-contentes-drop">
							<div class="mng-users-text">
								<a href="${pageContext.request.contextPath}/adminUser.ad">회원 관리</a>
								<div id="mng-users-dropText">
									<a href="${pageContext.request.contextPath}/ben.ad">밴 회원 관리</a>
								</div>
							</div>
						</div>
					</c:otherwise>
				</c:choose>

				<li id="mng-contents-drop">게시글 관리
					<div class="mng-header-drop">
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