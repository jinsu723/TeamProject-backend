package com.learning.app.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.learning.app.dto.PartyForumDTO;
import com.mybatis.config.MyBatisConfig;

public class partyForumDAO {
	public SqlSession sqlSession;

	public partyForumDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true); // Auto-commit 활성화
	}

	public List<PartyForumDTO> partyForumTitleList(Map<String, Object> pageMap) {
		List<PartyForumDTO> list = sqlSession.selectList("Forum.partyForumFindTitle", pageMap);
		return list;
	}

	public int getFindUserAll(String FindUserNickname) {
		return sqlSession.selectOne("Forum.partyForumFindAll", FindUserNickname);
	}

	public List<PartyForumDTO> getForumList(Map<String, Integer> pageMap) {
		List<PartyForumDTO> list = sqlSession.selectList("Forum.partyForumFind", pageMap);
		return list;
	}

	public int getFindAll() {
		return sqlSession.selectOne("Forum.partyForumFindAll");
	}

	public List<PartyForumDTO> getForumDetail(int forumNumber) {
		return sqlSession.selectList("Forum.partyForumDetail", forumNumber);
	}

	public List<PartyForumDTO> getpartyComment(int postNum) {
		return sqlSession.selectList("Forum.partyComment", postNum);
	}

	public int FindUserNum(String UserId) {
		return sqlSession.selectOne("Forum.FindUserNum", UserId);
	}

	public void commentAdd(PartyForumDTO partyForumDTO) {
		sqlSession.insert("Forum.commentAdd", partyForumDTO);
	}

	public int ApplyDuplication(PartyForumDTO partyForumDTO) {
		return sqlSession.selectOne("Forum.ApplyDuplication", partyForumDTO);
	}

	public void partyForumApply(PartyForumDTO partyForumDTO) {
		sqlSession.insert("Forum.partyForumApply", partyForumDTO);
	}

	public int FindUserNum(int forumNumber) {
		return sqlSession.selectOne("Forum.FindUserNum1", forumNumber);
	}

	public void WritingEnd(PartyForumDTO partyForumDTO) {
		sqlSession.insert("Forum.partyForumWriting", partyForumDTO);
	}

	public void forumDelete(int postNum) {
		sqlSession.delete("Forum.forumdelete", postNum);
	}

	public void EditEnd(Map<String, String> map) {
		sqlSession.update("Forum.EditEnd", map);
	}

	public void CommentDelete(int commentNumber) {
		sqlSession.delete("Forum.commentDelete", commentNumber);
	}
	
	public int findApply(int postNum) {
		return sqlSession.selectOne("Forum.findApply", postNum);
	}

}