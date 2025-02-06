<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% if(session.getAttribute("adminDTO")==null){
	response.sendRedirect(request.getContextPath()+"/app/admin/adminLogin.jsp");
}%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>관리자 메인</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminMain.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/preset/adminPreset.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminUser.css">

</head>

<body>
  <!-- <div class="mng-container"> -->

  <jsp:include page="/app/preset/adminHeader.jsp" />
  
  <main class="manager-dashboard-main">
    <div class="manager-monitoring-container">
      <div class="manager-monitoring-title">
        <!-- <h1>관리자님 환영합니다</h1> -->
      </div>
      <div class="manager-monitoring-cart-container">
        <div class="manager-monitoring-post-chart-container">
          <div class="post-chart-line">
            <div class="post-chart-line-text-container">
              <p class="post-chart-line-title">일별 게시글 추이</p>
              <p class="post-chart-line-text">오늘기준 7일동안 일별로 게시글의 추이를 나타냅니다.</p>
            </div>
            <!-- <canvas id="line-chart" width="350" height="150"></canvas> -->
            <canvas id="line-chart" width="1100" height="300"></canvas>
          </div>
        </div>
        <div class="manager-monitoring-users-cart-container">
          <div class="users-tier-doughnut">
            <div class="users-tier-chart-text-container">
              <p>유저별 티어 분포</p>
            </div>
            <canvas id="user-tier-chart" width="200" height="300"></canvas>
          </div>

          <div class="ban-user-doughnut">
            <div class="users-ban-chart-text-container">
              <p>활동 정지 된 회원</p>
              <p>전체 유저중에서 활동이 정지된 유저들이에요!</p>
            </div>
            <canvas id="user-ban-chart" width="200" height="300"></canvas>
          </div>

          <div class="post-category-doughnut">
            <div class="users-ban-chart-text-container">
              <p>게시글 종류</p>
              <!-- <p>전체 유저중에서 활동이 정지된 유저들이에요!</p> -->
            </div>
            <canvas id="post-categoty-chart" width="200" height="300"></canvas>
          </div>
        </div>

        <!-- <div class="users-tier-doughnut">
          <div class="users-tier-chart-text-container">
            <p>게시글 작성 순위</p>
          </div>
          <canvas id="user-tier-chart" width="200" height="300"></canvas>
        </div> -->


      </div>
    </div>
  </main>
  
  <jsp:include page="/app/preset/adminFooter.jsp" />

  <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7"></script>
  <script src="${pageContext.request.contextPath}/assets/js/admin/adminMain.js"></script>
</body>
<script type="text/javascript">
	let postsDataArray = <%=request.getAttribute("postCount")%>;
	let userTierValue = <%=request.getAttribute("tierList")%>;
	let postCategotyValue = <%=request.getAttribute("categoryList")%>;
	
	console.log(postsDataArray);
	console.log(userTierValue);
	console.log(postCategotyValue);
	
	mainChart(postsDataArray);
	subChartTier(userTierValue);
	subChartCategory(postCategotyValue);
</script>
</html>