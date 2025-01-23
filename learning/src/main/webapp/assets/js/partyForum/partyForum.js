// 필요한 DOM 요소
const writeBtn = document.querySelector('.partyForum-write-btn');
const postSearch = document.querySelector('#partyForum-search');
const moveFirst = document.querySelector('.icon-angle-double-left');
const moveLast = document.querySelector('.icon-angle-double-right');
const movePrev = document.querySelector('.icon-left-open');
const moveNext = document.querySelector('.icon-right-open');

const postContainer = document.querySelector('.partyForum-list');
const postBottomNumberContainer = document.querySelector('.partyForum-page-numbers');

// 총 게시글을 담을 상수 배열 posts 생성
const posts = [];
forumList.forEach(forum => {
    const postItem = document.createElement('li');
    postItem.classList.add('partyForum-list-item');
	let noSecDate = '';
	console.log(forum.forumDate);
	console.log(forum.forumUpdate);
	if(forum.forumUpdate != ''){
		noSecDate = (forum.forumUpdate).slice(0,-3);
	}else{
		noSecDate = (forum.forumDate).slice(0,-3);
	}
	
    postItem.innerHTML = `
        <div class="partyForum-list-writer">${forum.userNickname}</div>
        <div class="partyForum-list-userSkill">${forum.userTier}</div>
        <div class="partyForum-list-title">${forum.forumTitle}</div>
        <div class="partyForum-list-write-time">${noSecDate}</div>
    `;
    const postLine = document.createElement('hr');
    postLine.classList.add('partyForum-list-item-line');

    posts.push({
		postNum: forum.forumNumber,
        writer: forum.userNickname,
        skill: forum.userTier,
        title: forum.forumTitle,
        date: noSecDate,
        element: postItem,
        line: postLine
    });
});

const postSize = 10; // 한 페이지당 표시할 게시물 수
let currentPageNumber = 1; // 현재 페이지 번호

// 총 페이지 수 계산
function getTotalPages() {
    return Math.ceil(posts.length / postSize);
}

// 특정 페이지의 게시물 가져오기
function getPost(page) {
    postContainer.innerHTML = '';
    let count = 0; // 표시한 게시물 개수 카운트

    // 시작 인덱스와 종료 조건
    for (let i = (page - 1) * postSize; i < posts.length; i++) {
        if (count >= postSize) break;

        const post = posts[i];
        postContainer.appendChild(post.element);
        postContainer.appendChild(post.line);

        count++; // 출력한 게시물 수 증가
    }
	
	posts.forEach(post => {
	    post.element.addEventListener('click', function() {
	        // 클릭된 게시글의 postNum을 가져옴
	        console.log("게시글 클릭됨:", post.title, post.postNum);

	        // 상세 페이지 URL 생성
	        const detailPageLink = contextPath + `/app/partyForum/partyForumDetail.fo?postNum=${(post.postNum)}`;

	        // 페이지 이동
	        location.href = detailPageLink;
	    });
	});
	
}



// 페이지 번호 버튼 표시
function postBottomNumber() {
    postBottomNumberContainer.innerHTML = '';
    const totalPages = getTotalPages();
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

        numbers.addEventListener('click', () => movePost(i));
        postBottomNumberContainer.appendChild(numbers);
    }
}

// 특정 페이지로 이동
function movePost(post) {
    const totalPages = getTotalPages();
    if (post < 1 || post > totalPages) return;
    currentPageNumber = post;
    getPost(currentPageNumber);
    postBottomNumber();
}

// 페이지 이동 이벤트 리스너
movePrev.addEventListener('click', () => movePost(currentPageNumber - 1));
moveNext.addEventListener('click', () => movePost(currentPageNumber + 1));
moveFirst.addEventListener('click', () => movePost(1));
moveLast.addEventListener('click', () => movePost(getTotalPages()));

// 초기 렌더링
getPost(currentPageNumber);
postBottomNumber();

// 검색 이벤트
/*postSearch.addEventListener("keydown", function(event) {
    if (event.key === 'Enter') {
        event.preventDefault();
        alert(`${postSearch.value}의 내용을 검색합니다`);
    }
});
*/