package com.learning.app.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.learning.app.dto.partyForumDTO;
import com.mybatis.config.MyBatisConfig;

public class partyForumDAO {
	public SqlSession sqlSession;

	public partyForumDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true); // Auto-commit 활성화
	}

	// 파티 글 작성
	public void WritingEnd(partyForumDTO partyForumDTO) {
		sqlSession.insert("Forum.partyForumWriting", partyForumDTO);
	}

	public List<partyForumDTO> getForumList() {
		return sqlSession.selectList("Forum.partyForumFind");
	}

	public List<partyForumDTO> getForumDetail(int forumNumber) {
		return sqlSession.selectList("Forum.partyForumDetail", forumNumber);
	}

	public List<partyForumDTO> getpartyComment(int postNum) {
		return sqlSession.selectList("Forum.partyComment", postNum);
	}

	public void PartyDelete(int postNum) {
		sqlSession.delete("Forum.partydelete", postNum);
	}

	public int ApplyUserNum(String UserId) {
		return sqlSession.selectOne("Forum.ApplyUserNum", UserId);
	}

	public void partyForumApply(Map<String, Integer> map) {
		sqlSession.insert("Forum.partyForumApply", map);
	}

	public int ApplyDuplication(Map<String, String> map) {
		return sqlSession.selectOne("Forum.ApplyDuplication", map);
	}

	public int ApplyNum(String postNum) {
		return sqlSession.selectOne("Forum.ApplyNum", postNum);
	}

	public void EditEnd(Map<String, String> map) {
		sqlSession.update("EditEnd", map);
	}

	public void CommentDelete(int commentNumber) {
    	sqlSession.delete("Forum.commentDelete", commentNumber);
    }
	
	public void commentAdd(Map<String, String> map) {
		sqlSession.insert("Forum.commentAdd", map);
	}


}