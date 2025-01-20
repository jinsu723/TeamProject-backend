const myPagePhoneBtn = document.querySelector(".myPage-phoneBtn");
const myPageDelBtn = document.querySelector(".myPage-delBtn");
const myPagePwBtn = document.querySelector(".myPage-pwBtn");
const myPageTearBtn = document.querySelector(".myPage-tearBtn");
const myPagePhoneCheck = document.querySelector(".myPage-phoneCheck");



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