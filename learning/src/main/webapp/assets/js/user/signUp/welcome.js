document.addEventListener("DOMContentLoaded", () => {
	const confirmButton = document.getElementById("confirm-button");

	confirmButton.addEventListener("click", () => {
		alert("환영합니다! 게임에 대한 정보를 확인하러 가볼까요?");
		window.location.href = contextPath + '/app/preset/main.jsp';

	});
});
