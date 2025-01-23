// 함수나 기능 정의하기 위해 HTML선택
let hostIndex = location.href.indexOf(location.host) + location.host.length;
let contextPath = location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));
const communityForumDetailTitle = document.querySelector('.communityForumDetail-title-content');                //게시글 제목
const communityForumDetailWriterUserName = document.querySelector('.communityForumDetail-writer-userName');     //게시글 작성자
const communityForumDetailContent = document.querySelector('.communityForumDetail-content-text');               //게시글 내용
const communityForumDetailUploadTime = document.querySelector('.communityForumDetail-writer-uploadTime');       //게시글 시간
const communityForumDetailTypeText = document.querySelector('.communityForumDetail-title-text');                //공략, 자유
const communityForumDetailContentImage = document.querySelector('.communityForumDetail-content-images');        //게시글 사진
const communityForumIndexButton = document.querySelector('.communityForumDetail-communityForum-index-button');  //목록 버튼
const communityForumEditButton = document.querySelector('.communityForumDetail-edit-button');                   //수정 버튼
const communityForumDeleteButton = document.querySelector('.communityForumDetail-delete-button');               //삭제 버튼
const communityForumDetailCommentTextInput = document.querySelector('.communityForumDetail-comment-list-container');//댓글작성하는 요소의 부모 
const CommentInput = communityForumDetailCommentTextInput.querySelector('input');                               //댓글 인풋 특정하기
const commentAddButton = communityForumDetailCommentTextInput.querySelector('button');                          //등록하기 특정하기
const commentList = document.querySelector('.communityForumDetail-comment-list');
const commentDeleteButton = document.querySelector('.communityForumDetail-comment-delete');
const commentContent = document.querySelector(".addComment");

let imageUrl = null;                                                                                            //이미지 경로
let communityForumDetailType = 2;                                                                               //공략, 자유 구분을 위해 숫자
var postBottomNumber = 1;
var userName = '없음';
var commentUserName = '없음';
const loginUser = loginUserName.userName;
const postNumber = postDetailsNumber.postNumber;

function formatDate(dateString) {
	const date = new Date(dateString);
	const year = date.getFullYear();
	const month = String(date.getMonth() + 1).padStart(2, '0');
	const day = String(date.getDate()).padStart(2, '0');
	const hours = String(date.getHours()).padStart(2, '0');
	const minutes = String(date.getMinutes()).padStart(2, '0');
	return `${year}-${month}-${day} ${hours}:${minutes}`;
}

//1. 게시글 정보 불러오기(제목, 내용, 시간, 작성자, 사진 링크 등등)
function getCommunityForumDetailValue() {
	postDetails.forEach(detail => {
		userName = detail.detailUserNickName;
		communityForumDetailTypeText.innerText = `${detail.detailCategory}`
		communityForumDetailTitle.innerText = `${detail.detailTitle}`;
		communityForumDetailWriterUserName.innerText = `${detail.detailUserNickName}`;
		communityForumDetailUploadTime.innerText = `${formatDate(detail.detailDate)}`;
		const postContent = `${detail.detailContent}`;
		const formattedText = postContent.replace(/<br>/g, "\n");
		communityForumDetailContent.innerText = formattedText;
		communityForumDetailContentImage.src = ''; //해당 사진을 데베에서 링크로 할당해주기
		document.title = `${userName}님의 게시글`;
	});
}
getCommunityForumDetailValue();	//게시글 정보 불러오기


