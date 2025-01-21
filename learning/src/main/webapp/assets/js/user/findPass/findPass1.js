document.addEventListener("DOMContentLoaded", () => {
  const phoneNumberInput = document.getElementById("phone-number");
  const certifyCodeInput = document.getElementById("certify-code");
  const errorMessage = document.createElement("p"); // 인증번호 오류 메시지를 위한 요소 생성
  errorMessage.className = "error-message"; // 스타일을 위한 클래스 추가
  certifyCodeInput.parentElement.appendChild(errorMessage); // 입력란 아래에 추가

  // 서버에서 전달된 인증 결과 처리
  if (phone.user === 0) { // 인증 실패
    alert("등록되지 않은 전화번호입니다.");
  }

  // 전화번호 포맷팅 함수
  function formatPhoneNumber(value) {
    const sanitizedValue = value.replace(/[^0-9]/g, "");
    if (sanitizedValue.length <= 3) {
      return sanitizedValue;
    } else if (sanitizedValue.length <= 7) {
      return `${sanitizedValue.slice(0, 3)}-${sanitizedValue.slice(3)}`;
    } else {
      return `${sanitizedValue.slice(0, 3)}-${sanitizedValue.slice(3, 7)}-${sanitizedValue.slice(7, 11)}`;
    }
  }

  // 전화번호 입력 이벤트
  phoneNumberInput.addEventListener("input", (event) => {
    const value = event.target.value;
    const formattedValue = formatPhoneNumber(value);
    event.target.value = formattedValue;
  });

  // 인증번호 입력란 숫자만 허용
  certifyCodeInput.addEventListener("input", (event) => {
    const value = event.target.value;
    const sanitizedValue = value.replace(/[^0-9]/g, "");
    event.target.value = sanitizedValue;
  });

  const certifyRequestButton = document.querySelector(".signup2-certify-button1");
  const certifySection = document.getElementById("signup2-certify-section");
  const certifyCheckButton = document.getElementById("certify-check");
  const nextButton = document.querySelector(".signup2-next-button");

  const correctCode = "48484"; // 테스트용 인증번호

  // 인증 요청 버튼 클릭 이벤트
  certifyRequestButton.addEventListener("click", () => {
    if (phoneNumberInput.value.trim() === "") {
      alert("전화번호를 입력해주세요.");
      return;
    }

    alert("인증번호가 발송되었습니다.");
    certifySection.classList.remove("signup2-hidden");
    certifySection.classList.add("signup2-visible");
  });

  // 인증 확인 버튼 클릭 이벤트
  certifyCheckButton.addEventListener("click", () => {
    if (certifyCodeInput.value.trim() === "") {
      errorMessage.textContent = "인증번호를 입력해주세요.";
      errorMessage.style.display = "block";
      return;
    }

    if (certifyCodeInput.value.trim() !== correctCode) {
      errorMessage.textContent = "인증번호를 다시 확인해주세요.";
      errorMessage.style.display = "block";
      return;
    }

    alert("인증이 완료되었습니다.");
    errorMessage.style.display = "none";
    nextButton.disabled = false;
    nextButton.classList.add("active");
  });
});

