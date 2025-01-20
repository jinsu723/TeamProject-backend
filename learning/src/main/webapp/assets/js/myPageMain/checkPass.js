document.addEventListener("DOMContentLoaded", () =>{
  const passInput = document.getElementById("password");//비밀번호 입력란
  const passError = document.getElementById("pass-error")//에러 메시지
  const nextButton = document.querySelector(".checkPass-next-button")//다음 버튼

  //비밀번호 입력 이벤트
  passInput.addEventListener("input", ()=>{
    const enteredPass = passInput.value;

    if(enteredPass.length < 8 || enteredPass.length >16){
      passError.textContent = "비밀번호는 8~16자리여야 합니다";
      passError.style.display = "block";//에러메시지 표시
      disableNextButton();//다음 버튼 비활성화
    }else{
      passError.textContent = "";
      passError.style.display= "none";//에러 메시지 숨김
      enableNextButton(); 
    }
  });

  function enableNextButton(){
    nextButton.disabled = false;
    nextButton.classList.add("active");
  }

  function disableNextButton(){
    nextButton.disabled = true;
    nextButton.classList.remove("active");
  }

});