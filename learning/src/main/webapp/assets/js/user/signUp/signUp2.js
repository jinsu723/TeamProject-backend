document.addEventListener("DOMContentLoaded", () => {
    const phoneNumberInput = document.getElementById("phone-number");
    const certifyCodeInput = document.getElementById("certify-code");
    const sendSMSBtn = document.querySelector(".signup2-certify-button1");
    const certifyCheckButton = document.getElementById("certify-check");
    const certifySection = document.getElementById("signup2-certify-section");
    const verificationStatus = document.createElement("p"); // 인증 상태 메시지 요소 추가
    certifySection.appendChild(verificationStatus);

    // 현재 contextPath 자동 추출
    const contextPath = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
	
	// 전화번호 중복이면 알림창
		if (phone.user === 1) {
			alert('이미 가입된 사용자입니다');
		}
		

    // 전화번호 입력 시 숫자만 입력 가능하도록 설정
    phoneNumberInput.addEventListener("input", (event) => {
        event.target.value = event.target.value.replace(/[^0-9]/g, ""); // 숫자만 입력 가능
    });

    // SMS 인증번호 발송
    sendSMSBtn.addEventListener("click", function () {
        const phoneNumber = phoneNumberInput.value.trim();
        console.log("입력된 전화번호:", phoneNumber); // 확인용 로그 추가

        if (phoneNumber === "") {
            alert("핸드폰 번호를 입력해주세요.");
            return;
        }

        fetch(`${contextPath}/sendSMS.us`, { 
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ phoneNumber: phoneNumber })
        })
        .then(response => {
            console.log("fetch 응답 상태:", response.status);
            return response.json(); // JSON 변환
        })
        .then(data => {
            console.log("서버 응답 데이터:", data);
            if (data.success) {
                alert("인증번호가 발송되었습니다.");
                certifySection.classList.add("signup2-visible"); // 인증번호 입력 필드 보이기
                certifyCodeInput.disabled = false;
                certifyCodeInput.style.backgroundColor = "#fff";
            } else {
                alert("인증번호 발송 실패: " + data.error);
            }
        })
        .catch(error => {
            console.error("SMS 발송 오류:", error);
            alert("인증번호 발송 중 오류가 발생했습니다.");
        });
    });

    // 인증번호 확인
    certifyCheckButton.addEventListener("click", function () {
        const verificationCode = certifyCodeInput.value.trim();
        if (verificationCode === "") {
            verificationStatus.textContent = "인증번호를 입력해주세요.";
            verificationStatus.style.color = "red";
            return;
        }

        fetch(`${contextPath}/verifyCode.us`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ code: verificationCode })
        })
        .then(response => response.json())
        .then(data => {
            console.log("인증번호 확인 응답:", data);
            if (data.success) {
                verificationStatus.textContent = "인증에 성공했습니다.";
                verificationStatus.style.color = "green";
				verificationStatus.style.fontSize = "12px";
                document.querySelector(".signup2-next-button").classList.add("active");
                document.querySelector(".signup2-next-button").disabled = false;
            } else {
                verificationStatus.textContent = "인증번호가 일치하지 않습니다.";
                verificationStatus.style.color = "red";
				verificationStatus.style.fontSize = "12px";
            }
        })
        .catch(error => {
            console.error("인증 확인 오류:", error);
            verificationStatus.textContent = "인증 처리 중 오류가 발생했습니다.";
            verificationStatus.style.color = "red";
			verificationStatus.style.fontSize = "12px";
        });
    });
});
