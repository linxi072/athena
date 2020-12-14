package com.mezo.athena.demain;

public class AthenaUser {

    private Integer id;

    private String userId;

    private String passWord;

    private String userName;

    private Byte userSex;

    private Integer userAge;

    private Byte userCertType;

    private String userCertNum;

    private String userPhone;

    private String userEmail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Byte getUserSex() {
        return userSex;
    }

    public void setUserSex(Byte userSex) {
        this.userSex = userSex;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Byte getUserCertType() {
        return userCertType;
    }

    public void setUserCertType(Byte userCertType) {
        this.userCertType = userCertType;
    }

    public String getUserCertNum() {
        return userCertNum;
    }

    public void setUserCertNum(String userCertNum) {
        this.userCertNum = userCertNum == null ? null : userCertNum.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }
}