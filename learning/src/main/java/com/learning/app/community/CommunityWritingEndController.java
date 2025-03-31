package com.learning.app.community;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.CommunityDAO;
import com.learning.app.dao.FileDAO;
import com.learning.app.dto.CommunityDTO;
import com.learning.app.dto.FileDTO;
import com.learning.app.dto.UserDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class CommunityWritingEndController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		UserDTO userDTO = (UserDTO) session.getAttribute("userDTO");

		FileDTO fileDTO = new FileDTO();
		FileDAO fileDAO = new FileDAO();
		Result result = new Result();

		final String UPLOAD_PATH = request.getSession().getServletContext().getRealPath("/") + "upload";
		final int FILE_SIZE = 1024 * 1024 * 40; // 40MB
		System.out.println("파일 업로드 경로 " + UPLOAD_PATH);

		MultipartRequest multipartRequest = new MultipartRequest(request, UPLOAD_PATH, FILE_SIZE, "UTF-8",
				new DefaultFileRenamePolicy());

		// DAO와 DTO 객체 생성
		CommunityDAO communityDAO = new CommunityDAO();
		CommunityDTO communityDTO = new CommunityDTO();

		if (multipartRequest.getParameter("forumCategory").isEmpty()
				|| multipartRequest.getParameter("forumTitle").trim().isEmpty()
				|| multipartRequest.getParameter("forumContent").trim().isEmpty()) {
			result.setRedirect(true); // ++++ Result 객체 추가 후 작성
			result.setPath(request.getContextPath() + "/app/communityForum/communityForum.cf?page=1&FindTitle=");
		} else {

			communityDTO.setUserNumber(userDTO.getUserNumber());
			communityDTO.setForumCategory(multipartRequest.getParameter("forumCategory"));
			communityDTO.setForumTitle(multipartRequest.getParameter("forumTitle"));
			communityDTO.setForumContent(multipartRequest.getParameter("forumContent"));
			communityDAO.WritingEnd(communityDTO);

			Enumeration<String> fileNames = multipartRequest.getFileNames();
			while (fileNames.hasMoreElements()) {
				String name = fileNames.nextElement();
				String fileOriginalName = multipartRequest.getFilesystemName(name);

				if (fileOriginalName == null) {
					continue;
				}

				int filepk = fileDAO.filePk();
				fileDTO.setFileSystemName(filepk);
				fileDTO.setFileOriginalName(fileOriginalName);
				fileDTO.setForumNumber(communityDTO.getForumNumber());

//				System.out.println("업로드된 파일 정보: " + fileDTO);
				fileDAO.insert(fileDTO);

			}

			result.setRedirect(true); // ++++ Result 객체 추가 후 작성
			result.setPath(request.getContextPath() + "/app/communityForum/communityForum.cf?page=1&FindTitle=");

		}

		return result;
	}
}
