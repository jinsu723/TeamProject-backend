// 함수나 기능 정의하기 위해 HTML선택
let hostIndex = location.href.indexOf( location.host ) + location.host.length;
let contextPath = location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
const communityForumDetailTitle = document.querySelector('.communityForumDetail-title-content');                //게시글 제목
const communityForumDetailWriterUserName = document.querySelector('.communityForumDetail-writer-userName');     //게시글 작성자
const communityForumDetailContent = document.querySelector('.communityForumDetail-content-text');               //게시글 내용
const communityForumDetailUploadTime = document.querySelector('.communityForumDetail-writer-uploadTime');       //게시글 시간
const communityForumDetailTypeText = document.querySelector('.communityForumDetail-title-text');                //공략, 자유
let communityForumDetailType = 2;                                                                               //공략, 자유 구분을 위해 숫자
const communityForumDetailContentImage = document.querySelector('.communityForumDetail-content-images');        //게시글 사진
let imageUrl = null;                                                                                            //이미지 경로
const communityForumIndexButton = document.querySelector('.communityForumDetail-communityForum-index-button');  //목록 버튼
const communityForumEditButton = document.querySelector('.communityForumDetail-edit-button');                   //수정 버튼
const communityForumDeleteButton = document.querySelector('.communityForumDetail-delete-button');               //삭제 버튼
const communityForumDetailCommentTextInput = document.querySelector('.communityForumDetail-comment-list-container');//댓글작성하는 요소의 부모 
const CommentInput = communityForumDetailCommentTextInput.querySelector('input');                               //댓글 인풋 특정하기
const commentAddButton = communityForumDetailCommentTextInput.querySelector('button');                          //등록하기 특정하기
const commentList = document.querySelector('.communityForumDetail-comment-list');
const commentDeleteButton = document.querySelector('.communityForumDetail-comment-delete');
var postBottomNumber = 1;
var userName = '없음';
var commentUserName = '없음';
const loginUser = loginUserName.userName;
console.log(`로그인한 유저의 이름: ${loginUser}`);
console.log("보고있는 게시글의 ID값: "+postDetailsNumber.postNumber);


// 함수나 기능 정의하기

//1. 게시글 정보 불러오기(제목, 내용, 시간, 작성자, 사진 링크 등등)
function getCommunityForumDetailValue() {
	postDetails.forEach(detail => {
		const upLoadTime = new Date();
		const DateTimeFormat = new Date(detail.detailData);
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
		userName = detail.detailUserNickName;

		communityForumDetailTitle.innerText = `${detail.detailTitle}`;
		communityForumDetailWriterUserName.innerText = `${detail.detailUserNickName}`;
		communityForumDetailUploadTime.innerText = dataTime;
		communityForumDetailContent.innerText = `${detail.detailContent}`;
		communityForumDetailContentImage.src = 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQoAGhKZZ5fYXELfJZDfeFyou9MgSeUplBp3Q&s'; //해당 사진을 데베에서 링크로 할당해주기
	});

	if (communityForumDetailType === 1) {
		communityForumDetailTypeText.innerText = "공략";
	} else {
		communityForumDetailTypeText.innerText = "자유";
	}
}
getCommunityForumDetailValue();
console.log(`해당 게시글 유저 이름: ${userName}`);

function timeToString(dataString) {
	const resetToTime = dataString.replace(" KST","");
	const upLoadTime = new Date(resetToTime);
	const year = upLoadTime.getFullYear();
	let month = upLoadTime.getMonth() + 1;
	month = String(month).padStart(2, '0');
	let day = upLoadTime.getDate();
	day = String(day).padStart(2, '0');
	let hours = upLoadTime.getHours();
	hours = String(hours).padStart(2, '0');
	let minutes = upLoadTime.getMinutes();
	minutes = String(minutes).padStart(2, '0');
	return `${year}-${month}-${day} ${hours}:${minutes}`;
}


