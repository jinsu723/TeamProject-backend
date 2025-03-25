document.addEventListener("DOMContentLoaded", function () {
    let fileInput = document.querySelector('#file');
    let fileList = document.querySelector('.file-list');
    let cntElement = document.querySelector('.cnt');

    // 첨부파일 미리보기 처리
    fileInput?.addEventListener('change', function () {
        let files = fileInput.files;
        
        // 파일 변경 시 기존 미리보기 제거
        fileList.innerHTML = '';

        // 파일 개수 제한 (1개)
        if (files.length > 1) {
            let dt = new DataTransfer();
            fileInput.files = dt.files;
            console.log(files);
            alert("파일은 최대 1개까지만 첨부 가능합니다.");
            cntElement.textContent = files.length;
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

        // 첨부파일 삭제 버튼 처리
        document.querySelector(".img-cancel-btn")?.addEventListener("click", function () {
            this.closest("li").remove();

            let fileName = this.dataset.name;
            let dt = new DataTransfer();

            for (let i = 0; i < fileInput.files.length; i++) {
                if (fileInput.files[i].name !== fileName) {
                    dt.items.add(fileInput.files[i]);
                }
            }

            fileInput.files = dt.files;
            console.log(fileInput.files);
            cntElement.textContent = fileInput.files.length;
        });
    });

    // 취소 버튼 처리
    document.querySelector(".cancel-btn")?.addEventListener("click", function () {
        window.location.href = '/board/boardListOk.bo';
    });
});
