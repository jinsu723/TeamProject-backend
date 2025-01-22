package com.learning.app.dto;

public class AdminPartyDTO {

   //관리자 파티 게시글 DTO
   // 게시글 번호, 닉네임, 티어, 카테고리, 제목, 작성시간
   
   private int forumNumber;
   private int userNumber;
   private String userNickname;
   private String userTier;
   private String forumCategory;
   private String forumTitle;
   private String forumDate;

   @Override
   public String toString() {
      return "AdminPartyDTO [forumNumber=" + forumNumber + ", userNumber=" + ", userNickname=" + userNickname
            + ", forumCategory=" + forumCategory + ", forumTitle=" + forumTitle 
            + ", forumDate=" + forumDate + ", userTier=" + userTier + "]";
   }
   public String getUserTier() {
      return userTier;
   }
   
   
   public void setUserTier(String userTier) {
      this.userTier = userTier;
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
   public String getUserNickname() {
      return userNickname;
   }
   public void setUserNickname(String userNickname) {
      this.userNickname = userNickname;
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
   
   
   
   
   
}
