const partyForumEditTitle = document.getElementById('title');
const partyForumEditContent = document.querySelector('.partyForumEdit-content-text-content');
let partyForumEditSelectFile = document.querySelector('.icon-file-image');
const partyForumEditCancel = document.querySelector('.partyForumEdit-editCancel-button');
const partyForumEditComplete = document.querySelector('.partyForumEdit-editComplete-button');

function defaultValue() {


  partyForumEditTitle.value = "데베에서 게시글 타이틀 가져오기";
  partyForumEditContent.innerText = "데베에서 게시글 내용 가져오기";



}

partyForumEditSelectFile.addEventListener("click", function () {
  document.querySelector('.partyForumEdit-file-select-button').click();
});

function selectFile() {
  const imageDisplay = new FileReader();
  const img = document.createElement('img');
  const selectFileButton = document.querySelector('.partyForumEdit-file-select-button');
  const selectFileName = document.querySelector('.partyForumEdit-file-select');
  const contentDiv = document.querySelector('.partyForumEdit-content-text-content');
  const replaceImage = contentDiv.querySelector('img');
  if (replaceImage) {
    contentDiv.removeChild(replaceImage);
    selectFileName.textContent = '선택된 파일 없음(40MB 이하)';
    selectFileButton.value = '';
  }


  if (selectFileButton.files.length > 0) {
    const fileSeletor = selectFileButton.files[0];
    selectFileName.textContent = `${selectFileButton.files[0].name}`;
    imageDisplay.onload = function (event) {
      img.src = event.target.result;
      img.style.maxWidth = '235px';
      img.style.maxHeight = '173px';
      img.alt = '이미지 추가 오류';
      contentDiv.appendChild(img);
    };
    imageDisplay.readAsDataURL(fileSeletor);
  } else {
    selectFileName.textContent = '선택된 파일 없음(40MB 이하)';
  }
}
partyForumEditCancel.addEventListener("click", function () {
  var link = '../../html/partyForum/partyForum.html'; //이전 페이지의 값
  location.href = link;
  location.replace(link);
  window.open(link);
});
partyForumEditComplete.addEventListener("click", function () {
  console.log(partyForumEditTitle.value);
  let contentTitle = partyForumEditTitle.value.trim();
  // let contentText = partyForumEditContent.value.trim();
  if (contentTitle === '') {
    alert("제목을 입력해 주세요");
    // } else if (contentText.value == '') {
    // alert("내용을 입력해 주세요");
  } else {
    alert("게시글 수정이 완료 되었습니다.");
    var link = '../../html/partyForum/partyForum.html'; //수정 후 게시글의 링크
    // location.href = link;
    // location.replace(link);
    // window.open(link);
  }

});



defaultValue();
selectFile();
