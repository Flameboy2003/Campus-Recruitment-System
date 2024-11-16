package com.example.campusreq.pojo;

public class Student {
    private String fullName;
    private String contactNo;
    private String regNumber;
    private String summary;
    private String keySkills;
    private String tenthPercentage;
    private String tenthBoard;
    private String tenthSchool;
    private String tenthCity;
    private String twelfthPercentage;
    private String twelfthBoard;
    private String twelfthSchool;
    private String twelfthCity;



    // New fields
    private String diplomaPercentage;
    private String diplomaBoard;
    private String diplomaCollege;
    private String diplomaCity;
    private String fieldOfInterest;
    private String achievements;
    private String leetCodeLink;
    private String hackerRankLink;
    private String gitHubLink;
    private String linkedInLink;

    public String getDiplomaPercentage() {
        return diplomaPercentage;
    }

    public void setDiplomaPercentage(String diplomaPercentage) {
        this.diplomaPercentage = diplomaPercentage;
    }

    public String getDiplomaBoard() {
        return diplomaBoard;
    }

    public void setDiplomaBoard(String diplomaBoard) {
        this.diplomaBoard = diplomaBoard;
    }

    public String getDiplomaCollege() {
        return diplomaCollege;
    }

    public void setDiplomaCollege(String diplomaCollege) {
        this.diplomaCollege = diplomaCollege;
    }

    public String getDiplomaCity() {
        return diplomaCity;
    }

    public void setDiplomaCity(String diplomaCity) {
        this.diplomaCity = diplomaCity;
    }

    public String getFieldOfInterest() {
        return fieldOfInterest;
    }

    public void setFieldOfInterest(String fieldOfInterest) {
        this.fieldOfInterest = fieldOfInterest;
    }

    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }

    public String getLeetCodeLink() {
        return leetCodeLink;
    }

    public void setLeetCodeLink(String leetCodeLink) {
        this.leetCodeLink = leetCodeLink;
    }

    public String getHackerRankLink() {
        return hackerRankLink;
    }

    public void setHackerRankLink(String hackerRankLink) {
        this.hackerRankLink = hackerRankLink;
    }

    public String getGitHubLink() {
        return gitHubLink;
    }

    public void setGitHubLink(String gitHubLink) {
        this.gitHubLink = gitHubLink;
    }

    public String getLinkedInLink() {
        return linkedInLink;
    }

    public void setLinkedInLink(String linkedInLink) {
        this.linkedInLink = linkedInLink;
    }

    public Student() {
        // Default constructor required for Firebase deserialization
    }

    public Student(String fullName, String contactNo, String regNumber, String summary, String keySkills,
                   String tenthPercentage, String tenthBoard, String tenthSchool, String tenthCity,
                   String twelfthPercentage, String twelfthBoard, String twelfthSchool, String twelfthCity,
                   String diplomaPercentage, String diplomaBoard, String diplomaCollege, String diplomaCity,
                   String fieldOfInterest, String achievements, String leetCodeLink,
                   String hackerRankLink, String gitHubLink, String linkedInLink) {
        this.fullName = fullName;
        this.contactNo = contactNo;
        this.regNumber = regNumber;
        this.summary = summary;
        this.keySkills = keySkills;
        this.tenthPercentage = tenthPercentage;
        this.tenthBoard = tenthBoard;
        this.tenthSchool = tenthSchool;
        this.tenthCity = tenthCity;
        this.twelfthPercentage = twelfthPercentage;
        this.twelfthBoard = twelfthBoard;
        this.twelfthSchool = twelfthSchool;
        this.twelfthCity = twelfthCity;
        this.diplomaPercentage = diplomaPercentage;
        this.diplomaBoard = diplomaBoard;
        this.diplomaCollege = diplomaCollege;
        this.diplomaCity = diplomaCity;
        this.fieldOfInterest = fieldOfInterest;
        this.achievements = achievements;
        this.leetCodeLink = leetCodeLink;
        this.hackerRankLink = hackerRankLink;
        this.gitHubLink = gitHubLink;
        this.linkedInLink = linkedInLink;

    }

    // Getters and Setters for all fields
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getKeySkills() {
        return keySkills;
    }

    public void setKeySkills(String keySkills) {
        this.keySkills = keySkills;
    }

    public String getTenthPercentage() {
        return tenthPercentage;
    }

    public void setTenthPercentage(String tenthPercentage) {
        this.tenthPercentage = tenthPercentage;
    }

    public String getTenthBoard() {
        return tenthBoard;
    }

    public void setTenthBoard(String tenthBoard) {
        this.tenthBoard = tenthBoard;
    }

    public String getTenthSchool() {
        return tenthSchool;
    }

    public void setTenthSchool(String tenthSchool) {
        this.tenthSchool = tenthSchool;
    }

    public String getTenthCity() {
        return tenthCity;
    }

    public void setTenthCity(String tenthCity) {
        this.tenthCity = tenthCity;
    }

    public String getTwelfthPercentage() {
        return twelfthPercentage;
    }

    public void setTwelfthPercentage(String twelfthPercentage) {
        this.twelfthPercentage = twelfthPercentage;
    }

    public String getTwelfthBoard() {
        return twelfthBoard;
    }

    public void setTwelfthBoard(String twelfthBoard) {
        this.twelfthBoard = twelfthBoard;
    }

    public String getTwelfthSchool() {
        return twelfthSchool;
    }

    public void setTwelfthSchool(String twelfthSchool) {
        this.twelfthSchool = twelfthSchool;
    }

    public String getTwelfthCity() {
        return twelfthCity;
    }

    public void setTwelfthCity(String twelfthCity) {
        this.twelfthCity = twelfthCity;
    }

    // toString() method for debugging and logging
    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", regNumber='" + regNumber + '\'' +
                ", summary='" + summary + '\'' +
                ", keySkills='" + keySkills + '\'' +
                ", tenthPercentage='" + tenthPercentage + '\'' +
                ", tenthBoard='" + tenthBoard + '\'' +
                ", tenthSchool='" + tenthSchool + '\'' +
                ", tenthCity='" + tenthCity + '\'' +
                ", twelfthPercentage='" + twelfthPercentage + '\'' +
                ", twelfthBoard='" + twelfthBoard + '\'' +
                ", twelfthSchool='" + twelfthSchool + '\'' +
                ", twelfthCity='" + twelfthCity + '\'' +
                '}';
    }
}
