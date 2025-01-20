document.addEventListener("DOMContentLoaded", () => {
  const agreeAllCheckbox = document.querySelector(".signup1-agree-allbox");
  const agreeCheckboxes = document.querySelectorAll(".signup1-agree-checkbox");
  const nextButton = document.querySelector(".signup1-next-button");
  const backButton = document.querySelector(".signup1-back-button");

  // 페이지 로드 시 "다음" 버튼 비활성화
  nextButton.disabled = true;

  // "전체 동의" 체크박스 클릭 이벤트
  agreeAllCheckbox.addEventListener("click", () => {
    const isChecked = agreeAllCheckbox.checked;
    agreeCheckboxes.forEach((checkbox) => {
      checkbox.checked = isChecked;
    });
    toggleNextButton();
  });

  // 개별 체크박스 클릭 이벤트
  agreeCheckboxes.forEach((checkbox) => {
    checkbox.addEventListener("change", () => {
      const allChecked = Array.from(agreeCheckboxes).every((cb) => cb.checked);
      agreeAllCheckbox.checked = allChecked;
      toggleNextButton();
    });
  });

  // "다음" 버튼 활성화/비활성화 토글
  function toggleNextButton() {
    const allChecked = Array.from(agreeCheckboxes).every((cb) => cb.checked);
    nextButton.disabled = !allChecked;
  }

  // "뒤로" 버튼 클릭 이벤트
  backButton.addEventListener("click", (event) => {
    event.preventDefault();
    window.history.back();
  });
});
