package com.learning.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import com.learning.app.dto.UserDTO;
import com.mybatis.config.MyBatisConfig;

public class UserDAO {
	public SqlSession sqlSession;

	public UserDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true); // Auto-commit 활성화
	}

	// 로그인 검증
	public UserDTO login(String userId, String userPw) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", userId);
		map.put("pw", userPw);
		System.out.println("map : " + map);
		return sqlSession.selectOne("User.login", map);
	}

	// 전화번호 중복 확인
	// 중복 있으면 1 반환 중복 없으면 0 반환
	public int checkPhone(UserDTO userDTO) {
		return sqlSession.selectOne("User.checkPhone", userDTO);
	}

	// 회원가입
	public void signUp(UserDTO userDTO) {
		sqlSession.insert("User.signUp", userDTO);
	}

	
	// 닉네임 중복 검사
	public boolean checkNickname(String userNickname) {
		int count = sqlSession.selectOne("User.checkNickname", userNickname);
		return count > 0; // 중복이면 true, 아니면 false
	}

	// 아이디 중복 검사
	public boolean isIdDuplicate(String userId) {
		int count = sqlSession.selectOne("User.checkId", userId);
		return count > 0;
	}

//	// 전화번호 중복 검사
//	public boolean isPhoneDuplicate(String phone) {
//		int count = sqlSession.selectOne("User.checkPhone", phone);
//		return count > 0;
//	}

	// 전체 회원 수
	public int selectCount() {
		return sqlSession.selectOne("User.totalUser");
	}

	// 전체 회원 목록 조회
	public List<UserDTO> managerUser() {
		return sqlSession.selectList("User.managerUser");
	}

}
