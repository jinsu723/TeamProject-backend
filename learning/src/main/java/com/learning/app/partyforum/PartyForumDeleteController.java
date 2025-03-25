package com.learning.app.partyforum;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learning.app.Execute;
import com.learning.app.Result;
import com.learning.app.dao.FileDAO;
import com.learning.app.dao.partyForumDAO;
import com.learning.app.dto.FileDTO;
import com.learning.app.dto.UserDTO;

public class PartyForumDeleteController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		HttpSession session = request.getSession();
		UserDTO userDTO = (UserDTO) session.getAttribute("userDTO");
		
		partyForumDAO partyForumDAO = new partyForumDAO();
		FileDAO fileDAO = new FileDAO();
		final String UPLOAD_PATH = request.getSession().getServletContext().getRealPath("/") + "upload/";
		System.out.println("기존에 저장하는 경로 확인 : " + UPLOAD_PATH);
		
		if (userDTO.getUserNumber() == partyForumDAO.FindUserNum(Integer.parseInt(request.getParameter("postNum")))) {
			List<FileDTO> fileList = fileDAO.select(Integer.parseInt(request.getParameter("postNum")));
//			System.out.println(fileList);
			if (fileList != null && !fileList.isEmpty()) {
				FileDTO existingFileDTO = fileList.get(0);
				String filePath = UPLOAD_PATH + existingFileDTO.getFileOriginalName();
				File file = new File(filePath);
				System.out.println("해당 경로에 삭제하는 파일 확인 : " + filePath);
				if (file.exists()) {
					if (file.delete()) {
//						System.out.println("기존 파일 삭제 성공: " + filePath);
					} else {
//						System.out.println("기존 파일 삭제 실패: " + filePath);
					}
				}
				fileDAO.delete(Integer.parseInt(request.getParameter("postNum"))); // 기존 파일 정보 삭제
			}
			
			partyForumDAO.PartyDelete(Integer.parseInt(request.getParameter("postNum")));
			
			result.setRedirect(true);
			result.setPath(request.getContextPath() + "/app/partyForum/partyForum.fo");
		} else {
			result.setRedirect(true);
			result.setPath(request.getContextPath() + "/app/partyForum/partyForum.fo");
		}

		

		return result;
	}

}
