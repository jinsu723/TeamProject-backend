document.addEventListener("DOMContentLoaded", function() {
	let fileInput = document.querySelector('#file');
	let fileList = document.querySelector('.file-list');
	let cntElement = document.querySelector('.cnt');

	// 기존 이미지 삭제 기능
	if (typeof fileOriginalName !== "undefined" && fileOriginalName !== "") {
		cntElement.textContent = 1;
		document.querySelector(".img-cancel-btn")?.addEventListener("click", function() {
			let fileName = `${fileOriginalName}`;
			let confirmDelete = confirm("정말로 이 이미지를 삭제하시겠습니까?");
			console.log("삭제완료");
			console.log(fileName);
			if (confirmDelete) {
				fileList.innerHTML = '';
				cntElement.textContent = 0;
			}
		});
	}

	// 새 파일 추가 및 미리보기
	fileInput?.addEventListener("change", function() {
		let files = fileInput.files;

		// 기존 미리보기 초기화
		fileList.innerHTML = '';

		// 파일 개수 제한 (1개)
		if (files.length > 1) {
			alert("파일은 최대 1개까지만 첨부 가능합니다.");
			fileInput.value = "";
			cntElement.textContent = 0;
			return;
		}

		for (let i = 0; i < files.length; i++) {
			let src = URL.createObjectURL(files[i]);
			fileList.innerHTML = `<li>
                <div class="show-img-box">
                    <img src="${src}">
                </div>
                <div class="btn-box">
                    <button type='button' class='img-cancel-btn' data-name='${files[i].name}'>삭제</button>
                </div>
            </li>`;
		}

		cntElement.textContent = files.length;

		// 삭제 버튼 처리
		document.querySelector(".img-cancel-btn")?.addEventListener("click", function() {
			let fileName = this.dataset.name;
			let dt = new DataTransfer();

			for (let i = 0; i < fileInput.files.length; i++) {
				if (fileInput.files[i].name !== fileName) {
					dt.items.add(fileInput.files[i]);
				}
			}

			fileInput.files = dt.files;
			this.closest("li").remove();
			cntElement.textContent = fileInput.files.length;
		});
	});

	// 취소 버튼 처리
	document.querySelector(".cancel-btn")?.addEventListener("click", function() {
		let boardNumber = document.querySelector("#boardNumber").value;
		window.location.href = `/board/read?boardNumber=${boardNumber}`;
	});

	// 폼 제출 시 확인창
	document.querySelector("#update-form")?.addEventListener("submit", function(e) {
		let confirmSubmit = confirm("게시글을 수정하시겠습니까?");
		if (!confirmSubmit) {
			e.preventDefault();
		}
	});
});
