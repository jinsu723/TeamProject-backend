document.addEventListener("DOMContentLoaded", function() {
	/*    console.log("확인 postNum:", postNum);
		console.log("userId:", userId);*/
	
		const submitBtn = document.querySelector(".submit-btn");
		const commentList = document.querySelector("#comment-list");
		const applyBtn = document.querySelector(".apply-btn");
		
		if (submitBtn) {
			submitBtn.addEventListener("click", async function() {
				const content = document.querySelector("#content").value.trim();
				if (!content) {
					alert("댓글 내용을 입력해주세요.");
					return;
				}
				if (userId === "") {
					alert("로그인 후 이용해주시기 바랍니다.");
					return;
				}
	
				try {
					const response = await fetch(`${contextPath}/app/communityForum/communityForumCommentAdd.cf`, {
						method: "POST",
						headers: { "Content-Type": "application/json; charset=utf-8" },
						body: JSON.stringify({ postNum, userId, replyContent: content })
					});
					const result = await response.json();
					if (result.status === "success") {
						alert("댓글이 작성되었습니다.");
						document.querySelector("#content").value = "";
						loadReplies();
					} else {
						alert("댓글 작성에 실패했습니다.");
					}
				} catch (error) {
					console.error("댓글 작성 실패:", error);
					alert("댓글 작성 중 오류가 발생했습니다.");
				}
			});
		}
	
		if (commentList) {
			commentList.addEventListener("click", async function(event) {
				if (event.target.classList.contains("comment-delete")) {
					const replyNumber = event.target.dataset.number;
					if (confirm("댓글을 삭제하시겠습니까?")) {
						try {
							const response = await fetch(`${contextPath}/app/communityForum/communityForumCommentDelete.cf?replyNumber=${replyNumber}`, { method: "GET" });
							const result = await response.json();
							if (result.status === "success") {
								alert(result.message);
								loadReplies();
							} else {
								alert("댓글 삭제에 실패했습니다.");
							}
						} catch (error) {
							console.error("댓글 삭제 실패:", error);
							alert("댓글 삭제 중 오류가 발생했습니다.");
						}
					}
				}
			});
		}
	
		async function loadReplies() {
			try {
				const response = await fetch(`${contextPath}/app/communityForum/communityForumCommentList.cf?postNum=${postNum}`);
				if (!response.ok) throw new Error("댓글 목록을 불러오는 데 실패했습니다.");
				const replies = await response.json();
				renderReplies(replies);
			} catch (error) {
				console.error("댓글 목록 불러오기 실패:", error);
				alert("댓글 목록을 불러오는데 실패했습니다.");
			}
		}
	
		function renderReplies(replies) {
			commentList.innerHTML = "";
			if (replies.length === 0) {
				commentList.innerHTML = "<li>댓글이 없습니다.</li>";
				return;
			}
			replies.forEach(reply => {
				const isMyComment = reply.userId == userId;
				const li = document.createElement("li");
				li.innerHTML = `
					<div class="comment-info">
						<span class="writer">${reply.userNickname}</span>
						<span class="date">${reply.commentDate}</span>
					</div>
					<div class="comment-content-wrap">
						<div class="comment-content">${reply.commentContent}</div>
						${isMyComment ? `
							<div class="comment-btn-group">
								<button type="button" class="comment-delete" data-number="${reply.commentNumber}">삭제</button>
							</div>
						` : ""}
					</div>`;
				commentList.appendChild(li);
			});
		}
	
		loadReplies();
	
	});
	