function getCommunityForumComment() { //댓글 가져오기
	const detailComments = detailsComment.map(comments => ({	//댓글 리스트 가져오기
		commentNumber: comments.commentNumber,	//댓글 번호
		commentUserNumber: comments.commentUserNumber,	//댓글 유저 번호
		userNickName: comments.commentUserNickName,	//댓글 유저 닉네임
		content: comments.commentContent,	//댓글 내용
		time: comments.commentDate,	//댓글 작성시간
	}));
	// 서버에서 댓글 가져오기
	const commentList = document.querySelector('.communityForumDetail-comment-list'); 		//댓글 리스트
	commentList.innerHTML = '';	//댓글 리스트 초기화

	detailComments.forEach(comment => {	//댓글 리스트 출력
		commentUserName = comment.userNickName;	//댓글 유저 이름
		const commentItem = document.createElement("li");	//댓글 리스트 생성
		commentItem.classList.add("communityForumDetail-comment-list-item");	//댓글 리스트 클래스 추가

		const commentDetails = document.createElement("div");	//댓글 리스트 내용
		commentDetails.classList.add("communityForumDetail-comment-list-details");	//댓글 리스트 내용 클래스 추가

		const userName = document.createElement("p");	//댓글 유저 닉네임
		userName.classList.add("communityForumDetail-comment-list-userName");	//댓글 유저 닉네임 클래스 추가
		userName.textContent = comment.userNickName;	//댓글 유저 닉네임 텍스트 추가
		commentDetails.appendChild(userName);	//댓글 유저 닉네임 추가

		const colon = document.createElement("p");	//콜론
		colon.classList.add("communityForumDetail-comment-list-colon");	//콜론 클래스 추가
		colon.textContent = ":";	//콜론 텍스트 추가
		commentDetails.appendChild(colon);	//콜론 추가

		const content = document.createElement("p");	//댓글 내용
		content.classList.add("communityForumDetail-comment-list-content");	//댓글 내용 클래스 추가
		content.textContent = comment.content;	//댓글 내용 텍스트 추가
		commentDetails.appendChild(content);	//댓글 내용 추가

		/*const time = document.createElement("p");	//댓글 작성시간
		time.classList.add("communityForumDetail-comment-list-time");	//댓글 작성시간 클래스 추가
		time.textContent = `${dataTime}`;	//댓글 작성시간 텍스트 추가
		commentDetails.appendChild(time);*/	//댓글 작성시간 추가

		const deleteButton = document.createElement("button");	//댓글 삭제 버튼
		deleteButton.classList.add("communityForumDetail-comment-delete");	//댓글 삭제 버튼 클래스 추가
		deleteButton.textContent = "삭제";	//댓글 삭제 버튼 텍스트 추가

		if (commentUserName === loginUser) {	//로그인 유저와 댓글 유저가 동일할 때
			deleteButton.style.display = 'block'; // 삭제 버튼 표시
			deleteButton.addEventListener("click", function() {	//삭제 버튼 클릭시
				if (confirm("해당 댓글을 삭제하시겠습니까?")) {	//삭제 확인창
					const form = document.createElement("form");
					form.action = contextPath + "/app/communityForum/communityForumDetailCommentDelete.cf?pk=" + comment.commentNumber;	//댓글 삭제
					form.method = "post";	//통신방식
					const postPutNumber = document.createElement("input");	//댓글 추가
					postPutNumber.type = "hidden";
					postPutNumber.name = "postNumber";
					postPutNumber.value = postNumber;
					form.appendChild(postPutNumber);
					
					document.body.appendChild(form);	//댓글 삭제
					form.submit();	//댓글 삭제
					alert("댓글이 삭제되었습니다.");	//댓글 삭제
					commentItem.remove();	//댓글 삭제
				}
			});
		} else {	//로그인 유저와 댓글 유저가 동일하지 않을 때
			deleteButton.style.display = 'none'; // 삭제 버튼 숨김
		}	//로그인 유저와 댓글 유저가 동일하지 않을 때
		commentDetails.appendChild(deleteButton);	//댓글 삭제 버튼 추가
		commentItem.appendChild(commentDetails);	//댓글 리스트 추가
		const hr = document.createElement("hr");	//구분선
		hr.classList.add("communityForumDetail-comment-line-line");	//구분선 클래스 추가
		commentItem.appendChild(hr);	//구분선 추가
		commentList.appendChild(commentItem);	//댓글 리스트 추가
	});
}

function fetchComments() {	//댓글 가져오기
	fetch(`http://localhost:8888${contextPath}/app/communityForum/communityForumDetail.jsp?postNum=${post.postId}`).then(response => response.json())	//댓글 가져오기
		.then(data => {	//댓글 가져오기
			getCommunityForumComment(data.comments);	//댓글 가져오기
		})
		.catch(error => console.log('댓글을 가져오는데 실패했습니다.'), error); //댓글 가져오기
}

