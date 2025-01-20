document.addEventListener("DOMContentLoaded", () => {
  const tierSelect = document.getElementById("tier-select");
  const completeButton = document.querySelector(".signup5-complete-button");

  // 드롭다운 선택 시 "완료" 버튼 활성화
  tierSelect.addEventListener("change", () => {
    if (tierSelect.value) {
      completeButton.disabled = false;
      completeButton.classList.add("active");
    } else {
      completeButton.disabled = true;
      completeButton.classList.remove("active");
    }
  });


});