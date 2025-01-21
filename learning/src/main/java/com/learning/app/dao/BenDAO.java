package com.learning.app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.learning.app.dto.BenDTO;
import com.mybatis.config.MyBatisConfig;

public class BenDAO {
	public SqlSession sqlSession;
	
	public BenDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true); // Auto-commit 활성화
	}
	
	// 밴 된 회원 목록 가져오기
	public List<BenDTO> benList() {
		List<BenDTO> benList = sqlSession.selectList("Ben.viewBen");
		
		return benList;
	}
	
	// 페이지네이션을 위한 밴 된 회원 수 자겨오기
	public int getBenedUsers() {
		int benedUserNum = sqlSession.selectOne("Ben.benedUserNumber");
		
		return benedUserNum;
	}
}
