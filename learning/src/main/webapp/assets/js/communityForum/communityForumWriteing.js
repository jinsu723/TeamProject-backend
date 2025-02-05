let hostIndex = location.href.indexOf(location.host) + location.host.length;
let contextPath = location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));
const writingCategoryFree = document.getElementById('free');
const writingCategoryStrategy = document.getElementById('strategy');
/*const writingCategoryCheck = document.querySelector('input[name="writing-category"]');*/
const writingCategorySelect = document.getElementsByName('writing-category');
const writingCategoryType = 0;
const writingPost = document.querySelector('.communityForumWriting-button');
const writingTitle = document.querySelector('#title');
const writingContent = document.querySelector('#communityForumWriting-content-text-content');
const writingText = document.getElementById("communityForumWriting-content-text-content");
let writingSelectFile = document.querySelector('.icon-file-image');


writingPost.addEventListener("click", function(event) {
	const inputTitle = writingTitle.value.trim();
	const inputContent = writingContent.textContent.trim();
	
	
	
	let postContent = writingText.innerHTML;
	let postText = postContent.replace(/<\/?div>/g, "");
	var categotyType = '';
	writingCategorySelect.forEach((node) => {
		if (node.checked) {
			categotyType = node.value;
		}
	});

	if (loginStatus.userLoginStatus === true) {
		if (inputTitle === '' || inputContent === '') {
			alert('제목과 내용을 입력해 주세요.');
		} else {
			console.log("게시글 등록");
			console.log("게시글 작성 및 데이터 전달 시작");
			const form = document.createElement("form");
			form.action = contextPath+"/app/communityForum/communityForumWritingAdd.cf";
			form.method = "post";
			
			const writingCategory = document.createElement("input");
			writingCategory.type = "hidden";
			writingCategory.name = "postCategory";
			writingCategory.value = categotyType;
			form.appendChild(writingCategory);
			
			const postTitle = document.createElement("input");
			postTitle.type = "hidden";
			postTitle.name = "postTitle";
			postTitle.value = writingTitle.value;
			form.appendChild(postTitle);

			const postContent = document.createElement("input");
			postContent.type = "hidden";
			postContent.name = "postContent";
			postContent.value = postText;
			form.appendChild(postContent);
			/*console.log("내용\n" + postText);*/
			
			const userName = document.createElement("input");
			userName.type = "hidden";
			userName.name = "postUserName";
			userName.value = loginUserName.userName;
			form.appendChild(userName);
			
			document.body.appendChild(form);
			form.submit();
			alert('게시글 등록이 완료 되었습니다');
		}
	} else {
		alert("문제가 발생했습니다.");
	}
});


function checkCategory() {
	if (document.querySelector('input[name="writing-category"]:checked')) {
		// 카테고리를 설정
		//서버에 전송
	} else {
		alert("카테고리를 선택해 주세요");
	}
}
function checkInput() {
	const inputTitle = writingTitle.value.trim();
	const inputContent = writingContent.textContent.trim();
	if (inputTitle === '') {
		alert('제목을 입력해 주세요.');
	} else if (inputContent === '') {
		alert('내용을 입력해 주세요.');
	} else {
		//제목과 내용 입력
	}
}

writingSelectFile.addEventListener("click", function() {
	document.querySelector('.communityForumWriting-file-select-button').click();
});

function selectFile() {
	const fileSize = 40 * 1024 * 1024;
	const imageDisplay = new FileReader();
	const img = document.createElement('img');
	const selectFileButton = document.querySelector('.communityForumWriting-file-select-button');
	const selectFileName = document.querySelector('.communityForumWriting-file-select');
	const contentDiv = document.querySelector('#communityForumWriting-content-text-content');
	const replaceImage = contentDiv.querySelector('img');
	if (selectFileButton.files.length > 0) {
		const fileSeletor = selectFileButton.files[0];
		selectFileName.textContent = `${selectFileButton.files[0].name}`;
		if (fileSeletor.size > fileSize) {
			alert("파일의 용량은 40MB를 넘을 수 없습니다");
		} else {
			imageDisplay.onload = function(event) {
				img.src = event.target.result;
				img.style.maxWidth = '235px';
				img.style.maxHeight = '173px';
				img.alt = '이미지 추가 오류';
				contentDiv.appendChild(img);
			};
			imageDisplay.readAsDataURL(fileSeletor);
			if (replaceImage) {
				contentDiv.removeChild(replaceImage);
				selectFileName.textContent = `${selectFileButton.files[0].name}`;
				selectFileButton.value = '';
			}
		}
	} else {
		selectFileName.textContent = '선택된 파일 없음(40MB 이하)';
	}
}
selectFile();