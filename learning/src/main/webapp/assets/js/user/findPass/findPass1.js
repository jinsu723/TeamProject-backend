document.addEventListener("DOMContentLoaded", () => {
  const idInput = document.getElementById("id");
  const idError = document.getElementById("id-error");
  const nextButton = document.querySelector(".findPass1-next-button");

  // 기존에 존재하는 아이디 목록 (예시)
  const existingIds = ["admin", "user1", "guest"];

  // 아이디 유효성 검사 함수
  function validateId() {
    const id = idInput.value.trim();
    
    // 아이디가 공백일 경우
    if (id === "") {
      idError.textContent = "아이디를 입력해 주세요.";
      idError.style.display = "block";
      nextButton.disabled = true;
      nextButton.classList.remove("active");
      return false;
    }

    // 아이디가 기존 목록에 없을 경우
    if (!existingIds.includes(id)) {
      idError.textContent = "해당 아이디는 존재하지 않습니다.";
      idError.style.display = "block";
      nextButton.disabled = true;
      nextButton.classList.remove("active");
      return false;
    }

    // 유효한 아이디인 경우
    idError.textContent = "";
    idError.style.display = "none";
    nextButton.disabled = false;
    nextButton.classList.add("active");
    return true;
  }

  // 아이디 입력 이벤트 리스너
  idInput.addEventListener("input", () => {
    validateId();
  });

  // "다음" 버튼 클릭 이벤트
  nextButton.addEventListener("click", (event) => {
    if (nextButton.disabled) {
      event.preventDefault(); // 버튼이 비활성화 상태일 경우 동작하지 않음
      return;
    }

    alert("다음 단계로 이동합니다.");
    // 실제 이동 코드 추가
    window.location.href = "../../html/login/findPass2.html";

  });
});
