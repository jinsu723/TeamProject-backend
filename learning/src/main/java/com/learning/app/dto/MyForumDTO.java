package com.learning.app.dto;

public class MyForumDTO {

//	  forum_number NUMBER,
//    user_number NUMBER,
//    forum_category VARCHAR2(10) NOT NULL,
//    forum_title VARCHAR2(150) NOT NULL,
//    forum_date DATE,
//    forum_update DATE,
//    forum_content VARCHAR2(2000) NOT NULL,

	private String forumNumber;
	private String partyNumber;
	private String userNickname;
	private String userTier;
	private String forumCategory;
	private String forumTitle;
	private String forumDate;
	private String commentCount;
	private String partyState;

	@Override
	public String toString() {
		return "[" + forumNumber + ", " + partyNumber + ", \'" + userNickname + "\', \'" + userTier + "\', \'"
				+ forumCategory + "\'" + ", \'" + forumTitle + "\', " + commentCount + ", \'" + forumDate + "\', \'"
				+ partyState + "\']";
	}

	public String getPartyNumber() {
		return partyNumber;
	}

	public void setPartyNumber(String partyNumber) {
		this.partyNumber = partyNumber;
	}

	public String getForumNumber() {
		return forumNumber;
	}

	public void setForumNumber(String forumNumber) {
		this.forumNumber = forumNumber;
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

	public String getPartyState() {
		return partyState;
	}

	public void setPartyState(String partyState) {
		this.partyState = partyState;
	}

}