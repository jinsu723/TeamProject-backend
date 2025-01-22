package com.learning.app.dto;

public class UserDTO {
   
//   CREATE TABLE tbl_user (
//          user_number NUMBER,
//          user_id VARCHAR2(20) NOT NULL,
//          user_passwd VARCHAR2(20) NOT NULL,
//          user_nickname VARCHAR2(15) NOT NULL,
//          user_tier VARCHAR2(15) NOT NULL,
//          user_phone VARCHAR2(15) NOT NULL,
//          user_join_date DATE,
//          user_ben_ctn NUMBER DEFAULT 0,
//          CONSTRAINT pk_user PRIMARY KEY (user_number),
//          CONSTRAINT uq_user_id UNIQUE (user_id),
//          CONSTRAINT uq_user_nickname UNIQUE (user_nickname),
//          CONSTRAINT uq_user_phone UNIQUE (user_phone)
//      );

   private int userNumber;
   private String userId;
   private String userPasswd;
   private String userNickname;
   private String userTier;
   private String userPhone;
   private String userJoinDate;
   private int userBenCnt;
   
   
public int getUserNumber() {
	return userNumber;
}
public void setUserNumber(int userNumber) {
	this.userNumber = userNumber;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getUserPasswd() {
	return userPasswd;
}
public void setUserPasswd(String userPasswd) {
	this.userPasswd = userPasswd;
}
public String getUserNickname() {
	return userNickname;
}
public void setUserNickname(String useNickname) {
	this.userNickname = useNickname;
}
public String getUserTier() {
	return userTier;
}
public void setUserTier(String userTier) {
	this.userTier = userTier;
}
public String getUserPhone() {
	return userPhone;
}
public void setUserPhone(String userPhone) {
	this.userPhone = userPhone;
}
public String getUserJoinDate() {
	return userJoinDate;
}
public void setUserJoinDate(String userJoinDate) {
	this.userJoinDate = userJoinDate;
}
public int getUserBenCnt() {
	return userBenCnt;
}
public void setUserBenCnt(int userBenCnt) {
	this.userBenCnt = userBenCnt;
}


@Override
public String toString() {
	return "UserDTO [userNumber=" + userNumber + ", userId=" + userId + ", userPasswd=" + userPasswd + ", userNickname="
			+ userNickname + ", userTier=" + userTier + ", userPhone=" + userPhone + ", userJoinDate=" + userJoinDate
			+ ", userBenCnt=" + userBenCnt + "]";
}
   
   
   
}  