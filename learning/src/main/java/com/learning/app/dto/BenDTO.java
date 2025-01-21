package com.learning.app.dto;

public class BenDTO {
//	CREATE TABLE tbl_ben (
//		    ben_number NUMBER,
//		    user_num NUMBER,
//		    ben_start_date DATE,
//		    ben_period NUMBER NOT NULL,
//		    ben_reason VARCHAR2(50) NOT NULL,
//		    CONSTRAINT pk_ben PRIMARY KEY (ben_number),
//		    CONSTRAINT fk_ben_user FOREIGN KEY (user_num) REFERENCES tbl_user (user_number) ON DELETE CASCADE
//		);

	private int benNumber;
	private String userId;
	private String userNickname;
	private String benReason;
	private String benStartDate;
	private String benEndDate;
	private int benPeriod;
	private int userNumber;
	
	public int getBenNumber() {
		return benNumber;
	}
	public void setBenNumber(int benNumber) {
		this.benNumber = benNumber;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public String getBenReason() {
		return benReason;
	}
	public void setBenReason(String benReason) {
		this.benReason = benReason;
	}
	public String getBenStartDate() {
		return benStartDate;
	}
	public void setBenStartDate(String benStartDate) {
		this.benStartDate = benStartDate;
	}
	public String getBenEndDate() {
		return benEndDate;
	}
	public void setBenEndDate(String benEndDate) {
		this.benEndDate = benEndDate;
	}
	public int getBenPeriod() {
		return benPeriod;
	}
	public void setBenPeriod(int benPeriod) {
		this.benPeriod = benPeriod;
	}
	public int getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}
	@Override
	public String toString() {
		return "BenDTO [benNumber=" + benNumber + ", userId=" + userId + ", userNickname=" + userNickname
				+ ", benReason=" + benReason + ", benStartDate=" + benStartDate + ", benEndDate=" + benEndDate
				+ ", benPeriod=" + benPeriod + ", userNumber=" + userNumber + "]";
	}
	
	
}
