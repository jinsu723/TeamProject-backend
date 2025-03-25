package com.learning.app.dto;

public class FileDTO {
	private int fileSystemName;
	private String fileOriginalName;
	private int forumNumber;
	

	public int getFileSystemName() {
		return fileSystemName;
	}
	public void setFileSystemName(int fileSystemName) {
		this.fileSystemName = fileSystemName;
	}
	public String getFileOriginalName() {
		return fileOriginalName;
	}
	public void setFileOriginalName(String fileOriginalName) {
		this.fileOriginalName = fileOriginalName;
	}
	public int getForumNumber() {
		return forumNumber;
	}
	public void setForumNumber(int forumNumber) {
		this.forumNumber = forumNumber;
	}
	
	@Override
	public String toString() {
		return "FileDTO [fileSystemName=" + fileSystemName + ", fileOriginalName=" + fileOriginalName + ", forumNumber="
				+ forumNumber + "]";
	}
	
	
	
	
	
}