function getCommunityForumComment() {
	const detailComments = detailsComment.map(comments => ({
		userNickName: comments.commentUserNickName,
		content: comments.commentContent,
		time: comments.commentDate
		/*postId: comments.postNumber*/
	}));
	// 서버에서 댓글 가져오기
	const commentList = document.querySelector('.communityForumDetail-comment-list');
	commentList.innerHTML = '';

	detailComments.forEach(comment => {
		commentUserName = comment.userNickName;
		console.log("댓글 작성자: "+commentUserName);
		const dataTime = timeToString(comment.time);
		console.log(dataTime);


		const commentItem = document.createElement("li");
		commentItem.classList.add("communityForumDetail-comment-list-item");

		const commentDetails = document.createElement("div");
		commentDetails.classList.add("communityForumDetail-comment-list-details");

		const userName = document.createElement("p");
		userName.classList.add("communityForumDetail-comment-list-userName");
		userName.textContent = comment.userNickName;
		commentDetails.appendChild(userName);

		const colon = document.createElement("p");
		colon.classList.add("communityForumDetail-comment-list-colon");
		colon.textContent = ":";
		commentDetails.appendChild(colon);

		const content = document.createElement("p");
		content.classList.add("communityForumDetail-comment-list-content");
		content.textContent = comment.content;
		commentDetails.appendChild(content);

		const time = document.createElement("p");
		time.classList.add("communityForumDetail-comment-list-time");
		time.textContent = `${dataTime}`;
		commentDetails.appendChild(time);

		commentItem.appendChild(commentDetails);
		commentList.appendChild(commentItem);
		const hr = document.createElement("hr");
		hr.classList.add("communityForumDetail-comment-line-line");
		commentItem.appendChild(hr);
	});
}

function fetchComments() {
	fetch(`http://localhost:8888${contextPath}/app/communityForum/communityForumDetail.jsp?postNum=${post.postId}`).then(response => response.json())
		.then(data => {
			getCommunityForumComment(data.comments);
		})
		.catch(error => console.log('댓글을 가져오는데 실패했습니다.'), error);
}
//2. 댓글 작성하기(작성자, 내용, 시간, 본인글이면 삭제)

if(userName === loginUser){
	console.log("로그인유저와 게시글 작성자와 동일 계정");
	communityForumEditButton.addEventListener("click", function() {
			var link = '../../html/communityForum/communityForumEdit.html';
			location.href = link;
			window.open(link);
		});
	communityForumDeleteButton.addEventListener("click", function() {
		if (confirm("해당 게시글을 삭제하시겠습니까?")) {
			alert("삭제되었습니다");
			/*const postDetails = `${contextPath}/app/communityForum/communityForum.cf`;*/
			fetch(`http://localhost:8888${contextPath}/app/communityForum/communityForumDetailDelete.cf`)
			.then(response => resonse.json())
			.then
			var link = ``;
			console.log(link);
			location.href = link;
			location.replace(link);
			window.open(link);
		} else {

		}
	});
	
} else {
	console.log("로그인 유저와 게시글 작성자와 다른 계정");
	communityForumEditButton.style.display = 'none';
	communityForumDeleteButton.style.display = 'none';
	/*commentDeleteButton.style.display = 'none';*/
}
if(commentUserName === loginUser) {
	console.log("로그인유저와 댓글 작성자와 동일");
	
	let communityForumCommentDiv = document.createElement("div");
	let communityForumCommentDeleteButton = document.createElement('button');
	communityForumCommentDeleteButton.classList.add("communityForumDetail-comment-delete-"+loginUser);
	communityForumCommentDeleteButton.textContent = "삭제";
	communityForumCommentDiv.appendChild(communityForumCommentDeleteButton);
	communityForumCommentList.appendChild(communityForumCommentDiv);
	commentDeleteButton.style.display = 'block';
} else {
	console.log("로그인유저와 댓글 작성자와 다름");
	
}

/*if(loginUser === )*/

