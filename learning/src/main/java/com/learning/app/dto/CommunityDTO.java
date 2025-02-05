package com.learning.app.dto;

import java.util.Date;
import java.util.List;

public class CommunityDTO {
    private int forumNumber;
    private int userNumber;
    private String userNickName;
    private String forumCategory;
    private String forumTitle;
    private String forumDate;
    private String forumUpdate;
    private String forumContent;
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
		return "CommunityDTO [forumNumber=" + forumNumber + ", userNumber=" + userNumber + ", userNickName="
				+ userNickName + ", forumCategory=" + forumCategory + ", forumTitle=" + forumTitle + ", forumDate="
				+ forumDate + ", forumUpdate=" + forumUpdate + ", forumContent=" + forumContent + ", commentNumber="
				+ commentNumber + ", commentContent=" + commentContent + ", commentDate=" + commentDate + ", finalDate="
				+ finalDate + ", files=" + files + "]";
	}
    
	
       
}
