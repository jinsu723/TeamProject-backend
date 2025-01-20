document.addEventListener("DOMContentLoaded", () => {
  const idInput = document.getElementById("id");
  const passwordInput = document.getElementById("password");
  const confirmPasswordInput = document.getElementById("confirm-password");
  const checkButton = document.querySelector(".signup4-certify-button");
  const idError = document.getElementById("id-error");
  const passwordError1 = document.getElementById("password-error1");
  const passwordError2 = document.getElementById("password-error2");
  const nextButton = document.querySelector(".signup4-next-button");

  const contextPath = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2)); // contextPath 추출

  let isIdChecked = false; // 아이디 중복검사 여부 플래그

  // 아이디 중복검사
  checkButton.addEventListener("click", () => {
    const userId = idInput.value.trim();

    if (!userId) {
      idError.textContent = "아이디를 입력해주세요.";
      idError.style.color = "red"; // 오류 메시지는 빨간색
      idError.style.display = "block";
      return;
    }

    // AJAX 요청
    fetch(`${contextPath}/idCheck.us`, {
      method: "POST",
      headers: { "Content-Type": "application/x-www-form-urlencoded" },
      body: `userId=${encodeURIComponent(userId)}`
    })
      .then((response) => response.json())
      .then((data) => {
        if (data.isDuplicate) {
          idError.textContent = "이미 사용 중인 아이디입니다.";
          idError.style.color = "red"; // 중복된 경우 빨간색
          idError.style.display = "block";
          isIdChecked = false; // 중복된 경우 검사 상태 초기화
          validateForm();
        } else {
          idError.textContent = "사용 가능한 아이디입니다.";
          idError.style.color = "green"; // 사용 가능한 경우 초록색
          idError.style.display = "block";
          isIdChecked = true; // 중복검사 완료 상태 설정
          validateForm();
        }
      })
      .catch((error) => {
        idError.textContent = "서버 오류가 발생했습니다. 다시 시도해주세요.";
        idError.style.color = "red"; // 오류 메시지는 빨간색
        idError.style.display = "block";
        console.error("Error:", error);
      });
  });

  // 아이디 입력 필드 변경 시 중복검사 상태 초기화
  idInput.addEventListener("input", () => {
    isIdChecked = false; // 중복검사 상태 초기화
    idError.textContent = ""; // 오류 메시지 초기화
    idError.style.display = "none"; // 메시지 숨김
    validateForm(); // 폼 유효성 재검사
  });

  // 비밀번호 유효성 검사
  passwordInput.addEventListener("input", () => {
    const password = passwordInput.value;
    const passwordRegex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,16}$/;

    if (!passwordRegex.test(password)) {
      passwordError1.textContent = "비밀번호는 8~16자리, 영문, 숫자, 특수문자를 포함해야 합니다.";
      passwordError1.style.display = "block";
    } else {
      passwordError1.textContent = "";
      passwordError1.style.display = "none";
    }

    validateForm();
  });

  // 비밀번호 재입력 확인
  confirmPasswordInput.addEventListener("input", () => {
    const confirmPassword = confirmPasswordInput.value;

    if (confirmPassword !== passwordInput.value) {
      passwordError2.textContent = "비밀번호가 일치하지 않습니다.";
      passwordError2.style.display = "block";
    } else {
      passwordError2.textContent = "";
      passwordError2.style.display = "none";
    }

    validateForm();
  });

  // 폼 유효성 검사
  function validateForm() {
    const isIdValid = idError.textContent === "사용 가능한 아이디입니다." && isIdChecked;
    const isPasswordValid =
      passwordError1.textContent === "" &&
      passwordInput.value !== "" &&
      confirmPasswordInput.value !== "" &&
      passwordError2.textContent === "";

    if (isIdValid && isPasswordValid) {
      nextButton.disabled = false;
      nextButton.classList.add("active");
    } else {
      nextButton.disabled = true;
      nextButton.classList.remove("active");
    }
  }
});
