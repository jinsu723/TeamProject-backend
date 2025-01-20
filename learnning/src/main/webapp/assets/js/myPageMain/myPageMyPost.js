pageNation(current);

function showPage(current) {
	console.log("페이지 번호 : " + current);
	current = parseInt(current);
	pageNum = ((current - 1) * 10) + 1;
	const pageMain = document.querySelector(".myPage-main");
	pageMain.innerHTML = "";
	for (i = pageNum; i < pageNum + pageSize; i++) {
		if (i > pageItems) {
			current = i;
			break;
		}
		addList(i - 1, arr);
	}
}



function addList(idx, arr) {
	let newContent = document.createElement("div");
	newContent.classList.add("myPage-content");
	newContent.classList.add("myPage-content-list");
	let newData;

	// 닉네임 추가
	newData = document.createElement("span");
	newData.classList.add("nick");
	newData.innerText = arr[idx][0];
	newContent.appendChild(newData);

	// 티어 추가
	newData = document.createElement("span");
	newData.classList.add("tear");
	newData.innerText = arr[idx][1];
	newContent.appendChild(newData);

	// 카타고리 추가
	newData = document.createElement("span");
	newData.classList.add("categori");
	newData.innerText = arr[idx][2];
	newContent.appendChild(newData);

	// 제목 추가
	newData = document.createElement("span");
	newData.classList.add("title");
	newData.innerText = arr[idx][3];
	newContent.appendChild(newData);

	// 댓글 수 추가
	newData = document.createElement("span");
	newData.classList.add("comment");
	newData.innerText = arr[idx][4];
	newContent.appendChild(newData);

	// 작성시간 추가
	newData = document.createElement("span");
	newData.classList.add("date");
	newData.innerText = arr[idx][5];
	newContent.appendChild(newData);

	pageList.appendChild(newContent);
	pageList.appendChild(document.createElement("hr"));
}



// 페이지네이션
function pageNation(current) {
	const pagenation = document.querySelector(".myPage-pageNation-number");

	//페이지 번호 붙이기
	pagenation.innerHTML = '';
	let pageNum;
	for (let i = 0; i < pageSize; i++) {
		//현재 페이지 기준 페이지네이션
		pageNum = Math.floor((current - 1) / pageSize) * pageSize + 1
		if (pageNum + i > pageCount)
			break;
		newSpan = document.createElement("span");
		newSpan.classList.add("myPage-pageNation-li");
		newSpan.textContent = "" + (pageNum + i);
		newSpan.addEventListener('click', getIdx);
		pagenation.appendChild(newSpan);
		console.log();
	}
	showPage(current);
}

//숫자 클릭시 번호 넘기기
function getIdx(e) {
	showPage(e.target.textContent);
}


//화살표 클릭 이벤트
const goPrevBtn = document.querySelector(".fa-chevron-left");//이전 페이지네이션
goPrevBtn.addEventListener('click', () => {
	current = parseInt(current) - 10;
	if (current < 1) {
		current = 1;
	}
	pageNation(current)
});
const goFirstBtn = document.querySelector(".fa-angles-left");//첫번째 페이지네이션
goFirstBtn.addEventListener('click', () => {
	current = 1;
	pageNation(current)
});
const goNextBtn = document.querySelector(".fa-chevron-right");//다음 페이지네이션
goNextBtn.addEventListener('click', () => {
	current = parseInt(current) + 10;
	if (current > pageCount) {
		current = pageCount;
	}
	pageNation(current)
});
const goLastBtn = document.querySelector(".fa-angles-right");//마지막 페이지네이션
goLastBtn.addEventListener('click', () => {
	current = pageCount;
	pageNation(current);
});