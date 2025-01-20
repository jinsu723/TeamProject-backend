const myPagePwBtn = document.querySelector(".myPage-pwBtn");
const myPageTearBtn = document.querySelector(".myPage-tearBtn");
const myPageNickBtn = document.querySelector(".myPage-nickBtn");
const myPagePhoneBtn = document.querySelector(".myPage-phoneBtn");
const myPagePhoneCheck = document.querySelector(".myPage-phoneCheck");
const myPageDelBtn = document.querySelector(".myPage-delBtn");


myPageNickBtn.addEventListener("click", () => {
	let newNick = prompt("변경하실 닉네임을 입력해 주세요");

	if (newNick == "" || newNick == null) {
		console.log("프롬프트 false");
	} else {
		console.log("닉 : " + newNick);
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
	window.location.href = "../login/findPass2.html";
});

myPageTearBtn.addEventListener("click", () => {
	alert("티어 변경이 완료되었습니다");
});

myPagePhoneBtn.addEventListener("click", () => {
	myPagePhoneCheck.style = "display:block"
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