if (userName === loginUser) {	//로그인 유저와 게시글 작성자가 동일할 때
	communityForumEditButton.addEventListener("click", function() {	//게시글 수정
		const form = document.createElement('form');
		form.action = contextPath + "/app/communityForum/communityForumEditMyPost.cf?postNum=" + postDetailsNumber.postNumber;
		form.method = "post";
		document.body.appendChild(form);
		form.submit();
		/*var link = '../../html/communityForum/communityForumEdit.html';	//게시글 수정
		location.href = link;	//게시글 수정
		window.open(link);	//게시글 수정*/
	});
	communityForumDeleteButton.addEventListener("click", () => {	//게시글 삭제
		const form = document.createElement("form");	//게시글 삭제

		if (confirm("해당 게시글을 삭제하시겠습니까?")) {	//삭제 확인창
			const form = document.createElement("form");
			form.action = contextPath + "/app/communityForum/communityForumDetailDelete.cf?pk="+postDetailsNumber.postNumber;	//게시글 삭제
			form.method = "post";	//통신방식

			document.body.appendChild(form);	//게시글 삭제
			form.submit();	//댓글 삭제
			alert("게시글이 삭제되었습니다.");	//게시글 삭제
		}
	});
} else {	//로그인 유저와 게시글 작성자가 동일하지 않을 때
	communityForumEditButton.style.display = 'none';	//게시글 수정 버튼 숨김
	communityForumDeleteButton.style.display = 'none';	//게시글 삭제 버튼 숨김
}

communityForumIndexButton.addEventListener("click", function() {	//목록 버튼 클릭시
	var link = `http://localhost:8888${contextPath}/app/communityForum/communityForum.cf`;	//목록 페이지로 이동
	location.href = link;	//목록 페이지로 이동
	window.open(link);	//목록 페이지로 이동
});
function dataTimeToDatabase(date) {	//날짜 포멧 지정
	const year = date.getFullYear();	//년도
	let month = date.getMonth() + 1;	//월
	month = String(month).padStart(2, '0');	//월 포멧
	let day = date.getDate();	//일
	day = String(day).padStart(2, '0');	//일 포멧
	let hours = date.getHours();	//시간
	hours = String(hours).padStart(2, '0');	//시간 포멧
	let minutes = date.getMinutes();	//분
	minutes = String(minutes).padStart(2, '0');	//분 포멧
	let seconds = date.getSeconds();	//초
	seconds = String(seconds).padStart(2, '0');	//초 포멧
	return `${year}-${month}-${day} ${hours}:${minutes}:${seconds}`;	//날짜 및 시간 포멧
}

commentContent.addEventListener("click", function(event) { //댓글, 빈값과 값이 없을떄 제한
	if (loginStatus.userLoginStatus === true) {	//로그인 유저일 때
		let input = CommentInput.value.trim();	//댓글 내용
		if (input === '') {	//댓글 내용이 없을 때
			alert('댓글을 입력해 주세요.');	//댓글 내용이 없을 때
		} else {	//댓글 내용이 있을 때
			const form = document.createElement("form");	//댓글 추가
			form.action = contextPath + "/app/communityForum/communityForumDetailAdd.cf";	//댓글 추가
			form.method = "post";	//통신방식

			const postPutNumber = document.createElement("input");	//댓글 추가
			postPutNumber.type = "hidden";
			postPutNumber.name = "postNumber";
			postPutNumber.value = postNumber;
			form.appendChild(postPutNumber);

			const commentContext = document.createElement("input");
			commentContext.type = "hidden";
			commentContext.name = "commentText";
			commentContext.value = input;
			form.appendChild(commentContext);

			const commentUser = document.createElement("input");
			commentUser.type = "hidden";
			commentUser.name = "commentUser";
			commentUser.value = loginUser;
			form.appendChild(commentUser);

			document.body.appendChild(form);
			form.submit();
			alert('댓글 등록이 완료 되었습니다');
			CommentInput.value = '';
		}
	} else {
		alert("로그인 후 댓글쓰기가 가능합니다.");
	}

});


// 정의한 함수나 기능 호출하기

getCommunityForumComment();




















