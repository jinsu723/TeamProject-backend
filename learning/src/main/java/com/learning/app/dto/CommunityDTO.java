package com.learning.app.dto;

import java.util.List;

public class CommunityDTO {
	
	private int forumNumber; // forum_number 게시글 번호 pk
	private int userNumber; // user_number 유저 번호 fk
	private String userTier; // forum_category 게시글 카테고리
	private String forumCategory; // forum_category 게시글 카테고리
	private String forumTitle; // forum_title 게시글 제목
	private String forumDate; // forum_dater 게시글 작성일
	private String forumUpdate; // forum_update 게시글 업데이트 날짜
	private String forumContent; // forum_content 게시글 본문
	private String userNickname; // user_Nickname 작성자 이름
	private String userId;
	private int commentNumber;
	private String commentContent;
	private String commentDate;
	private String finalDate;
	private List<FileDTO> files;

	public int getForumNumber() {
		return forumNumber;
	}

	public void setForumNumber(int forumNumber) {
		this.forumNumber = forumNumber;
	}

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public String getUserTier() {
		return userTier;
	}

	public void setUserTier(String userTier) {
		this.userTier = userTier;
	}

	public String getForumCategory() {
		return forumCategory;
	}

	public void setForumCategory(String forumCategory) {
		this.forumCategory = forumCategory;
	}

	public String getForumTitle() {
		return forumTitle;
	}

	public void setForumTitle(String forumTitle) {
		this.forumTitle = forumTitle;
	}

	public String getForumDate() {
		return forumDate;
	}

	public void setForumDate(String forumDate) {
		this.forumDate = forumDate;
	}

	public String getForumUpdate() {
		return forumUpdate;
	}

	public void setForumUpdate(String forumUpdate) {
		this.forumUpdate = forumUpdate;
	}

	public String getForumContent() {
		return forumContent;
	}

	public void setForumContent(String forumContent) {
		this.forumContent = forumContent;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getCommentNumber() {
		return commentNumber;
	}

	public void setCommentNumber(int commentNumber) {
		this.commentNumber = commentNumber;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	public String getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(String finalDate) {
		this.finalDate = finalDate;
	}

	public List<FileDTO> getFiles() {
		return files;
	}

	public void setFiles(List<FileDTO> files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return "partyForumDTO [forumNumber=" + forumNumber + ", userNumber=" + userNumber + ", userTier=" + userTier
				+ ", forumCategory=" + forumCategory + ", forumTitle=" + forumTitle + ", forumDate=" + forumDate
				+ ", forumUpdate=" + forumUpdate + ", forumContent=" + forumContent + ", userNickname=" + userNickname
				+ ", userId=" + userId + ", commentNumber=" + commentNumber + ", commentContent=" + commentContent
				+ ", commentDate=" + commentDate + ", finalDate=" + finalDate + ", files=" + files + "]";
	}

}
