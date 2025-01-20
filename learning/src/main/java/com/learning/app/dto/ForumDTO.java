package com.learning.app.dto;

public class ForumDTO {

//	  forum_number NUMBER,
//    user_number NUMBER,
//    forum_category VARCHAR2(10) NOT NULL,
//    forum_title VARCHAR2(150) NOT NULL,
//    forum_date DATE,
//    forum_update DATE,
//    forum_content VARCHAR2(2000) NOT NULL,

	private int forumNumber;
	private int userNumber;
	private String forumCategory;
	private String forumTitle;
	private String forumDate;
	private String forumUpdate;
	private String forumContent;

	@Override
	public String toString() {
		return "ForumDTO [forumNumber=" + forumNumber + ", userNumber=" + userNumber + ", forumCategory="
				+ forumCategory + ", forumTitle=" + forumTitle + ", forumDate=" + forumDate + ", forumUpdate="
				+ forumUpdate + ", forumContent=" + forumContent + "]";
	}

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

}