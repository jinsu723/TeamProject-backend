document.addEventListener("DOMContentLoaded", () => {
  // 체크박스 및 버튼 요소 가져오기
  const agreeAllCheckbox = document.querySelector(".signup1-agree-allbox");
  const agreeCheckboxes = document.querySelectorAll(".signup1-agree-checkbox");
  const nextButton = document.querySelector(".signup1-next-button");
  const backButton = document.querySelector(".signup1-back-button");

  // 모달 관련 요소 가져오기
  const modal = document.getElementById("agreement-modal");
  const modalTitle = document.getElementById("modal-title");
  const modalText = document.getElementById("modal-text");
  const modalClose = document.getElementById("modal-close");
  let modalAgree = document.getElementById("modal-agree"); // 재할당 가능하도록

  // 개별 약관 버튼 요소 가져오기
  const agreementButtons = document.querySelectorAll(".signup1-agreement-button");

  // 약관 데이터 매핑 (예시 내용 포함)
  const agreements = {
    1: { 
      title: "계정 약관 동의", 
      text: `본 약관은 회원의 계정 생성 및 관리에 관한 사항을 규정합니다.

• 정확한 정보 제공  
  회원은 계정 생성 시 본인의 실제 정보를 정확하게 제공해야 하며, 부정확하거나 허위 정보를 제공하여 발생하는 모든 문제에 대해 책임을 집니다.

• 계정 관리 및 보안 
  회원은 자신의 계정 및 비밀번호를 안전하게 관리해야 하며, 제3자에게 계정 정보를 공유하거나 제공해서는 안 됩니다. 계정 정보의 부정 사용으로 발생하는 모든 책임은 회원에게 있습니다.

• 계정 이용 제한
  회사는 부정 이용이나 정책 위반이 의심되는 계정에 대해 임시 중지 또는 삭제 등의 조치를 취할 수 있으며, 이에 따른 불이익은 회원이 감수하는 것으로 합니다.

• 기타
  계정과 관련된 세부 사항은 관련 법령 및 회사의 내부 규정에 따릅니다.`,
      checkbox: agreeCheckboxes[0] 
    },
    2: { 
      title: "개인정보 수집 및 이용 약관 동의", 
      text: `본 약관은 회사가 서비스 제공을 위해 수집하는 개인정보의 항목, 이용 목적, 보관 기간 및 제3자 제공 등에 관한 사항을 규정합니다.

• 수집 항목 및 목적
회사는 회원 식별, 서비스 제공, 고객 지원 및 마케팅 등의 목적으로 다음과 같은 개인정보(예: 이름, 이메일, 연락처, 생년월일 등)를 수집합니다.

• 이용 및 보관
 수집된 개인정보는 명시된 목적 이외의 용도로 사용되지 않으며, 회원 탈퇴 시까지 보관됩니다. 단, 관련 법령에 따라 일정 기간 보관이 필요한 경우에는 해당 기간 동안 안전하게 보관됩니다.

• 제3자 제공 및 동의
  회원의 개인정보는 원칙적으로 제3자에게 제공하지 않습니다. 단, 법령에 따른 요청이 있거나 회원의 사전 동의를 받은 경우에 한해 제공될 수 있습니다.

• 회원의 권리
  회원은 언제든지 개인정보의 열람, 수정, 삭제를 요청할 수 있으며, 회사는 이에 대해 지체 없이 조치합니다.`,
      checkbox: agreeCheckboxes[1] 
    },
    3: { 
      title: "시스템 및 서비스 이용 약관 동의", 
      text: `본 약관은 회사가 제공하는 시스템 및 서비스를 이용하는 데 있어 준수해야 할 조건, 서비스 변경 및 중단, 면책 사항 등을 규정합니다.

• 서비스 이용 
  회원은 본 약관 및 관련 법령을 준수하며 서비스를 이용해야 합니다. 불법적이거나 부적절한 사용으로 인해 발생하는 모든 문제에 대해 회원이 책임을 집니다.

• 서비스 변경 및 중단
  회사는 서비스의 유지보수, 업데이트, 기술적 문제 또는 예기치 못한 상황에 따라 사전 통지 없이 서비스를 변경하거나 중단할 수 있으며, 이로 인한 손해에 대해서는 책임을 지지 않습니다.

• 면책 사항
  회사는 회원이 서비스를 이용함으로써 발생하는 직간접적인 손해에 대해 특별한 사정이 없는 한 책임을 지지 않습니다. 단, 회사의 고의 또는 중대한 과실로 인한 경우에는 예외로 합니다.

• 약관 변경
  회사는 관련 법령 및 내부 정책에 따라 본 약관을 변경할 수 있으며, 변경된 약관은 서비스 내 공지를 통해 통지됩니다. 회원은 변경된 약관에 동의한 것으로 간주됩니다.`,
      checkbox: agreeCheckboxes[2] 
    }
  };

  // 디버깅: 페이지 로드 시 요소 확인
  console.log("모달 요소:", modal);
  console.log("약관 버튼들:", agreementButtons);

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

  // "다음" 버튼 활성화/비활성화 토글 함수
  function toggleNextButton() {
    const allChecked = Array.from(agreeCheckboxes).every((cb) => cb.checked);
    if (allChecked) {
      nextButton.classList.add("active");
      nextButton.disabled = false;
    } else {
      nextButton.classList.remove("active");
      nextButton.disabled = true;
    }
    agreeAllCheckbox.checked = allChecked;
  }


  // "뒤로" 버튼 클릭 이벤트 (이전 페이지로 이동)
  backButton.addEventListener("click", (event) => {
    event.preventDefault();
    window.history.back();
  });

  // 개별 약관 버튼 클릭 시 모달 띄우기
  agreementButtons.forEach((button) => {
    button.addEventListener("click", () => {
      const type = parseInt(button.getAttribute("data-type"), 10);
      console.log(`약관 버튼 클릭됨! data-type: ${type}`);

      if (agreements[type]) {
        // 모달에 약관 내용 적용
        modalTitle.innerText = agreements[type].title;
        modalText.innerText = agreements[type].text;
        // 모달 표시: hidden 클래스 제거하고 active 클래스 추가
        modal.classList.remove("hidden");
        modal.classList.add("active");
        console.log("모달 표시됨!");

        // 기존 이벤트 제거 후 다시 추가 (이벤트 중첩 방지)
        modalAgree.replaceWith(modalAgree.cloneNode(true));
        modalAgree = document.getElementById("modal-agree");
        modalAgree.addEventListener("click", () => {
          // 모달 내 동의 버튼 클릭 시 해당 체크박스 선택
          agreements[type].checkbox.checked = true;
          toggleNextButton();
          // 모달 닫기: active 클래스 제거하고 hidden 클래스 추가
          modal.classList.remove("active");
          modal.classList.add("hidden");
          console.log(`모달 닫힘 및 ${type}번 체크박스 선택됨`);
        });
      } else {
        console.log("❌ 오류: agreements[type]이 정의되지 않음");
      }
    });
  });

  // 모달 닫기 버튼 클릭 이벤트
  modalClose.addEventListener("click", () => {
    console.log("모달 닫기 버튼 클릭됨!");
    modal.classList.remove("active");
    modal.classList.add("hidden");
    modalTitle.innerText = "";
    modalText.innerText = "";
  });
});
