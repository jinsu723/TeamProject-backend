document.addEventListener("DOMContentLoaded", () => {
  const confirmButton = document.getElementById("changePassCom-button");

  confirmButton.addEventListener("click", () => {
    alert("비밀번호 수정이 완료되었습니다. 로그인 화면으로 이동합니다.");
    // 이동할 페이지 URL 추가
    // window.location.href = "login-page.html";
  });
});
