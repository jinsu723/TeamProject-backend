const banButton = document.querySelector('.ban-controll');
const userNickname = document.querySelector('.manager-ban-user-list-ban-nickName');

/*console.log(banButton);

banButton.addEventListener('click', () => {
	console.log('밴');
	console.log(userNickname.innerText);
})*/

function banUser(user) {
	const reason = prompt('유저 ' + user + '의 밴 사유');

	if (reason === '') {
		alert('사유 입력 필수');
	} else {
		const period = prompt('해당 유저의 밴 기간');

		const isNumber = /^[0-9]+$/.test(period);

		if (isNumber) {
			alert(user + reason + period);
			const contextPath = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
			fetch(`${contextPath}/adminDoBen.ad`, {
				method: "POST",
				headers: { "Content-Type": "application/json" },
				body: JSON.stringify({
					userNickname: user,
					banReason: reason,
					banPeriod: period,
				})
			})
				.then(() => {
					console.log('밴 성공');
					alert('밴 성공');
					location.reload();
				})
				.catch(error => {
					console.error('에러 발생:', error);
				});
		} else {
			alert('정수만 입력하세요');
		}

	}
}