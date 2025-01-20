package com.learning.app.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.learning.app.dto.AdminDTO;
import com.learning.app.dto.UserDTO;
import com.mybatis.config.MyBatisConfig;

public class AdminDAO {
	public SqlSession sqlSession;
	
	public AdminDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	// 로그인 검증
	public AdminDTO adminlogin(String adminId, String adminPw) {
	    Map<String, String> map = new HashMap<>();
	    map.put("id", adminId);
	    map.put("pw", adminPw);
	    System.out.println("map : " + map);
	    AdminDTO adminDTO = sqlSession.selectOne("Admin.login", map);
	    System.out.println("쿼리 결과 adminDTO: " + adminDTO);
	    return adminDTO;
	}

	
	
}
