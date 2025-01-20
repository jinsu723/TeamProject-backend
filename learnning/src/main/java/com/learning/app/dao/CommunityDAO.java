package com.learning.app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.learning.app.dto.CommunityDTO;
import com.mybatis.config.MyBatisConfig;

public class CommunityDAO {
	public SqlSession sqlSession;
	CommunityDTO communityDTO = new CommunityDTO();

	public CommunityDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true); // Auto-commit 활성화
	}

	// 게시글 가져오기
	public List<CommunityDTO> getCommunityPosts() {
		List<CommunityDTO> communityList = sqlSession.selectList("Community.list");
		return communityList;
	}
	//게시글 개수 가져오기(페이지네이션 활용하기 위함)
	public int communityPostCount() {
		return sqlSession.selectOne("Community.count");
	}
}
