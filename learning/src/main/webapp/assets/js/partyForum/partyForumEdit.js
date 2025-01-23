const partyForumEditTitle = document.getElementById('title');
const partyForumEditContent = document.querySelector('.partyForumEdit-content-text-content');
const partyForumEditCancel = document.querySelector('.partyForumEdit-editCancel-button');
const partyForumEditForm = document.querySelector('form');
const hiddenInput = document.getElementById('hiddenForumContent');

let forumTitle = "";
let forumContent = "";
let forumNumber = "";

// Load forum details
forumDetail.forEach(forumDetail => {
    forumNumber = forumDetail.forumNumber;
    forumTitle = forumDetail.forumTitle;
    forumContent = forumDetail.forumContent;
});

// Initialize form with default values
function defaultValue() {
    partyForumEditTitle.value = forumTitle;
    partyForumEditContent.innerText = forumContent;
}

// Cancel button event
partyForumEditCancel.addEventListener("click", function () {
    if (confirm("수정을 취소하시겠습니까?")) {
        const link = contextPath + `/app/partyForum/partyForumDetail.fo?postNum=${forumNumber}`;
        location.href = link;
    }
});

// On form submission
partyForumEditForm.addEventListener('submit', function (event) {
    const content = partyForumEditContent.innerHTML.trim();
    hiddenInput.value = content;
	const postNumInput = document.createElement('input');
	postNumInput.type = 'hidden';
	postNumInput.name = 'postNum';
	postNumInput.value = forumNumber; 
	partyForumEditForm.appendChild(postNumInput);
    if (!partyForumEditTitle.value.trim()) {
        event.preventDefault();
        alert("제목을 입력해 주세요.");
    } else if (!content) {
        event.preventDefault();
        alert("내용을 입력해 주세요.");
    }
});

defaultValue();
