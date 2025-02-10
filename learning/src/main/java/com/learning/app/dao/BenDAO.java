package com.learning.app.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.learning.app.dto.BenDTO;
import com.mybatis.config.MyBatisConfig;

public class BenDAO {
	public SqlSession sqlSession;
	
	public BenDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true); // Auto-commit 활성화
	}
	
	// 밴 된 회원 목록 가져오기
	public List<BenDTO> benList(Map<String, Integer> benMap) {
		List<BenDTO> benList = sqlSession.selectList("Ben.viewBen", benMap);
		
		return benList;
	}
	
	// 페이지네이션을 위한 밴 된 회원 수 자겨오기
	public int getBenedUsers() {
		int benedUserNum = sqlSession.selectOne("Ben.benedUserNumber");
		
		return benedUserNum;
	}
	
	// 벤 취소하기
	public void cancelBen(String userNickname) {
		sqlSession.delete("Ben.cancelBen", userNickname);
	}
	
	// 밴 횟수 1회 증가시키기
	public void plusBenCnt(String userNickname) {
		System.out.println("밴 횟수 추가");
		sqlSession.update("Ben.plusBenCnt", userNickname);
	}
	
	// 밴 시키기
	public void Ben(BenDTO benDTO) {
		System.out.println("벤시키기");
		sqlSession.insert("Ben.ben", benDTO);
	}
	
	// 밴 중복검사 메소드
	public int checkBen(String userNickname) {
		System.out.println("밴 중복검사 쿼리 실행");
		return sqlSession.selectOne("Ben.check", userNickname);
	}
}
