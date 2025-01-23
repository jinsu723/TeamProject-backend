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
                        <div class="manager-ban-user-list-ban-text">${forum.userTier}</div>
                        <div class="ban-list-date">
                        <div class="manager-ban-user-list-ban-start-date">${forum.forumTitle}</div>
                        <div class="manager-ban-user-list-ban-end-date">${forum.forumCategory}</div>
                        <div class="manager-ban-user-list-ban-date-count">${timeToString(forum.forumDate)}</div>
                           </div>
                           <button type="submit" class="ban-controll">삭제</button>
                         `;

      const banLine = document.createElement('hr');
      banLine.classList.add('manager-ban-user-list-item-line');
      banContainer.appendChild(banItem);
      banContainer.appendChild(banLine);
      const banControllButton = banItem.querySelector(".ban-controll");

      const userNickname = document.getElementsByClassName('.manager-ban-user-list-ban-nickName').innerText;

      banControllButton.addEventListener('click', () => {
         const checkUnBan = confirm(`${ban.userNickname} 유저를 바로 밴 해제 하시겠습니까?`);
         if (checkUnBan) {
            const userNickname = ban.userNickname;
            const contextPath = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2)); // contextPath 추출
            console.log(userNickname);

            // AJAX 요청
            fetch(`${contextPath}/cancelBen.ad`, {
               method: "POST",
               headers: { "Content-Type": "application/x-www-form-urlencoded" },
               body: `userNickname=${encodeURIComponent(userNickname)}`
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









banSearch.addEventListener("keydown", function(event) {
   if (event.key === 'Enter') {
      event.preventDefault(); // 기본 동작(새 줄 추가) 방지
      alert(`${banSearch.value}의 내용을 검색합니다`);
      let isMatch = false;

      const pageSize = 10;
      let pageItems = 0;
      for (let i in forums) {
         if ((forums[i].userNickname).indexOf(`${banSearch.value}`) >= 0) {
            if (!isMatch) {
               banContainer.innerHTML = "";
            }
            forum = forums[i];

            const banItem = document.createElement('li');
            banItem.classList.add('manager-ban-user-list-item');
            banItem.innerHTML = `
                  <div class="manager-ban-user-list-ban-userId">${forum.forumNumber}</div>
                  <div class="manager-ban-user-list-ban-nickName">${forum.userNickname}</div>
                  <div class="manager-ban-user-list-ban-text">${forum.userTier}</div>
                  <div class="ban-list-date">
                  <div class="manager-ban-user-list-ban-start-date">${forum.forumTitle}</div>
                  <div class="manager-ban-user-list-ban-end-date">${forum.forumCategory}</div>
                  <div class="manager-ban-user-list-ban-date-count">${timeToString(forum.forumDate)}</div>
                     </div>
                     <button type="submit" class="ban-controll">삭제</button>
                   `;


            const banLine = document.createElement('hr');
            banLine.classList.add('manager-ban-user-list-item-line');
            banContainer.appendChild(banItem);
            banContainer.appendChild(banLine);
            const banControllButton = banItem.querySelector(".ban-controll");

            banControllButton.addEventListener('click', () => {
               const checkUnBan = prompt(`${forum.userNickname} 유저를 바로 밴 하시겠습니까?`);
               const checkUnBan2 = prompt(`${forum.userNickname} 일수?`);

               if ((checkUnBan != '' && checkUnBan != null) && (checkUnBan2 != '' && checkUnBan2 != null)) {
                  console.log(checkUnBan);
                  console.log(checkUnBan2);

                  const form = document.createElement("form");
                  form.method = 'post';
                  form.action = '/learning/adminParty.ad';

                  form.innerHTML = "<input name=reason value='" + checkUnBan + "'>" + "<input name=day value='" + checkUnBan2 + "'>";

                  document.body.appendChild(form);
                  form.submit();
               }

            });
            isMatch = true;
         }

      }
      if (isMatch == false) {
         alert("검색 내역이 없습니다");
      }
   }
});

resetButtonSearch.addEventListener("click", function() {
   banSearch.value = '';
});


//const userNickname = document.getElementsByClassName('.manager-ban-user-list-ban-nickName').innerText;