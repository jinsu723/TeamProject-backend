// JS에서 EL의 ContextPath 사용하기
let hostIndex = location.href.indexOf(location.host) + location.host.length;  //hostIndex: 21
let contextPath = location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));  //contextPath: /projectName
const writeBtn = document.querySelector('.communityForum-write-btn'); //글쓰기 버튼
const postSearch = document.querySelector('#communityForum-search');  //검색창
const moveFirst = document.querySelector('.icon-angle-double-left');  //첫 페이지로 이동
const moveLast = document.querySelector('.icon-angle-double-right');  //마지막 페이지로 이동
const movePrev = document.querySelector('.icon-left-open'); //이전 페이지로 이동
const moveNext = document.querySelector('.icon-right-open');  //다음 페이지로 이동
const postSize = 10; //한 페이지당 표시될 게시물 수
const totalPost = 20; //서버에서 모든 게시물 수 가져오기
let currentPageNumber = 1; //현재 페이지 번호

/* 로그인 유무에따른 "글쓰기" 버튼 활성/비활성화 지정하기 */
if (loginStatus.userLoginStatus === false) { //로그인 안되어있을 때
	writeBtn.style.backgroundColor = 'gray';  //버튼 비활성화
	writeBtn.addEventListener("click", function() {  //버튼 클릭시
		alert("로그인 후 글쓰기가 가능합니다"); //알림창 띄우기
	});
} else {  //로그인 되어있을 때
	writeBtn.addEventListener("click", function() {  //버튼 클릭시
		var link = `communityForumWriteing.cf`; //글쓰기 페이지로 이동
		location.href = link; //페이지 이동
		window.open(link);  //새창으로 페이지 열기
	});
}

const posts = postList.map(post => ({ //게시글 리스트 가져오기
	userNickName: post.userNickname,  //유저 닉네임
	title: post.postTitle,  //게시글 제목
	category: post.postCategory,  //게시글 카테고리
	time: post.postData,  //게시글 작성시간
	postId: post.postNumber //게시글 번호
}));
//날짜 및 시간 포멧 지정(지금은 현재시간 데베에서 가져오기)
function formatDate(dateString) {
	const date = new Date(dateString); 
	const year = date.getFullYear();
	const month = String(date.getMonth() + 1).padStart(2, '0');
	const day = String(date.getDate()).padStart(2, '0');
	const hours = String(date.getHours()).padStart(2, '0');
	const minutes = String(date.getMinutes()).padStart(2, '0');
	return `${year}-${month}-${day} ${hours}:${minutes}`;
}

const totalPages = Math.ceil(posts.length / postSize);  //전체 페이지 수
const bottomNumber = document.querySelector('.communityForum-page-number-button');  //페이지 번호 버튼
const postContainer = document.querySelector('.communityForum-list'); //게시글 리스트
const postBottomNumberContainer = document.querySelector('.communityForum-page-numbers'); //페이지 번호 컨테이너

function getPost(page) {  //게시글 가져오기
	postContainer.innerHTML = ''; //게시글 리스트 초기화
	const start = (page - 1) * postSize;  //시작 페이지
	const end = page * postSize;  //끝 페이지
	const postDisplay = posts.slice(start, end);  //게시글 리스트 가져오기

	postDisplay.forEach(post => { //게시글 리스트 출력
		const postItem = document.createElement('li');  //게시글 리스트 생성
		postItem.classList.add('communityForum-list-item'); //게시글 리스트 클래스 추가
		//게시글 리스트 내용
		postItem.innerHTML = `  
    <div class="communityForum-list-writer">${post.userNickName}</div>
    <div class="communityForum-list-category">${post.category}</div>
    <div class="communityForum-list-title">${post.title}</div>
    <div class="communityForum-list-write-time">${formatDate(post.time)}</div>
  `;
		const postLine = document.createElement('hr');  //게시글 리스트 구분선 생성
		postLine.classList.add('communityForum-list-item-line');  //게시글 리스트 구분선 클래스 추가
		postContainer.appendChild(postItem);  //게시글 리스트 추가
		postContainer.appendChild(postLine);  //게시글 리스트 구분선 추가
		postItem.addEventListener('click', () => {  //게시글 클릭시
			const postDetails = `${contextPath}/app/communityForum/communityForumDetail.cf?postNum=${post.postId}`; //게시글 상세페이지로 이동을 위한 PK값
			fetch(`http://localhost:8888${contextPath}/app/communityForum/communityForumDetail.jsp?postNum=${post.postId}`, { //게시글 상세페이지로 이동
				method: 'POST', //통신방식
				headers: {  //헤더
					'Content-Type': 'application/json'  //데이터 타입
				},
				body: JSON.stringify(`${post.postId}`)  //데이터
			});

			location.href = postDetails;  //페이지 이동
			/*window.open(postDetails); //새창으로 페이지 열기*/
		});
	});
}


postSearch.addEventListener("keydown", function(event) { //검색창 엔터키 입력시
	if (event.key === 'Enter') {  //엔터키 입력시
		event.preventDefault(); //기본 이벤트 제거
		alert(`${postSearch.value}의 내용을 검색합니다`); //검색창에 입력한 내용 알림창으로 출력
	}
});

function postBottomNumber(num) {  //페이지 번호
	postBottomNumberContainer.innerHTML = ''; //페이지 번호 초기화
	const numberStart = Math.floor((currentPageNumber - 1) / 10) * 10 + 1;  //시작 페이지
	const numberEnd = Math.min(numberStart + 9, totalPages);  //끝 페이지

	for (let i = numberStart; i <= numberEnd; i++) {  //페이지 번호 출력
		const numbers = document.createElement('p');  //페이지 번호 생성
		numbers.textContent = i;  //페이지 번호 내용

		if (i === currentPageNumber) {  //현재 페이지일 때
			numbers.classList.add('communityForum-page-numbers-selector');  //선택된 페이지 번호 클래스 추가
		} else {  //현재 페이지가 아닐 때
			numbers.classList.add('communityForum-page-numbers-unSelector');  //선택되지 않은 페이지 번호 클래스 추가
		}

		numbers.disabled = i === currentPageNumber; //현재 페이지 비활성화
		numbers.addEventListener('click', () => movePost(i)); //페이지 번호 클릭시
		postBottomNumberContainer.appendChild(numbers); //페이지 번호 추가
	}
}
function movePost(post) { //페이지 이동
	if (post < 1 || post > totalPages) return;  //페이지 범위
	currentPageNumber = post; //현재 페이지 번호
	getPost(currentPageNumber); //게시글 가져오기
	postBottomNumber(); //페이지 번호
}

// 이전 페이지로 이동
movePrev.addEventListener('click', () => movePost(currentPageNumber - 1));

// 다음 페이지로 이동
moveNext.addEventListener('click', () => movePost(currentPageNumber + 1));

// 첫 페이지로 이동
moveFirst.addEventListener('click', () => movePost(1));

// 마지막 페이지로 이동
moveLast.addEventListener('click', () => movePost(totalPages));




getPost(currentPageNumber); //게시글 가져오기
postBottomNumber(); //페이지 번호