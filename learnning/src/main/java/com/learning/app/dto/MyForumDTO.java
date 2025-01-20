package com.learning.app.dto;

public class MyForumDTO {

//	  forum_number NUMBER,
//    user_number NUMBER,
//    forum_category VARCHAR2(10) NOT NULL,
//    forum_title VARCHAR2(150) NOT NULL,
//    forum_date DATE,
//    forum_update DATE,
//    forum_content VARCHAR2(2000) NOT NULL,

	private String userNickname;
	private String userTier;
	private String forumCategory;
	private String forumTitle;
	private String forumDate;
	private String commentCount;

	@Override
	public String toString() {
		return "[\'" + userNickname + "\', \'" + userTier + "\', \'" + forumCategory + "\'" + ", \'" + forumTitle + "\', "
				+ commentCount + ", \'" + forumDate + "\']";
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
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

	public String getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(String commentCount) {
		this.commentCount = commentCount;
	}

}