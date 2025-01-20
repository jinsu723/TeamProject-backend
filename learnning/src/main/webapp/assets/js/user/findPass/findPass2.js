document.addEventListener("DOMContentLoaded", () => {
  const passwordInput = document.getElementById("password");
  const confirmPasswordInput = document.getElementById("confirm-password");
  const passwordError1 = document.getElementById("password-error1");
  const passwordError2 = document.getElementById("password-error2");
  const nextButton = document.querySelector(".findPass2-next-button");

  // 비밀번호 유효성 검사
  passwordInput.addEventListener("input", () => {
    const password = passwordInput.value;
    const passwordRegex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,16}$/;

    if (!passwordRegex.test(password)) {
      passwordError1.textContent = "비밀번호는 8~16자리, 영문, 숫자, 특수문자를 포함해야 합니다.";
      passwordError1.style.display = "block";
      disableNextButton();
    } else {
      passwordError1.textContent = "";
      passwordError1.style.display = "none";
      validateForm();
    }
  });

  // 비밀번호 확인 일치 여부 검사
  confirmPasswordInput.addEventListener("input", () => {
    const confirmPassword = confirmPasswordInput.value;

    if (confirmPassword !== passwordInput.value) {
      passwordError2.textContent = "비밀번호가 일치하지 않습니다.";
      passwordError2.style.display = "block";
      disableNextButton();
    } else {
      passwordError2.textContent = "";
      passwordError2.style.display = "none";
      validateForm();
    }
  });

  // 폼 전체 유효성 검사
  function validateForm() {
    if (
      passwordError1.textContent === "" &&
      passwordError2.textContent === "" &&
      passwordInput.value !== "" &&
      confirmPasswordInput.value !== ""
    ) {
      enableNextButton();
    } else {
      disableNextButton();
    }
  }

  // "다음" 버튼 활성화
  function enableNextButton() {
    nextButton.disabled = false;
    nextButton.classList.add("active");
  }

  // "다음" 버튼 비활성화
  function disableNextButton() {
    nextButton.disabled = true;
    nextButton.classList.remove("active");
  }

  // "다음" 버튼 클릭 이벤트
  nextButton.addEventListener("click", (event) => {
    if (nextButton.disabled) {
      event.preventDefault();
      return;
    }

    alert("새로운 비밀번호가 설정되었습니다!");
    // 실제 이동 코드 추가
    // window.location.href = "next-page.html";
  });
});
