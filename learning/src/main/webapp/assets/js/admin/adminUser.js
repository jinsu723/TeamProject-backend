/*function banUser(user, ){
	
	const isBen = document.querySelector('.manager-ban-user-ban-status');
	// const isBen = document.getElementsByClassName('manager-ban-user-ban-status');
	
	console.log(user);
	console.log(benStatus);
	
	// 중복검사
	
	
	const contextPath = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
	
}*/
function banUser(e) {
	const userNickname = e.split(",")[0];
	const benStatus = e.split(",")[1];

	console.log(userNickname);
	console.log(benStatus);

	if (benStatus == 1) {
		alert('이미 벤 된 유저입니다');
	} else {
		const reason = prompt('유저 ' + userNickname + '의 밴 사유');


		if (reason === null) {
			alert('작업 취소');
		} else {
			if (reason === '') {
				alert('사유 입력 필수');
			} else {
				const period = prompt('해당 유저의 밴 기간');

				if (period === null) {
					alert('작업 취소');
				} else {

					const isNumber = /^[0-9]+$/.test(period);

					if (isNumber) {
						const contextPath = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
						fetch(`${contextPath}/adminDoBen.ad`, {
							method: "POST",
							headers: { "Content-Type": "application/json" },
							body: JSON.stringify({
								userNickname: userNickname,
								banReason: reason,
								banPeriod: period,

							})
						})
							.then(() => {
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
		}


	}
}







function banUser1(user) {
	const reason = prompt('유저 ' + user + '의 밴 사유');


	if (reason === '') {
		alert('사유 입력 필수');
	} else {
		const period = prompt('해당 유저의 밴 기간');

		const isNumber = /^[0-9]+$/.test(period);

		if (isNumber) {
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
					console.log(checkBen.isBen);
					if (checkBen.isBen === true) {
						alert('이비 밴 된 유저입니디');
					} else {
						alert('밴 성공');
						location.reload();
					}
				})
				.catch(error => {
					console.error('에러 발생:', error);
				});
		} else {
			alert('정수만 입력하세요');
		}

	}
}
/*		if (reason === '') {
			alert('사유 입력 필수');
		} else {
			const period = prompt('해당 유저의 밴 기간');

			const isNumber = /^[0-9]+$/.test(period);

			if (isNumber) {
				const contextPath = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
				fetch(`${contextPath}/adminDoBen.ad`, {
					method: "POST",
					headers: { "Content-Type": "application/json" },
					body: JSON.stringify({
						userNickname: userNickname,
						banReason: reason,
						banPeriod: period,

					})
				})
					.then(() => {
						alert('밴 성공');
						location.reload();

					})
					.catch(error => {
						console.error('에러 발생:', error);
					});
			} else {
				alert('정수만 입력하세요');
			}

		}*/