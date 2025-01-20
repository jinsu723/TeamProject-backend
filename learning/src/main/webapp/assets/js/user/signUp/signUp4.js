document.addEventListener("DOMContentLoaded", () => {
  const idInput = document.getElementById("id");
  const passwordInput = document.getElementById("password");
  const confirmPasswordInput = document.getElementById("confirm-password");
  const idError = document.getElementById("id-error");
  const passwordError1 = document.getElementById("password-error1");
  const passwordError2 = document.getElementById("password-error2");
  const nextButton = document.querySelector(".signup4-next-button");

  const existingIds = ["admin", "user1", "guest"]; // 이미 사용 중인 아이디 리스트

  // 아이디 중복 검사
  idInput.addEventListener("input", () => {
    const id = idInput.value.trim();

    if (existingIds.includes(id)) {
      idError.textContent = "이미 사용 중인 아이디입니다.";
      idError.style.display = "block";
    } else {
      idError.textContent = "";
      idError.style.display = "none";
    }

    validateForm();
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
    const isIdValid = idError.textContent === "" && idInput.value.trim() !== "";
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
