const myPagePwBtn = document.querySelector(".myPage-pwBtn");
const myPageTearBtn = document.querySelector(".myPage-tearBtn");
const myPageNickBtn = document.querySelector(".myPage-nickBtn");
const myPagePhoneBtn = document.querySelector(".myPage-phoneBtn");
const myPagePhoneCheck = document.querySelector(".myPage-phoneCheck");
const myPageDelBtn = document.querySelector(".myPage-delBtn");



myPageNickBtn.addEventListener("click", () => {
	let newNick = prompt("변경하실 닉네임을 입력해 주세요");
	console.log(newNick+1);
	if (newNick == "" || newNick == null) {
		console.log(false);
	}else{
		
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
	let isTure = confirm("정말 회원정보를 삭제하시겠습니까?");
});