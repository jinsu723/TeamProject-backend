package com.learning.app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.learning.app.dto.FileDTO;
import com.mybatis.config.MyBatisConfig;

public class FileDAO {
	SqlSession sqlSession;

	public FileDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	public void insert(FileDTO fileDTO) {
		System.out.println("파일 DAO -> 저장 fileDTO: " + fileDTO);
		try {
			int result = sqlSession.insert("file.FileInsert", fileDTO);
			System.err.println("파일 저장 완료 -> db에 저장된 행의 개수: "+ result);
//			List<FileDTO> uploadFile = sqlSession.selectOne("file.communityFileSelect", fileDTO.getForumNumber());
//			System.out.println("DB에서 가져온 파일: "+ uploadFile);
		} catch (Exception e) {
			System.out.println("파일 저장에 실패했습니다.");
			e.printStackTrace();
		}
	}
	

	public List<FileDTO> select(int forumNumber) {
		return sqlSession.selectList("file.FileSelect", forumNumber);
	}

	public int filePk() {
		return sqlSession.selectOne("file.filePk");
	}

	public void delete(int forumNumber) {
		sqlSession.delete("file.FileDelete", forumNumber);
	}
}
