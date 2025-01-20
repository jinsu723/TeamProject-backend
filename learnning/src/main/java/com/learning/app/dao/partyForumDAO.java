package com.learning.app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.learning.app.dto.partyForumDTO;
import com.mybatis.config.MyBatisConfig;

public class partyForumDAO {
	public SqlSession sqlSession;

	public partyForumDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true); // Auto-commit 활성화
	}
	
	//파티 글 작성 
	public void WritingEnd(partyForumDTO partyForumDTO) {
		sqlSession.insert("Forum.partyForumWriting", partyForumDTO);
	}
	
    public List<partyForumDTO> getForumList() {
        return sqlSession.selectList("Forum.partyForumFind");
    }

	

}