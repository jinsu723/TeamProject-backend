// 함수나 기능 정의하기 위해 HTML선택
const partyForumDetailTitle = document.querySelector('.partyForumDetail-title-content');                //게시글 제목
const partyForumDetailWriterUserName = document.querySelector('.partyForumDetail-writer-userName');     //게시글 작성자
const partyForumDetailContent = document.querySelector('.partyForumDetail-content-text');               //게시글 내용
const partyForumDetailUploadTime = document.querySelector('.partyForumDetail-writer-uploadTime');       //게시글 시간
const partyForumDetailTypeText = document.querySelector('.partyForumDetail-title-text');                //유저 티어
const partyForumDetailContentImage = document.querySelector('.partyForumDetail-content-images');        //게시글 사진
let imageUrl = null;                                                                                            //이미지 경로
const partyForumIndexButton = document.querySelector('.partyForumDetail-partyForum-index-button');  //목록 버튼
const partyForumEditButton = document.querySelector('.partyForumDetail-edit-button');                   //수정 버튼
const partyForumDeleteButton = document.querySelector('.partyForumDetail-delete-button');               //삭제 버튼
const partyForumDetailCommentTextInput = document.querySelector('.partyForumDetail-comment-list-container');//댓글작성하는 요소의 부모                          //등록하기 특정하기
const commentList = document.querySelector('.partyForumDetail-comment-list');
const commentDeleteButton = document.querySelector('.partyForumDetail-comment-delete');
const commentAddButton = partyForumDetailCommentTextInput.querySelector('button');  // 댓글 등록 버튼
const CommentInput = partyForumDetailCommentTextInput.querySelector('input');  // 댓글 입력 필드


let forumTitle = "";
let userTier = "";
let userNickname = "";
let forumDate = "";
let forumUpDate = "";
let forumContent = "";
forumDetail.forEach(forumDetail => {
	forumTitle = forumDetail.forumTitle;
	userTier = forumDetail.userTier;
	userNickname = forumDetail.userNickname;
	forumDate = (forumDetail.forumDate).slice(0, -3);
	forumUpDate = (forumDetail.forumUpdate).slice(0, -3);
	forumContent = forumDetail.forumContent;

});
//1. 게시글 정보 불러오기(제목, 내용, 시간, 작성자, 사진 링크 등등)
function getpartyForumDetailValue() {
	partyForumDetailTitle.innerText = forumTitle;
	partyForumDetailTypeText.innerText = userTier;
	partyForumDetailWriterUserName.innerText = userNickname;
	if (forumUpDate != "") {
		partyForumDetailUploadTime.innerText = forumUpDate
	} else {
		partyForumDetailUploadTime.innerText = forumDate
	}
	partyForumDetailContent.innerText = forumContent;


}



//3. 각 버튼들의 이벤트(목록, 수정, 삭제 등)
partyForumEditButton.addEventListener("click", function() {
	if (confirm("해당 게시글을 수정하시겠습니까?")) {
		const editPageLink = contextPath + `/app/partyForum/partyForumEdit.fo?postNum=${postNum}`;
		location.href = editPageLink

	}
});


partyForumDeleteButton.addEventListener("click", function() {
	if (confirm("해당 게시글을 삭제하시겠습니까?")) {
		const deletePageLink = contextPath + `/app/partyForum/partyForumDelete.fo?postNum=${postNum}`;

		// 서버에 삭제 요청 보내기
		fetch(deletePageLink, { method: "POST" })
			.finally(() => {
				
				window.location.href = contextPath + "/app/preset/main.jsp";
			});
	}
});

// 댓글 목록에 댓글 추가하는 함수
commentAddButton.addEventListener("click", function() {
	let input = CommentInput.value.trim(); // 입력된 댓글 내용 가져오기
	if (input === '') {
		alert('댓글을 입력해 주세요.');
	} else {
/*		console.log(`${postNum}`);
		console.log(`${input}`);
		console.log(`${userId}`);*/
		const commentAddLink = contextPath + `/app/partyForum/partyForumCommentAdd.fo?commentContent=${input}&postNum=${postNum}&userId=${userId}`;

		// 댓글을 등록하기 위해 GET 방식으로 서버로 데이터를 전송
		fetch(commentAddLink, { method: 'GET' })
			.finally(() => {
				// 요청 완료 여부와 상관없이 새로고침
				window.location.reload();
			});
	}
});

document.querySelector('.partyForumDetail-comment-list').addEventListener('click', function(event) {
	if (event.target.classList.contains('partyForumDetail-comment-delete')) {
		const commentItem = event.target.closest('li'); // 댓글 요소
		const commentNumber = commentItem.dataset.commentNumber; // 댓글 번호 (commentNumber)

		if (commentNumber && confirm("이 댓글을 삭제하시겠습니까?")) {
			// 서버에 삭제 요청 보내기
			const deleteCommentLink = contextPath + `/app/partyForum/partyForumCommentDelete.fo?commentNumber=${commentNumber}`;

			fetch(deleteCommentLink, { method: "POST" })
				.finally(() => {
					// 요청 완료 여부와 상관없이 새로고침
					window.location.reload();
				});
		}
	}
});




// 정의한 함수나 기능 호출하기
getpartyForumDetailValue();