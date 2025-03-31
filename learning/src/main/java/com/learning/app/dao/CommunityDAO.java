package com.learning.app.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.learning.app.dto.CommunityDTO;
import com.learning.app.dto.PartyForumDTO;
import com.mybatis.config.MyBatisConfig;

public class CommunityDAO {
	public SqlSession sqlSession;

	public CommunityDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true); // Auto-commit 활성화
	}

	public List<CommunityDTO> getForumTitleList(Map<String, Object> pageMap) {
		List<CommunityDTO> list = sqlSession.selectList("Forum.communityForumFindTitle", pageMap);
		return list;
	}

	public int getFindUserAll(String FindUserNickname) {
		return sqlSession.selectOne("Forum.communityForumFindAll", FindUserNickname);
	}

	public List<CommunityDTO> getForumList(Map<String, Integer> pageMap) {
		List<CommunityDTO> list = sqlSession.selectList("Forum.communityForumFind", pageMap);
		return list;
	}

	public int getFindAll() {
		return sqlSession.selectOne("Forum.communityForumFindAll");
	}

	public void WritingEnd(CommunityDTO communityDTO) {
		sqlSession.insert("Forum.communityForumWriting", communityDTO);
	}

	public List<CommunityDTO> getpartyComment(int postNum) {
		return sqlSession.selectList("Forum.partyComment1", postNum);
	}

	public List<CommunityDTO> getForumDetail(int forumNumber) {
		return sqlSession.selectList("Forum.communityForumDetail", forumNumber);
	}

	public void forumDelete(int postNum) {
		sqlSession.delete("Forum.forumdelete", postNum);
	}

	public int FindUserNum(String UserId) {
		return sqlSession.selectOne("Forum.FindUserNum", UserId);
	}

	public int FindUserNum(int forumNumber) {
		return sqlSession.selectOne("Forum.FindUserNum1", forumNumber);
	}

	public void EditEnd(Map<String, String> map) {
		sqlSession.update("EditEnd", map);
	}

	public void CommentDelete(int commentNumber) {
		sqlSession.delete("Forum.commentDelete", commentNumber);
	}

	public void commentAdd(CommunityDTO communityDTO) {
		sqlSession.insert("Forum.commentAdd1", communityDTO);
	}

}