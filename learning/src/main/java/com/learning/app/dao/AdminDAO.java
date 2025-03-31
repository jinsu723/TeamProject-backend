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
	public int selectCount(String searchedUserNick) {
		return sqlSession.selectOne("Admin.totalUserCount", searchedUserNick);
	}

	// 전체 회원 목록 조회
	public List<UserDTO> adminUser(Map<String, String> adminMap) {
		return sqlSession.selectList("Admin.adminUser", adminMap);
	}
	
	// 검색된 전체 회원 수
	public int searchedUserCount() {
		return sqlSession.selectOne("Admin.totalSearchedUserCount");
	}
	
	// 전체 회원 중 닉네임으로 검색
	public List<UserDTO> adminSearchUser(Map<String, String> adminMap){
		return sqlSession.selectList("Admin.adminSearchUser", adminMap);
	}

	  // 전체 파티 게시글 수
	  public int selectPartyCount(String searchedPartyNick) {
	  	return sqlSession.selectOne("Admin.adminSearhPartyTotal", searchedPartyNick);
	  }

	  // 전체 파티 게시글 목록 조회
	  public List<AdminPartyDTO> adminParty(Map<String, String> adminMap) {
	  	return sqlSession.selectList("Admin.adminSearhParty", adminMap);
	  }
	  
	  // 검색된 전체 파티 게시글 수
	  public int searchPartyNickCount() {
	  	return sqlSession.selectOne("Admin.adminSearhPartyTotal");
	  }
	  
	  // 파티 게시글 닉네임으로 검색
	  public List<AdminPartyDTO> adminSearchParty(Map<String, String> adminMap){
	  	return sqlSession.selectList("Admin.adminSearhParty", adminMap);
	  }
	  
		// 전체 커뮤니티 게시글 수
		public int selectCommunityCount(String searchedCommunityNick) {
			return sqlSession.selectOne("Admin.adminSearchCommunityTotal", searchedCommunityNick);
		}

		// 전체 커뮤니티 목록 가져오기
		public List<AdminPartyDTO> adminCommunity(Map<String, String> adminMap) {
			System.out.println("전체 커뮤니티 목록 가져오기 실행");
			return sqlSession.selectList("Admin.adminSearchCommunity", adminMap);
		}

		// 커뮤니티 닉네임 검색 시 게시글 수
		public int searchCommunityCount() {
			return sqlSession.selectOne("Admin.adminSearchCommunityTotal");
		}
		
		// 커뮤니티 게시글 닉네임으로 검색
		public List<AdminPartyDTO> adminSearchCommunity(Map<String, String> adminMap){
			return sqlSession.selectList("Admin.adminSearchCommunity", adminMap);
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
		System.out.println("삭제할 게시글 번호 : " + forumNumber);
		sqlSession.delete("Admin.deletePartyForum", forumNumber);
		sqlSession.commit();
		System.out.println("게시글 삭제 완료");
	}
}
