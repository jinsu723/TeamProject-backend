package com.learning.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.learning.app.dto.AdminDTO;
import com.learning.app.dto.AdminPartyDTO;
import com.learning.app.dto.UserDTO;
import com.mybatis.config.MyBatisConfig;

public class AdminDAO {
	public SqlSession sqlSession;

	public AdminDAO() {
		System.out.println("센션 객체 만들기");
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	// 로그인 검증
	public AdminDTO adminlogin(String adminId, String adminPasswd) {
		Map<String, String> map = new HashMap<>();
		map.put("id", adminId);
		map.put("pw", adminPasswd);
		System.out.println("map : " + map);
		AdminDTO adminDTO = sqlSession.selectOne("Admin.login", map);
		System.out.println("쿼리 결과 adminDTO: " + adminDTO);
		return adminDTO;
	}

	// 전체 회원 수
	public int selectCount() {
		return sqlSession.selectOne("Admin.totalUserCount");
	}

	// 전체 회원 목록 조회
	public List<UserDTO> adminUser(Map<String, Integer> adminMap) {
		return sqlSession.selectList("Admin.adminUser");
	}

	// 전체 파티 게시글 수
	public int selectPartyForumCount() {
		return sqlSession.selectOne("Admin.totalPartyForumCount");
	}

	// 전체 파티 게시글 목록 조회
	public List<AdminPartyDTO> adminParty() {
		return sqlSession.selectList("Admin.adminParty");
	}

	// 전체 커뮤니티 게시글 수
	public int selectCommunityParty() {
		return sqlSession.selectOne("Admin.totalCommunityCount");
	}

	// 전체 커뮤니티 목록 조회
	public List<AdminPartyDTO> adminCommunity() {
		return sqlSession.selectList("Admin.adminCommunity");
	}

	// 총 개시글 수
	public int getPostCount(int day) {
		return sqlSession.selectOne("Admin.postCount", day);
	}

	// 티어별 수
	public int getTierCount(String tier) {
		return sqlSession.selectOne("Admin.tierCount", tier);
	}

	// 카테고리별 수
	public int getCategoryCount(String category) {
		return sqlSession.selectOne("Admin.categoryCount", category);
	}

	// 유저 검색
	public List<UserDTO> getSearchUserResult(String userNickname) {
		return sqlSession.selectList("Admin.searchUser", userNickname);
	}

	// 파티 게시글 삭제
	public void deletePartyForum(int forumNumber) {
		sqlSession.delete("Admin.deletePartyForum", forumNumber);
	}
}
