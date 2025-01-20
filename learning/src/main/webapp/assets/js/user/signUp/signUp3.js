/*document.addEventListener("DOMContentLoaded", () => {
  const nicknameInput = document.getElementById("nickname");
  const checkButton = document.querySelector(".signup3-certify-button");
  const errorMessage = document.getElementById("nickname-error");
  const nextButton = document.querySelector(".signup3-next-button");

  // 버튼 클릭 이벤트
  checkButton.addEventListener("click", () => {
    const userNickname = nicknameInput.value.trim();
    const contextPath = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2)); // contextPath 설정

    if (!userNickname) {
      // 닉네임 입력 안 했을 때
      errorMessage.textContent = "닉네임을 입력해주세요.";
      Object.assign(errorMessage.style, {
        display: "block",
        color: "red",
        fontSize: "14px",
        marginTop: "5px",
      });
      return;
    }

    // AJAX 요청
    fetch(`${contextPath}/nicknameCheck.us`, {
      method: "POST",
      headers: { "Content-Type": "application/x-www-form-urlencoded" },
      body: `userNickname=${encodeURIComponent(userNickname)}`,
    })
      .then((response) => response.json())
      .then((data) => {
        if (data.isDuplicate) {
          // 닉네임 중복일 때
          errorMessage.textContent = "이미 사용 중인 닉네임입니다.";
          Object.assign(errorMessage.style, {
            display: "block",
            color: "red",
          });
          nextButton.disabled = true;
          nextButton.classList.remove("active");
        } else {
          // 닉네임 사용 가능할 때
          errorMessage.textContent = "사용 가능한 닉네임입니다.";
          Object.assign(errorMessage.style, {
            display: "block",
            color: "green",
          });
          nextButton.disabled = false;
          nextButton.classList.add("active");
        }
      })
      .catch((error) => {
        // 서버 오류 발생 시
        errorMessage.textContent = "서버 오류가 발생했습니다. 다시 시도해주세요.";
        Object.assign(errorMessage.style, {
          display: "block",
          color: "red",
        });
        console.error("Error:", error);
      });
  });
});*/

document.addEventListener("DOMContentLoaded", () => {
  const nicknameInput = document.getElementById("nickname");
  const checkButton = document.querySelector(".signup3-certify-button");
  const errorMessage = document.getElementById("nickname-error");
  const nextButton = document.querySelector(".signup3-next-button");

  // 닉네임 수정 시 상태 초기화
  nicknameInput.addEventListener("input", () => {
    // 닉네임이 수정되면 버튼과 메시지 초기화
    checkButton.disabled = false;
    checkButton.style.cursor = "pointer";
    nicknameInput.disabled = false;
    nextButton.disabled = true;
    nextButton.classList.remove("active");
    errorMessage.textContent = "";
    errorMessage.style.display = "none";
  });

  checkButton.addEventListener("click", () => {
    const userNickname = nicknameInput.value.trim();
    const contextPath = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2)); // contextPath 추출

    if (!userNickname) {
      errorMessage.textContent = "닉네임을 입력해주세요.";
      Object.assign(errorMessage.style, { display: "block", color: "red" });
      return;
    }

    // AJAX 요청
    fetch(`${contextPath}/nicknameCheck.us`, {
      method: "POST",
      headers: { "Content-Type": "application/x-www-form-urlencoded" },
      body: `userNickname=${encodeURIComponent(userNickname)}`,
    })
      .then((response) => response.json())
      .then((data) => {
        if (data.isDuplicate) {
          // 닉네임 중복일 때
          errorMessage.textContent = "이미 사용 중인 닉네임입니다.";
          Object.assign(errorMessage.style, { display: "block", color: "red" });
          nextButton.disabled = true;
          nextButton.classList.remove("active");
        } else {
          // 닉네임 사용 가능할 때
          errorMessage.textContent = "사용 가능한 닉네임입니다.";
          Object.assign(errorMessage.style, { display: "block", color: "green" });

          // 다음 버튼 활성화
          nextButton.disabled = false;
          nextButton.classList.add("active");
        }
      })
      .catch((error) => {
        errorMessage.textContent = "서버 오류가 발생했습니다. 다시 시도해주세요.";
        Object.assign(errorMessage.style, { display: "block", color: "red" });
        console.error("Error:", error);
      });
  });
});

