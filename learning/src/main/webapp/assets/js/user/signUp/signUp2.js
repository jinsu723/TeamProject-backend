document.addEventListener("DOMContentLoaded", () => {
	const phoneNumberInput = document.getElementById("phone-number");
	const certifyCodeInput = document.getElementById("certify-code");
	const errorMessage = document.createElement("p"); // 인증번호 오류 메시지를 위한 요소 생성
	errorMessage.className = "error-message"; // 스타일을 위한 클래스 추가
	certifyCodeInput.parentElement.appendChild(errorMessage); // 입력란 아래에 추가

	console.log("안녕");
	console.log(phone.user);

	// 전화번호 중복이면 알림창
	if (phone.user === 1) {
		alert('이미 가입된 사용자입니다');
	}

	// 전화번호 포맷팅 함수
	function formatPhoneNumber(value) {
		// 숫자만 추출
		const sanitizedValue = value.replace(/[^0-9]/g, "");

		// 포맷팅 처리: 010-XXXX-XXXX 형식
		if (sanitizedValue.length <= 3) {
			return sanitizedValue; // 앞자리 3자리까지만 반환
		} else if (sanitizedValue.length <= 7) {
			return `${sanitizedValue.slice(0, 3)}-${sanitizedValue.slice(3)}`; // 010-XXXX
		} else {
			return `${sanitizedValue.slice(0, 3)}-${sanitizedValue.slice(3, 7)}-${sanitizedValue.slice(7, 11)}`; // 010-XXXX-XXXX
		}
	}

	// 전화번호 입력 이벤트
	phoneNumberInput.addEventListener("input", (event) => {
		const value = event.target.value;
		const formattedValue = formatPhoneNumber(value);
		event.target.value = formattedValue; // 포맷된 값으로 설정
	});

	// 인증번호 입력란 숫자만 허용
	certifyCodeInput.addEventListener("input", (event) => {
		const value = event.target.value;
		const sanitizedValue = value.replace(/[^0-9]/g, ""); // 숫자만 남기기
		event.target.value = sanitizedValue;
	});

	const certifyRequestButton = document.querySelector(".signup2-certify-button1");
	const certifySection = document.getElementById("signup2-certify-section");
	const certifyCheckButton = document.getElementById("certify-check");
	const nextButton = document.querySelector(".signup2-next-button");

	// 인증번호 설정
	const correctCode = "48484"; // 테스트용 인증번호

	// "인증 요청" 버튼 클릭 이벤트
	certifyRequestButton.addEventListener("click", () => {
		if (phoneNumberInput.value.trim() === "") {
			alert("전화번호를 입력해주세요.");
			return;
		}

		alert(`인증번호가 발송되었습니다.`); // 인증번호 표시
		certifySection.classList.remove("signup2-hidden");
		certifySection.classList.add("signup2-visible");
		// 전화번호 입력 필드를 읽기 전용으로 설정
		phoneNumberInput.readOnly = true; // 수정 불가 상태로 설정 (데이터는 전송됨)
	});

	// "인증 확인" 버튼 클릭 이벤트
	certifyCheckButton.addEventListener("click", () => {
		if (certifyCodeInput.value.trim() === "") {
			errorMessage.textContent = "인증번호를 입력해주세요."; // 오류 메시지 표시
			errorMessage.style.display = "block"; // 메시지를 보이도록 설정
			return;
		}

		if (certifyCodeInput.value.trim() !== correctCode) {
			errorMessage.textContent = "인증번호를 다시 확인해주세요."; // 오류 메시지 표시
			errorMessage.style.display = "block"; // 메시지를 보이도록 설정
			return;
		}

		// 인증번호가 올바를 경우
		alert("인증이 완료되었습니다.");
		errorMessage.style.display = "none"; // 오류 메시지를 숨김
		nextButton.disabled = false; // "다음" 버튼 활성화
		nextButton.classList.add("active"); // 활성화 클래스 추가
	});


});
