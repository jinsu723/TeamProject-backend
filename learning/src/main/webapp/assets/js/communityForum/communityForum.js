// JS에서 EL의 ContextPath 사용하기
let hostIndex = location.href.indexOf( location.host ) + location.host.length;
let contextPath = location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
console.log("게시글 총 숫자: "+postCount.postNumber);
/*console.log("게시글 포스트 리스트: "+postList);*/

const writeBtn = document.querySelector('.communityForum-write-btn');
const postSearch = document.querySelector('#communityForum-search');
const postSize = 10; //한 페이지당 표시될 게시물 수
const totalPost = 20; //서버에서 모든 게시물 수 가져오기
let currentPageNumber = 1;
const moveFirst = document.querySelector('.icon-angle-double-left');
const moveLast = document.querySelector('.icon-angle-double-right');
const movePrev = document.querySelector('.icon-left-open');
const moveNext = document.querySelector('.icon-right-open');


//날짜 및 시간 포멧 지정(지금은 현재시간 가져오는데 추후 데베에서 가져오기)
const upLoadTime = new Date();


/*for (let i = 1; i <= postCount.postNumber; i++) { //게시글 총합 가져오기(페이지수에 따라 하단 숫자 바뀜)
  posts.push({
    userName: `작성자`,
    category: `카테고리`,
    title: `게시물 제목`,
	time: `게시글 날짜`,
    postId: `게시글 넘버`
  });
}*/
const posts = postList.map(post => ({
	userNickName: post.userNickname,
	title: post.postTitle,
	category: post.postCategory,
	time: post.postData,
	postId: post.postNumber
}));
const totalPages = Math.ceil(posts.length / postSize);
const bottomNumber = document.querySelector('.communityForum-page-number-button');
const postContainer = document.querySelector('.communityForum-list');
const postBottomNumberContainer = document.querySelector('.communityForum-page-numbers');


/*postList.forEach(post => {
    console.log('번호:', post.postNumber);
    console.log('작성자:', post.userNickname);
    console.log('카테고리:', post.postCategory);
    console.log('제목:', post.postTitle);
    console.log('날짜:', post.postData);
});*/
/*      <div class="communityForum-list-write-time">${post.writeTime}</div>*/

function getPost(page) {
  postContainer.innerHTML = '';
  const start = (page - 1) * postSize;
  const end = page * postSize;
  const postDisplay = posts.slice(start, end);
  
  postDisplay.forEach(post => {
	/*console.log(postDisplay.userNickName);*/
	/*console.log("디버그:", post.userNickName);*/
	const DateTimeFormat = new Date(post.time);
	const year = upLoadTime.getFullYear();
	let month = upLoadTime.getMonth() + 1;
	month = String(month).padStart(2, '0');
	let day = upLoadTime.getDate();
	day = String(day).padStart(2, '0');
	let hours = upLoadTime.getHours();
	hours = String(hours).padStart(2, '0');
	let minutes = upLoadTime.getMinutes();
	minutes = String(minutes).padStart(2, '0');
	const dataTime = `${year}-${month}-${day} ${hours}:${minutes}`;
	
    const postItem = document.createElement('li');
    postItem.classList.add('communityForum-list-item');
    postItem.innerHTML = `
      <div class="communityForum-list-writer">${post.userNickName}</div>
      <div class="communityForum-list-category">${post.category}</div>
      <div class="communityForum-list-title">${post.title}</div>
      <div class="communityForum-list-write-time">${dataTime}</div>
    `;
    const postLine = document.createElement('hr');
    postLine.classList.add('communityForum-list-item-line');
    postContainer.appendChild(postItem);
    postContainer.appendChild(postLine);
    postItem.addEventListener('click', () => {
		const postDetails = `${contextPath}/app/communityForum/communityForumDetail.cf?postNum=${post.postId}`;
		console.log(`http://localhost:8888${postDetails}`);
		fetch(`http://localhost:8888${contextPath}/app/communityForum/communityForumDetail.jsp?postNum=${post.postId}`, {
		  method: 'POST',
		  headers: {
		    'Content-Type': 'application/json'
		  },
		  body: JSON.stringify(`${post.postId}`)
		});
		
		location.href = postDetails;
		window.open(postDetails);
		console.log(postDetails);
    });
  });
}

function postBottomNumber(num) {
  postBottomNumberContainer.innerHTML = '';
  const numberStart = Math.floor((currentPageNumber - 1) / 10) * 10 + 1;
  const numberEnd = Math.min(numberStart + 9, totalPages);

  for (let i = numberStart; i <= numberEnd; i++) {
    const numbers = document.createElement('p');
    numbers.textContent = i;

    if (i === currentPageNumber) {
      numbers.classList.add('communityForum-page-numbers-selector');
    } else {
      numbers.classList.add('communityForum-page-numbers-unSelector');
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





// 이전 페이지로 이동
movePrev.addEventListener('click', () => movePost(currentPageNumber - 1));

// 다음 페이지로 이동
moveNext.addEventListener('click', () => movePost(currentPageNumber + 1));

// 첫 페이지로 이동
moveFirst.addEventListener('click', () => movePost(1));

// 마지막 페이지로 이동
moveLast.addEventListener('click', () => movePost(totalPages));




getPost(currentPageNumber);
postBottomNumber();







if(loginStatus.userLoginStatus === false) {
	writeBtn.style.backgroundColor = 'gray';
	writeBtn.addEventListener("click", function () {
		  alert("로그인 후 글쓰기가 가능합니다");
		});
} else {
	writeBtn.addEventListener("click", function () {
	  var link = contextPath+"/app/communityForum/communityForumWriteing.jsp";
	  console.log(link);
	  location.href = link;
	  // location.replace(link);
	  window.open(link);
	});
}


postSearch.addEventListener("keydown", function (event) {
  if (event.key === 'Enter') {
    event.preventDefault(); // 기본 동작(새 줄 추가) 방지
    alert(`${postSearch.value}의 내용을 검색합니다`);
  }
});

/*fetch(`http://localhost:8888/${contextPath}/app/communityForum/communityForumDetail.jsp?postNum=${post.postNumber}``, {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json'  // 요청의 Content-Type을 JSON으로 설정
  },
  body: JSON.stringify(data)  // JavaScript 객체를 JSON 문자열로 변환하여 전송
})
.then(response => response.json())  // 응답을 JSON으로 변환
.then(data => {
  console.log('서버 응답:', data);
})
.catch(error => {
  console.error('오류 발생:', error);
});*/


/*fetch(`http://localhost:8888/${contextPath}/app/communityForum/communityForumDetail.jsp?postNum=${post.postNumber}`, {
				    method: 'POST',
				    headers: {
				        'Content-Type': 'application/json'
				    },
				    body: JSON.stringify(myData)
				})
				.then(response => response.json())
				.then(data => console.log('Success:', data))
				.catch(error => console.error('오류!!!:', error));*/