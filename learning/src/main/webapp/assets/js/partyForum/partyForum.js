let hostIndex = location.href.indexOf(location.host) + location.host.length;
let contextPath = location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));
console.log("게시글 총 숫자: " + forumCount.forumNumber);

const writeBtn = document.querySelector('.partyForum-write-btn');
const postSearch = document.querySelector('#partyForum-search');
const postSize = 10; // 한 페이지당 표시될 게시물 수
const totalPost = 20; // 서버에서 받은 총 게시물 수
let currentPageNumber = 1;

const moveFirst = document.querySelector('.icon-angle-double-left');
const moveLast = document.querySelector('.icon-angle-double-right');
const movePrev = document.querySelector('.icon-left-open');
const moveNext = document.querySelector('.icon-right-open');

const posts = [];
for (let i = 1; i <= forumCount.forumNumber; i++) {
	posts.push({
		
		
	})

}

forumList.forEach(forum => {
    console.log('번호:', forum.userNickname);
    console.log('작성자:', forum.forumTitle);
    console.log('카테고리:', forum.forumDate);
});


const totalPages = Math.ceil(posts.length / postSize);

const bottomNumber = document.querySelector('.partyForum-page-number-button');
const postContainer = document.querySelector('.partyForum-list');
const postBottomNumberContainer = document.querySelector('.partyForum-page-numbers');

function getPost(page) {
	postContainer.innerHTML = '';
	const start = (page - 1) * postSize;
	const end = page * postSize;
	const postDisplay = posts.slice(start, end);
	forumList.forEach(forum => {

		const postItem = document.createElement('li');
		postItem.classList.add('partyForum-list-item');
		postItem.innerHTML = `
		<div class="partyForum-list-writer">${forum.userNickname}</div>
		<div class="partyForum-list-userSkill">언랭이요</div>
		<div class="partyForum-list-title">${forum.forumTitle}</div>
		<div class="partyForum-list-write-time">${forum.forumDate}</div>
	`;
		const postLine = document.createElement('hr');
		postLine.classList.add('partyForum-list-item-line');
		postContainer.appendChild(postItem);
		postContainer.appendChild(postLine);
	});
}

function postBottomNumber() {
	postBottomNumberContainer.innerHTML = '';
	const numberStart = Math.floor((currentPageNumber - 1) / 10) * 10 + 1;
	const numberEnd = Math.min(numberStart + 9, totalPages);

	for (let i = numberStart; i <= numberEnd; i++) {
		const numbers = document.createElement('p');
		numbers.textContent = i;

		if (i === currentPageNumber) {
			numbers.classList.add('partyForum-page-numbers-selector');
		} else {
			numbers.classList.add('partyForum-page-numbers-unSelector');
		}

		numbers.disabled = i === currentPageNumber;
		numbers.addEventListener('click', () => movePost(i));
		postBottomNumberContainer.appendChild(numbers);
	}
}

function movePost(post) {
	if (post < 1 || post > totalPages) return;
	currentPageNumber = post;
	getPost(currentPageNumber);
	postBottomNumber();
}

// 페이지네이션 처리
movePrev.addEventListener('click', () => movePost(currentPageNumber - 1));
moveNext.addEventListener('click', () => movePost(currentPageNumber + 1));
moveFirst.addEventListener('click', () => movePost(1));
moveLast.addEventListener('click', () => movePost(totalPages));

// 페이지와 페이지 번호 업데이트
getPost(currentPageNumber);
postBottomNumber();

writeBtn.addEventListener("click", function() {
	var link = '${pageContext.request.contextPath}/app/partyForum/partyForumWriting.jsp';
	location.href = link;
	// location.replace(link);
	window.open('${pageContext.request.contextPath}/app/partyForum/partyForumWriting.jsp');
});

postSearch.addEventListener("keydown", function(event) {
	if (event.key === 'Enter') {
		event.preventDefault(); // 기본 동작(새 줄 추가) 방지
		alert(`${postSearch.value}의 내용을 검색합니다`);
	}
});
