function banCancel(user) {
	const confirmCancel = confirm(user + '의 밴을 해제하시겠습니까?');
	
	console.log(confirmCancel);
	if(!confirmCancel){
		alert('작업 취소');
	} else {
		const contextPath = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
		fetch(`${contextPath}/cancelBen.ad`, {
			method: "POST",
			headers: { "Contect-Type": "application/json" },
			body: JSON.stringify({
				userNickname: user
			})
		})
		.then(() => {
			console.log('취소 성공');
			alert('취소 완료');
			location.reload();
		})
		.catch(error => {
			console.error('에러 발생: ', error);
		});
	}
}