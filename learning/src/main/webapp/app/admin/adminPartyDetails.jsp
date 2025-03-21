<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% if(session.getAttribute("adminDTO")==null){
	response.sendRedirect(request.getContextPath()+"/app/admin/adminLogin.jsp");
}%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/preset/adminPreset.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminPartyDetails.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/deleteFont/fontello.css">
</head>
<title>파티 관리</title>

<body>
  <!-- <div class="mng-container"> -->

  <jsp:include page="/app/preset/adminHeader.jsp" />
  
  <main class="mng-main">
    <div class="mng-main-container">
      <div class="mng-main-container-title">
        <h1 class="mng-main-title">파티 관리</h1>
      </div>

      <div class="mng-options-container">
        <button id="mng-reset-button">초기화</button>
        <div class="mng-options-search">
          <i class="icon-search"></i>
          <input type="text" name="search" id="mng-search" placeholder="내용 검색">
          <i class="icon-down-dir">
            <div class="mng-search-dropDown">
            </div>
          </i>
        </div>
      </div>

      <div class="mng-list-header-container">
        <hr class="mng-list-line">
        <div class="mng-list-main-title">
          <div class="mng-title-list-writeName">
            <p>러닝크루파이팅가보자잇</p>
          </div>
          <div class="mng-title-list-title">
            <p>---뉴비와 함께해주시고 이끌어주실 고인물분들 정성껏 모십니다!!!!!---</p>
          </div>
          <div class="mng-title-list-write-time">
            <p>2025-01-14 18:00</p>
          </div>
        </div>
        <hr class="mng-list-line">
        <div class="mng-list-main">
          <div class="mng-main-list-check">
            <p>선택</p>
          </div>
          <div class="mng-main-list-number">
            <p>신청 번호</p>
          </div>
          <div class="mng-main-list-member">
            <p>신청자 닉네임</p>
          </div>
          <div class="mng-main-list-tier">
            <p>티어</p>
          </div>
          <div class="mng-main-list-write-time">
            <p>처리 결과</p>
          </div>
        </div>
        <hr class="mng-list-line">


        <ul class="mng-list">
          <li class="mng-list-item">
            <!-- <div class="mng-list-writer"><p>키보드워리어</p></div>
            <div class="mng-list-category"><p>공략글</p></div>
            <div class="mng-list-title"><p>1</p></div>
            <div class="mng-list-write-time"><p>2025-1-10 22:55</p></div>
          </li>
          <hr class="mng-list-item-line"> -->
          <!-- (li.mng-list-item>(div.mng-list-writer>p{키보드워리어})(div.mng-list-category>p{공략글})(div.mng-list-title>p{$})(div.mng-list-write-time>p{2025-1-10 22:55}))hr.mng-list-item-line)*45 -->

        </ul>
      </div>
      <div class="mng-box-footer">
        <button class="icon-trash"></button>
        <div id="mng-totalcount">총 모집 게시글 수 : 00개</div>
      </div>
    </div>
    
    <div class="mng-page-number-container">
      <div class="mng-page-number-button">
        <i class="icon-angle-double-left"></i>
        <i class="icon-left-open"></i>
        <div class="mng-page-numbers"></div>
        <i class="icon-right-open"></i>
        <i class="icon-angle-double-right"></i>
      </div>
    </div>
  </main>
  
  <jsp:include page="/app/preset/footer.jsp" />

  <script defer src="${pageContext.request.contextPath}/assets/js/admin/adminPartyDetails.js"></script>
</body>

</html>