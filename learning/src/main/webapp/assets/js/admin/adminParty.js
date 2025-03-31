// 삭제 버튼 클릭 시 서버에 요청 보내기
function deletePost(forumNumber) {
    if (confirm("정말 삭제하시겠습니까?")) {
        // 서버에 삭제 요청을 보내고, 성공하면 해당 게시글을 DOM에서 제거
        var xhr = new XMLHttpRequest();
        xhr.open("GET", `${contextPath}/deleteForum.ad?forumNumber=${forumNumber}`, true);
        xhr.onload = function () {
            if (xhr.status === 200) {
                // 삭제 성공 후 DOM에서 해당 게시글을 삭제
                var postElement = document.getElementById("post-" + forumNumber);
								var hrElement = document.getElementById("hr-" + forumNumber); // hr 요소를 찾음
                if (postElement) {
                    postElement.remove();
                }
								if (hrElement){
									hrElement.remove();
								}
                alert("게시글이 삭제되었습니다.");
								location.reload(); // 페이지 새로고침
            } else {
                alert("게시글 삭제에 실패했습니다.");
            }
        };
        xhr.send();
    }
}	