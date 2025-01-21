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

	// 게시글 목록 가져오기
	public List<CommunityDTO> getCommunityPosts() {
		List<CommunityDTO> communityList = sqlSession.selectList("Community.list");
		return communityList;
	}
	//게시글 개수 가져오기(페이지네이션 활용하기 위함)
	public int communityPostCount() {
		return sqlSession.selectOne("Community.count");
	}
	//게시글 상세페이지 이동을 위한 DB쿼리
	public List<CommunityDTO> communityDetils(int postNumber) {
		System.out.println("DB에서 값을 조회합니다. 게시글의 PK값은 "+postNumber+"입니다.");
		List<CommunityDTO> details = sqlSession.selectList("Community.postDetails", postNumber);
		System.out.println("DB에서 값을 조회했습니다. 아래에 내용을 확인 해 주세요");
		return details;
	}
	//게시글 상세페이지에 따른 댓글 DB쿼리
	public List<CommunityDTO> communityDetailComment(int postNumber) {
		List<CommunityDTO> comment = sqlSession.selectList("Community.getComment", postNumber);
		return comment;
	}
	public int postNumberView() {
		return sqlSession.delete("Community.deletePost");
	}
	
	
}