document.querySelector('.communityForumDetail-comment-list').addEventListener('click', function(event) {
	if (event.target.classList.contains('communityForumDetail-comment-delete')) {
		const commentItem = event.target.closest('li');
		if (confirm("해당 댓글을 삭제하시겠습니까?")) {
			alert("삭제되었습니다");
			if (commentItem) {
				commentItem.remove();
			}
		} else {

		}
	}
});

/*if(loginStatus.userLoginStatus === false) {
	communityForumEditButton.style.display = 'none';
	communityForumDeleteButton.style.display = 'none';
} else {
	
}*/
function addCommentList(text) {
		const upLoadTime = new Date();
		const year = upLoadTime.getFullYear();
		let month = upLoadTime.getMonth() + 1;
		month = String(month).padStart(2, '0');
		let day = upLoadTime.getDate();
		day = String(day).padStart(2, '0');
		let hours = upLoadTime.getHours();
		hours = String(hours).padStart(2, '0');
		let minutes = upLoadTime.getMinutes();
		minutes = String(minutes).padStart(2, '0');

		let communityForumCommentList = document.createElement("li");
		let communityForumCommentDiv = document.createElement("div");
		let communityForumCommentUserName = document.createElement('p');
		let communityForumCommentColon = document.createElement('p');
		let communityForumCommentContent = document.createElement('p');
		let communityForumCommentTime = document.createElement('p');
		let communityForumCommentHr = document.createElement('hr');
		let communityForumCommentDeleteButton = document.createElement('button');


		communityForumCommentList.classList.add("communityForumDetail-comment-list-item");
		communityForumCommentDiv.classList.add("communityForumDetail-comment-list-details");

		// 닉네임 DOM
		communityForumCommentUserName.classList.add("communityForumDetail-comment-list-userName");
		communityForumCommentUserName.textContent = '티모 뺨 후려치기';
		communityForumCommentDiv.appendChild(communityForumCommentUserName);
		//콜론 DOM
		communityForumCommentColon.classList.add("communityForumDetail-comment-list-colon");
		communityForumCommentColon.textContent = ":";
		communityForumCommentDiv.appendChild(communityForumCommentColon);
		//내용 DOM
		communityForumCommentContent.classList.add("communityForumDetail-comment-list-content");
		communityForumCommentContent.textContent = text;
		communityForumCommentDiv.appendChild(communityForumCommentContent);
		//날짜 DOM
		communityForumCommentTime.classList.add("communityForumDetail-comment-list-time");
		communityForumCommentTime.textContent = `${year}-${month}-${day} ${hours}:${minutes}`;
		communityForumCommentDiv.appendChild(communityForumCommentTime);
		//삭제 DOM
		communityForumCommentDeleteButton.classList.add("communityForumDetail-comment-delete");
		communityForumCommentDeleteButton.textContent = "삭제";
		communityForumCommentDiv.appendChild(communityForumCommentDeleteButton);
		//구분선 DOM
		communityForumCommentHr.classList.add("communityForumDetail-comment-line-line");
		//리스트에 담기
		communityForumCommentList.appendChild(communityForumCommentDiv);
		communityForumCommentList.appendChild(communityForumCommentHr);
		//댓글 아이템 추가
		commentList.appendChild(communityForumCommentList);
	}



//3. 각 버튼들의 이벤트(목록, 수정, 삭제 등)
communityForumIndexButton.addEventListener("click", function() {
	var link = `http://localhost:8888${contextPath}/app/communityForum/communityForum.cf`;
	location.href = link;
	window.open(link);
});

commentAddButton.addEventListener("click", function() { //댓글, 빈값과 값이 없을떄 제한
	let input = CommentInput.value.trim();
	if (input === '') {
		alert('댓글을 입력해 주세요.');
	} else {
		addCommentList(input);
		alert('댓글 등록이 완료 되었습니다');
		CommentInput.value = '';
	}
});


// 정의한 함수나 기능 호출하기

getCommunityForumComment();