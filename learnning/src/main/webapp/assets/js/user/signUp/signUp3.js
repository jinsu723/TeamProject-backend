document.addEventListener("DOMContentLoaded", () => {
  const nicknameInput = document.getElementById("nickname"); // 닉네임 입력 필드
  const checkButton = document.querySelector(".signup3-certify-button"); // 중복검사 버튼
  const nextButton = document.querySelector(".signup3-next-button"); // 다음 버튼
  const errorMessage = document.getElementById("nickname-error"); // 오류 메시지 표시 요소

  // 중복 확인용 닉네임 리스트 (예시 데이터)
  const existingNicknames = ["admin", "user1", "guest"]; // 이미 존재하는 닉네임

  // "중복검사" 버튼 클릭 이벤트
  checkButton.addEventListener("click", () => {
    const nickname = nicknameInput.value.trim();

    // 닉네임이 비어 있는 경우
    if (nickname === "") {
      errorMessage.textContent = "닉네임을 입력해주세요.";
      errorMessage.style.display = "block";
      errorMessage.style.color = "red";
      nextButton.disabled = true;
      nextButton.classList.remove("active");
      return;
    }

    // 닉네임이 중복된 경우
    if (existingNicknames.includes(nickname)) {
      errorMessage.textContent = "이미 사용 중인 닉네임입니다. 다른 닉네임을 입력해주세요.";
      errorMessage.style.display = "block";
      errorMessage.style.color = "red";
      nextButton.disabled = true;
      nextButton.classList.remove("active");
      return;
    }

    // 닉네임이 사용 가능한 경우
    errorMessage.textContent = "사용 가능한 닉네임입니다.";
    errorMessage.style.display = "block";
    errorMessage.style.color = "green"; // 성공 메시지는 초록색으로 표시
    nextButton.disabled = false;
    nextButton.classList.add("active");
  });

  // 닉네임 입력 이벤트
  nicknameInput.addEventListener("input", () => {
    // 닉네임 입력값이 변경되면 "다음" 버튼 비활성화 및 오류 메시지 숨기기
    nextButton.disabled = true;
    nextButton.classList.remove("active");
    errorMessage.style.display = "none";
  });


});

