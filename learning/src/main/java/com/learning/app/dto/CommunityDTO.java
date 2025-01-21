package com.learning.app.dto;

import java.util.Date;


//comment_number NUMBER,
//forum_number NUMBER,
//user_number NUMBER,
//comment_content VARCHAR2(500) NOT NULL,
//comment_date DATE,

public class CommunityDTO {
    private int forumNumber;
    private int userNumber;
    private String userNickName;
    private String forumCategory;
    private String forumTitle;
    private Date forumDate;
    private Date forumUpdate;
    private String forumContent;
    private int commentNumber;
    private String commentContent;
    private  Date commentDate;
    
    
    
    
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
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
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
	public Date getForumDate() {
		return forumDate;
	}
	public void setForumDate(Date forumDate) {
		this.forumDate = forumDate;
	}
	public Date getForumUpdate() {
		return forumUpdate;
	}
	public void setForumUpdate(Date forumUpdate) {
		this.forumUpdate = forumUpdate;
	}
	public String getForumContent() {
		return forumContent;
	}
	public void setForumContent(String forumContent) {
		this.forumContent = forumContent;
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
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
    
    
}
