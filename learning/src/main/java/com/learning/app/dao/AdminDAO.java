package com.learning.app.dao;

import java.util.HashMap;
import java.util.List;
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
   public List<UserDTO> adminUser() {
      return sqlSession.selectList("Admin.adminUser");
   }

   // 전체 회원 닉네임으로 검색하기
   public List<UserDTO> nickNameSearch(Map<String, Object> paramMap){
      return sqlSession.selectList("Admin.nickNameSearch", paramMap);
   }

}
