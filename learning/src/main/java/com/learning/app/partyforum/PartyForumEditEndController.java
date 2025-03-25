package com.learning.app.partyforum;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.FileDAO;
import com.learning.app.dao.partyForumDAO;
import com.learning.app.dto.FileDTO;
import com.learning.app.dto.PartyForumDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class PartyForumEditEndController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FileDTO fileDTO = new FileDTO();
		FileDAO fileDAO = new FileDAO();
		Result result = new Result();

		final String UPLOAD_PATH = request.getSession().getServletContext().getRealPath("/") + "upload/";
		final int FILE_SIZE = 1024 * 1024 * 40; // 40MB

		MultipartRequest multipartRequest = new MultipartRequest(request, UPLOAD_PATH, FILE_SIZE, "UTF-8",
				new DefaultFileRenamePolicy());

		// DAO와 DTO 객체 생성
		partyForumDAO partyForumDAO = new partyForumDAO();
		PartyForumDTO partyForumDTO = new PartyForumDTO();

		// 게시글 수정 내용
		Map<String, String> map = new HashMap<String, String>();
		map.put("forumTitle", multipartRequest.getParameter("forumTitle"));
		map.put("forumContent", multipartRequest.getParameter("forumContent"));
		map.put("postNum", multipartRequest.getParameter("postNum"));
		System.out.println(map);

		// 게시글 수정 처리
		partyForumDAO.EditEnd(map);
		partyForumDTO.setForumNumber(Integer.parseInt(multipartRequest.getParameter("postNum")));

		// 기존 업로드된 파일 삭제
		Enumeration<String> fileNames = multipartRequest.getFileNames();
		while (fileNames.hasMoreElements()) {
			String name = fileNames.nextElement();
			String fileOriginalName = multipartRequest.getFilesystemName(name);

			// 파일이 존재하면 DB에서 삭제하고 서버에서 삭제
			if (fileOriginalName != null) {
				// 기존 파일 정보 가져오기
				List<FileDTO> fileList = fileDAO.select(partyForumDTO.getForumNumber());

				// 기존 파일이 있다면 삭제 처리
				if (!fileList.isEmpty()) {
					FileDTO existingFileDTO = fileList.get(0); // 첫 번째 파일만 처리

					// 기존 파일 경로 생성
					String filePath = UPLOAD_PATH + existingFileDTO.getFileOriginalName();
					File file = new File(filePath);

					// 파일이 존재하면 삭제
					if (file.exists()) {
						if (file.delete()) {
							System.out.println("기존 파일 삭제 성공: " + filePath);
						} else {
							System.out.println("기존 파일 삭제 실패: " + filePath);
						}
					}
					// DB에서 기존 파일 정보 삭제
					fileDAO.delete(partyForumDTO.getForumNumber()); // 기존 파일 정보 삭제
					System.out.println("DB에서 기존 파일 정보 삭제 완료");
				}

				// 새로운 파일 처리
				int fileSystemName = fileDAO.filePk(); // 새로운 파일 시스템 이름 생성
				fileDTO.setFileSystemName(fileSystemName);
				fileDTO.setFileOriginalName(fileOriginalName);
				fileDTO.setForumNumber(partyForumDTO.getForumNumber());

				if (fileDTO.getFileOriginalName() != null) {

					// 새로운 파일 DB에 삽입
					fileDAO.insert(fileDTO);
					System.out.println("새로운 파일 정보 DB에 저장: " + fileDTO);
				}
			} else {
				List<FileDTO> fileList = fileDAO.select(partyForumDTO.getForumNumber());
				System.out.println(fileList);
				if (fileList != null && !fileList.isEmpty()) {
					FileDTO existingFileDTO = fileList.get(0);
					String filePath = UPLOAD_PATH + existingFileDTO.getFileOriginalName();
					File file = new File(filePath);
					if (file.exists()) {
						if (file.delete()) {
							System.out.println("기존 파일 삭제 성공: " + filePath);
						} else {
							System.out.println("기존 파일 삭제 실패: " + filePath);
						}
					}
					fileDAO.delete(partyForumDTO.getForumNumber()); // 기존 파일 정보 삭제
					System.out.println("DB에서 기존 파일 정보 삭제 완료");

				}

			}

		}

		result.setRedirect(true);
		result.setPath(request.getContextPath() + "/app/partyForum/partyForum.fo");

		return result;
	}
}
