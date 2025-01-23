let hostIndex = location.href.indexOf(location.host) + location.host.length;
let contextPath = location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));
const communityForumEditTitle = document.getElementById('title');
const communityForumEditTitleQuery = document.querySelector('#title');
const communityForumEditContent = document.querySelector('#communityForumEdit-content-text-content');
const communityForumEditContentText = document.getElementById('communityForumEdit-content-text-content');
/*let communityForumEditSelectFile = document.querySelector('.icon-file-image');*/
const communityForumEditCancel = document.querySelector('.communityForumEdit-editCancel-button');
const communityForumEditComplete = document.querySelector('.communityForumEdit-editComplete-button');

const editCategoryFree = document.getElementById('free');
const editCategoryStrategy = document.getElementById('strategy');
const postNumbers = postDetailsValue.detailPostNum;
const postValues = postDetailsValue.map(values => ({
	postNumber: values.detailPostNum,
	postCategory: values.detailCategory,
	postTitle: values.detailTile,
	postContent: values.detailContent,
	postUserName: values.detailUserNickName
}));



function getCategoryType() {
	postDetailsValue.forEach(myPostValue => {
		let categoryType = myPostValue.detailCategory; //서버에서 타입 종류 받아오기
		if (categoryType === "공략") {
			editCategoryStrategy.checked = true;
		} else {
			editCategoryFree.checked = true;
		}
		const postContent = `${myPostValue.detailContent}`;
		const formattedText = postContent.replace(/<br>/g, "\n");
		communityForumEditTitle.value = myPostValue.detailTile;
		communityForumEditContent.innerText = formattedText;
	});
}

/*communityForumEditSelectFile.addEventListener("click", function() {
	document.querySelector('.communityForumEdit-file-select-button').click();
});*/

/*function selectFile() {
	const fileSize = 40 * 1204 * 1204;
	const imageDisplay = new FileReader();
	const img = document.createElement('img');
	const selectFileButton = document.querySelector('.communityForumEdit-file-select-button');
	const selectFileName = document.querySelector('.communityForumEdit-file-select');
	const contentDiv = document.querySelector('#communityForumEdit-content-text-content');
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
}*/

communityForumEditCancel.addEventListener("click", function() {
	postValues.forEach(myPostValue => {
		console.log(myPostValue.postNumber);
		const form = document.createElement('form');
		form.action = contextPath + "/app/communityForum/communityForumDetail.cf?postNum=" + myPostValue.postNumber;
		form.method = "post";
		document.body.appendChild(form);
		form.submit();
	});
	/**/
	/*var link = '../../html/communityForum/communityForum.html'; //이전 페이지의 값
	location.href = link;
	location.replace(link);
	window.open(link);*/
});
communityForumEditComplete.addEventListener("click", function() {
	const selectedCategory = document.querySelector('input[name="edit-category"]:checked');
	const categoryValue = selectedCategory.id === "free" ? "자유" : "공략";
	let contentTitle = communityForumEditTitle.value.trim();
	let contentText = communityForumEditContent.innerText.trim();
	let postContent = communityForumEditContentText.innerHTML;
	let postText = postContent.replace(/<\/?div>/g, "");
	if (contentTitle === '' || contentText === '') {
		alert("제목과 내용을 입력해 주세요");
	} else {
		postValues.forEach(values => {
			const form = document.createElement("form");
			form.action = contextPath + "/app/communityForum/communityForumMyPostEdit.cf";
			form.method = "post";

			const editCategory = document.createElement("input");
			editCategory.type = "hidden";
			editCategory.name = "editCategoryText";
			editCategory.value = categoryValue;
			form.appendChild(editCategory);

			const postNumber = document.createElement("input");
			postNumber.type = "hidden";
			postNumber.name = "postNum";
			postNumber.value = values.postNumber;
			form.appendChild(postNumber);
			console.log(postNumbers);

			const editTitle = document.createElement("input");
			editTitle.type = "hidden";
			editTitle.name = "editTitleText";
			editTitle.value = contentTitle;
			form.appendChild(editTitle);

			const editContent = document.createElement("input");
			editContent.type = "hidden";
			editContent.name = "editContentText";
			editContent.value = postText;
			form.appendChild(editContent);

			const userName = document.createElement("input");
			userName.type = "hidden";
			userName.name = "postUserName";
			userName.value = values.postUserName;
			form.appendChild(userName);

			document.body.appendChild(form);
			form.submit();
			alert("게시글 수정이 완료 되었습니다.");
		});

		/*var link = '../../html/communityForum/communityForum.html';*/ //수정 후 게시글의 링크
		// location.href = link;
		// location.replace(link);
		// window.open(link);
	}

});



getCategoryType();
selectFile();
