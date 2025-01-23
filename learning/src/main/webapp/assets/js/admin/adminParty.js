const forums = forumsList.map(forum => ({
   forumNumber: forum.forumNumber,
   userNickname: forum.userNickname,
   userTier: forum.userTier,
   forumTitle: forum.forumTitle,
   forumCategory: forum.forumCategory,
   forumDate: forum.forumDate
}));

const banSearch = document.querySelector('#manager-ban-user-search');
let banSize = 10; //한 페이지당 표시될 게시물 수
let totalban = 20; //서버에서 모든 게시물 수 가져오기
let currentPageNumber = 1;
const moveFirst = document.querySelector('.icon-angle-double-left');
const moveLast = document.querySelector('.icon-angle-double-right');
const movePrev = document.querySelector('.icon-left-open');
const moveNext = document.querySelector('.icon-right-open');
const resetButtonSearch = document.querySelector('#reset-search-button');

function timeToString(dataString) {
   const resetToTime = dataString.replace(" KST", "");
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
   return `${year}-${month}-${day}`;
}

let totalPages = Math.ceil(forumsList.length / banSize);

const bottomNumber = document.querySelector('.manager-ban-user-page-number-button');
const banContainer = document.querySelector('.manager-ban-user-list');
const banBottomNumberContainer = document.querySelector('.manager-ban-user-page-numbers');

function getban(page) {
   banContainer.innerHTML = '';
   const start = (page - 1) * banSize;
   const end = page * banSize;
   const banDisplay = forumsList.slice(start, end);



   banDisplay.forEach(forum => {
      const banItem = document.createElement('li');
      banItem.classList.add('manager-ban-user-list-item');

      banItem.innerHTML = `
                        <div class="manager-ban-user-list-ban-userId">${forum.forumNumber}</div>
                        <div class="manager-ban-user-list-ban-nickName">${forum.userNickname}</div>
                        <div class="manager-ban-user-list-ban-content">${forum.userTier}</div>
                        <div class="ban-list-date">
                        <div class="manager-ban-user-list-ban-start-date">${forum.forumTitle}</div>
                        <div class="manager-ban-user-list-ban-end-date">${forum.forumCategory}</div>
                        <div class="manager-ban-user-list-ban-date">${timeToString(forum.forumDate)}</div>
                           </div>
                           <button type="submit" class="ban-controll">삭제</button>
                         `;

      const banLine = document.createElement('hr');
      banLine.classList.add('manager-ban-user-list-item-line');
      banContainer.appendChild(banItem);
      banContainer.appendChild(banLine);
      const banControllButton = banItem.querySelector(".ban-controll");

      banControllButton.addEventListener('click', () => {
		console.log(`${forum.forumTitle}`)
         const checkUnBan = confirm(`${forum.forumTitle} 게시글을 삭제하시겠습니까?`);
         if (checkUnBan) {
            const forumNumber = forum.forumNumber;
            const contextPath = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2)); // contextPath 추출
            console.log(forumNumber);

            // AJAX 요청
            fetch(`${contextPath}/deleteForum.ad`, {
               method: "POST",
               headers: { "Content-Type": "application/x-www-form-urlencoded" },
               body: `forumNumber=${encodeURIComponent(forumNumber)}`
            })
            location.reload();

         } else {
            alert('작업이 취소되었습니다');
         }
      });
   });
}

function banBottomNumber() {
   banBottomNumberContainer.innerHTML = '';
   const numberStart = Math.floor((currentPageNumber - 1) / 10) * 10 + 1;
   const numberEnd = Math.min(numberStart + 9, totalPages);

   for (let i = numberStart; i <= numberEnd; i++) {
      const numbers = document.createElement('p');
      numbers.textContent = i;

      if (i === currentPageNumber) {
         numbers.classList.add('manager-ban-user-page-numbers-selector');
      } else {
         numbers.classList.add('manager-ban-user-page-numbers-unSelector');
      }

      numbers.disabled = i === currentPageNumber;
      numbers.addEventListener('click', () => moveban(i));
      banBottomNumberContainer.appendChild(numbers);
   }
}

function moveban(ban) {
   if (ban < 1 || ban > totalPages) return;
   currentPageNumber = ban;
   getban(currentPageNumber);
   banBottomNumber();
}





// 이전 페이지로 이동
movePrev.addEventListener('click', () => moveban(currentPageNumber - 1));

// 다음 페이지로 이동
moveNext.addEventListener('click', () => moveban(currentPageNumber + 1));

// 첫 페이지로 이동
moveFirst.addEventListener('click', () => moveban(1));

// 마지막 페이지로 이동
moveLast.addEventListener('click', () => moveban(totalPages));

getban(currentPageNumber);
banBottomNumber();

resetButtonSearch.addEventListener("click", function() {
   banSearch.value = '';
});


resetButtonSearch.addEventListener("click", function() {
   banSearch.value = '';
});


//const userNickname = document.getElementsByClassName('.manager-ban-user-list-ban-nickName').innerText;