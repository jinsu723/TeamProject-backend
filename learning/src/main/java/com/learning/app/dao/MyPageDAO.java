package com.learning.app.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.learning.app.dto.ForumDTO;
import com.learning.app.dto.MyForumDTO;
import com.mybatis.config.MyBatisConfig;

public class MyPageDAO {
	public SqlSession sql;

	public MyPageDAO() {
		sql = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	public int checkPass(String pass) {
		System.out.println("DAO 체크패스 이거 삭제할듯");
		return sql.selectOne("mypage.check", pass);
	}

	public int chageTier(Map<String, String> map) {
		System.out.println("DAO 티어변경");
		return sql.update("mypage.changeTier", map);
	}

	public int checkNick(String nick) {
		System.out.println("닉네임 중복체크");
		return sql.selectOne("mypage.checkNickName", nick);
	}

	public void changeNick(Map<String, String> nick) {
		System.out.println("닉네임 변경");
		sql.update("mypage.changeNick", nick);
	}

	public int deleteUser(int num) {
		System.out.println("DAO 유저 삭제");
		System.out.println(num);
		return sql.delete("mypage.deleteUser", num);
	}

	public List<MyForumDTO> myPostList(int num) {
		System.out.println("내 게시글 목록 조회");
		return sql.selectList("mypage.mypost", num);
	}
}
