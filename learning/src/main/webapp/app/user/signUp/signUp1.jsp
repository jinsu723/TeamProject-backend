<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입 약관 동의</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/user/signUp/signUp1.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/preset/preset.css">
</head>
<body>
	<div class="total-container">
		<div class="signup1-container">
			<header>
				<p>LEARNING</p>
			</header>

			<main>
				<div class="signup1-text1">
					<p>
						환영합니다!<br> 계정을 생성하기 위해<br> 아래 약관을 동의해 주세요.
					</p>
				</div>

				<form action="${pageContext.request.contextPath}/signUp1.us"
					method="post">
					<label>
						<div>
							<input type="checkbox" class="signup1-agree-allbox"> 전체
							동의
						</div>

						<p class="signup1-text2">전체 동의를 하면 선택한 약관들의 동의를 포함해 전체 동의가
							진행됩니다.</p>
					</label>

					<div class="signup1-agreement-options">
						<label class="signup1-Essential-agree">
							<div>
								<input type="checkbox" class="signup1-agree-checkbox">
								[필수] 계정 약관 동의
							</div>
							<button type="button" class="signup1-agreement-button"
								data-type="1">
								<i class="icon-right-open"></i>
							</button>
						</label> <label class="signup1-Essential-agree">
							<div>
								<input type="checkbox" class="signup1-agree-checkbox">
								[필수] 개인정보 수집 및 이용 약관동의
							</div>
							<button type="button" class="signup1-agreement-button"
								data-type="2">
								<i class="icon-right-open"></i>
							</button>
						</label> <label class="signup1-Essential-agree">
							<div>
								<input type="checkbox" class="signup1-agree-checkbox">
								[필수] 시스템 및 서비스 이용 약관 동의
							</div>
							<button type="button" class="signup1-agreement-button"
								data-type="3">
								<i class="icon-right-open"></i>
							</button>
						</label>
					</div>

					<div class="signup1-buttons-container">
						<button type="button" class="signup1-back-button">뒤로</button>
						<button type="submit" class="signup1-next-button">다음</button>
					</div>
				</form>
			</main>
			<!-- 약관 동의 모달 -->
			<div id="agreement-modal" class="modal hidden">
				<div class="modal-content">
					<h2 id="modal-title">약관 제목</h2>
					<p id="modal-text">약관 내용이 여기에 표시됩니다.</p>
					<div class="modal-buttons">
						<button id="modal-close">닫기</button>
						<button id="modal-agree">동의</button>
					</div>
				</div>
			</div>



			<footer class="signUp1-footer">
				<a href="#">이용약관</a> | <a href="#">개인정보 처리 방침</a> | <a href="#">고객센터</a>
			</footer>
		</div>
	</div>

	<script defer
		src="${pageContext.request.contextPath}/assets/js/user/signUp/signUp1.js"></script>
</body>
</html>
