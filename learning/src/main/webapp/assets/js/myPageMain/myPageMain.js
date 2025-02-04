const myPagePwBtn = document.querySelector(".myPage-pwBtn");
const myPageTearBtn = document.querySelector(".myPage-tearBtn");
const myPageNickBtn = document.querySelector(".myPage-nickBtn");
const myPagePhoneText = document.querySelector(".myPage-phoneText");
const myPagePhoneBtn = document.querySelector(".myPage-phoneBtn");
const myPagePhoneCheck = document.querySelector(".myPage-phoneCheck");
const myPagePhoneCheckText = document.querySelector(".myPage-phoneCheckText");
const myPagePhoneCheckBar = document.querySelector(".myPage-phoneCheckbar");
const myPagePhoneCheckBtn = document.querySelector(".myPage-phoneCheckBtn");
const myPageDelBtn = document.querySelector(".myPage-delBtn");


myPageNickBtn.addEventListener("click", () => {
	let newNick = prompt("변경하실 닉네임을 입력해 주세요");

	if (newNick == "" || newNick == null) {
		console.log("프롬프트 false");
	} else {
		const formNick = document.createElement("form");
		const formData = document.createElement("input");
		formNick.action = contextPath + "/changeNickName.my";
		formNick.method = "get";
		formData.name = "newNick"
		formData.value = newNick;
		formNick.appendChild(formData);
		document.body.appendChild(formNick);
		formNick.submit();
	}
});

myPagePwBtn.addEventListener("click", () => {
	window.location.href = contextPath + "/app/user/findPass/findPass1.jsp";
});

myPageTearBtn.addEventListener("click", () => {
	alert("티어를 변경합니다");
});

myPagePhoneBtn.addEventListener("click", () => {
	console.log(myPagePhoneText.value);
	const isPhoneNumber = /^(?=.*\d)[\d]{11}$/;
	if (myPagePhoneText.value != "") {
		if (isPhoneNumber.test(myPagePhoneText.value)) {
			myPagePhoneCheck.style = "display:block";
			const phoneNumber = myPagePhoneText.value;
			fetch(contextPath + "/sendSMS.my", {
				method: "POST",
				headers: { "Content-Type": "application/json" },
				body: JSON.stringify({ phoneNumber: phoneNumber })
			}).then(response => {
				if (!response.ok) throw new Error(`HTTP 오류! 상태 코드: ${response.status}`);
			}).then(() => {
				console.log("발송 성공");
			}).catch(error => {
				console.error("SMS 발송 오류:", error);
				alert("인증번호 발송 중 오류가 발생했습니다.");
			});

		} else {
			alert("11자리 숫자를 입력해 주세요");
			myPagePhoneText.value = "";
			myPagePhoneText.focus();
		}
	} else {
		myPagePhoneText.focus();
	}
});
// 인증번호 확인
myPagePhoneCheckBtn.addEventListener("click", function() {
	const verificationCode = myPagePhoneCheckText.value.trim();
	if (verificationCode === "") {
		verificationStatus.textContent = "인증번호를 입력해주세요.";
		return;
	}

	fetch(contextPath + "/verifyCode.my", {
		method: "POST",
		headers: { "Content-Type": "application/json" },
		body: JSON.stringify({ code: verificationCode })
	}).then(response => {
		if (!response.ok) throw new Error(`HTTP 오류! 상태 코드: ${response.status}`);
		return response.json();
	}).then(data => {
		if (data.success) {
			alert("인증에 성공했습니다");
			console.log(myPagePhoneText.value);
			location.href = contextPath + "/app/myPage/changPhoneNumber.jsp?phone=" + myPagePhoneText.value;
		} else {
			alert("인증번호가 일치하지 않습니다");
		}
	}).catch(error => {
		console.error("인증 확인 오류:", error);
		alert("인증 처리 중 오류가 발생했습니다")
	});
});



myPageDelBtn.addEventListener("click", () => {
	let isDelete = confirm("정말 회원정보를 삭제하시겠습니까?");
	if (isDelete) {
		const form = document.createElement("form");
		form.action = contextPath + "/deleteUser.my";
		form.method = "get";
		document.body.appendChild(form);
		form.submit();
	}
});