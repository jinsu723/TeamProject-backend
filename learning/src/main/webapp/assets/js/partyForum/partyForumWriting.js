const writingPost = document.querySelector('.partyForumWriting-button');
const writingTitle = document.querySelector('#title');
const writingContent = document.querySelector('.partyForumWriting-content-text-content');
console.log(typeof writingContent);
let writingSelectFile = document.querySelector('.icon-file-image');


writingPost.addEventListener("click", function () {
	;	
	checkInput();
});

function checkInput() {
	const inputTitle = writingTitle.value.trim();
	const inputContent = writingContent.textContent.trim();
	if (inputTitle === '') {
		alert('제목을 입력해 주세요.');
	} else if (inputContent === '') {
		alert('내용을 입력해 주세요.');
	} else {
		// 서버에 전송
	}
}

writingSelectFile.addEventListener("click", function () {
	document.querySelector('.partyForumWriting-file-select-button').click();
});

function selectFile() {
	const fileSize = 40 * 1204 * 1204;
	const imageDisplay = new FileReader();
	const img = document.createElement('img');
	const selectFileButton = document.querySelector('.partyForumWriting-file-select-button');
	const selectFileName = document.querySelector('.partyForumWriting-file-select');
	const contentDiv = document.querySelector('.partyForumWriting-content-text-content');
	const replaceImage = contentDiv.querySelector('img');
	if (replaceImage) {
		contentDiv.removeChild(replaceImage);
		selectFileName.textContent = '선택된 파일 없음(40MB 이하)';
		selectFileButton.value = '';
	}


	if (selectFileButton.files.length > 0) {
		const fileSeletor = selectFileButton.files[0];
		selectFileName.textContent = `${selectFileButton.files[0].name}`;
		if (fileSeletor.size > fileSize) {
			alert("파일의 용량은 40MB를 넘을 수 없습니다");
		} else {
			imageDisplay.onload = function (event) {
				img.src = event.target.result;
				img.style.maxWidth = '235px';
				img.style.maxHeight = '173px';
				img.alt = '이미지 추가 오류';
				contentDiv.appendChild(img);
			};
			imageDisplay.readAsDataURL(fileSeletor);
		}
	} else {
		selectFileName.textContent = '선택된 파일 없음(40MB 이하)';
	}
}
