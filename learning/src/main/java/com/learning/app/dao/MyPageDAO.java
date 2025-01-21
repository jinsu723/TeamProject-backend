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

	public List<MyForumDTO> myRecruitmentList(int num) {
		return sql.selectList("mypage.myRecruitmentList", num);
	}

	public List<MyForumDTO> checkRecruiting(int num) {
		return sql.selectList("mypage.checkRecruiting", num);
	}

	public void recruiteAgree(int num) {
		System.out.println("수락");
		sql.selectOne("mypage.recruiteAgree", num);
	}

	public void recruiteDisagree(int num) {
		System.out.println("거절");
		sql.selectOne("mypage.recruiteDisagree", num);
	}
}