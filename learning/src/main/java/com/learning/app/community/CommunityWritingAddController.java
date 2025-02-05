package com.learning.app.community;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learning.app.dto.FileDTO;
import com.learning.app.dao.FileDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.CommunityDAO;
import com.learning.app.dto.CommunityDTO;
import com.learning.app.dto.UserDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class CommunityWritingAddController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("게시글 추가 컨트롤러 호출 성공");
		CommunityDTO communityDTO = new CommunityDTO();
		CommunityDAO commuuityDAO = new CommunityDAO();
		FileDTO fileDTO = new FileDTO();
		FileDAO fileDAO = new FileDAO();
		Result result = new Result();
		
		final String UPLOAD_PATH = request.getSession().getServletContext().getRealPath("/")+"upload";
		final int FILE_SIZE = 1024 * 1024* 40; //40MB
		System.out.println("파일 업로드 경로" + UPLOAD_PATH);
		
		MultipartRequest multipartRequest = new MultipartRequest(request, UPLOAD_PATH, FILE_SIZE, "UTF-8", new DefaultFileRenamePolicy()); 

//		String postCategory = request.getParameter("postCategory");
		String postCategory = "자유";
		String postTitle = multipartRequest.getParameter("postTitle");
		String postContent = multipartRequest.getParameter("postContent");
		String postUserName = ((UserDTO) request.getSession().getAttribute("userDTO")).getUserNickname();

		System.out.println("게시글 카테고리: " + postCategory);
		System.out.println("게시글 제목: " + postTitle);
		System.out.println("게시글 내용: " + postContent);
		System.out.println("게시글 작성자: " + postUserName);
		
		communityDTO.setForumCategory(postCategory);
		communityDTO.setForumTitle(postTitle);
		communityDTO.setForumContent(postContent);
		communityDTO.setUserNickName(postUserName);
		int forumNumber = commuuityDAO.postAddDetail(communityDTO);
		System.out.println("게시글 번호: "+forumNumber);
		
		
		
//		communityDTO.setForumTitle(postTitle);
		
		
		
		Enumeration<String> fileNames = multipartRequest.getFileNames();
		while (fileNames.hasMoreElements()) {
			String name = fileNames.nextElement();
			String fileSystemName = multipartRequest.getFilesystemName(name);
			String fileOriginalName = multipartRequest.getOriginalFileName(name);
			
			if(fileSystemName == null) {
				continue;
			}
			fileDTO.setFileSystemName(fileSystemName);
			fileDTO.setFileOriginalName(fileOriginalName);
			fileDTO.setForumNumber(forumNumber);
			
			System.out.println("업로드된 파일 정보: "+fileDTO);
			fileDAO.insert(fileDTO);
		}

//		boolean successCode = commuuityDAO.postAddDetail(communityDTO);
//		if (successCode) {
//			System.out.println("게시글 작성 완료");
//		} else {
//			System.out.println("게시글 작성 실패");
//		}

		result.setPath("/app/communityForum/communityForum.cf");
		result.setRedirect(false);

		return result;

	}
}
