package com.learning.app.dto;

public class AdminDTO {
//	CREATE TABLE tbl_admin (
//		    admin_number NUMBER,
//		    admin_id VARCHAR2(20) NOT NULL,
//		    admin_passwd VARCHAR2(20) NOT NULL,
//		    CONSTRAINT pk_admin PRIMARY KEY (admin_number)
//		);
	
	private int adminNumber; //admin_number
	private String adminId; //admin_id
	private String adminPw; //admin_passwd
	
	
	public int getAdminNumber() {
		return adminNumber;
	}
	public void setAdminNumber(int adminNumber) {
		this.adminNumber = adminNumber;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminPw() {
		return adminPw;
	}
	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}
	@Override
	public String toString() {
		return "AdminDTO [adminNumber=" + adminNumber + ", adminId=" + adminId + ", adminPw=" + adminPw + "]";
	}
	
	
	

	
	
}
