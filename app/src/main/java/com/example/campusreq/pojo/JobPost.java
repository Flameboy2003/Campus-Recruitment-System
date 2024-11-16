package com.example.campusreq.pojo;

import java.io.Serializable;

public class JobPost implements Serializable {
    private String jobId;
    private String companyName;

    private String batch;
    private String companyMarket;
    private String jobDescription;
    private String employmentType;
    private String jobRole;
    private String jobLocation;
    private String hiringProcess;
    private String probationPeriod;
    private String salaryDuringProbation;
    private String salaryAfterProbation;
    private String bond;
    private String workingDaysPerWeek;
    private String messageForStudents;
    private String twelfthPercentage;
    private String graduationPercentage;
    private String backlogs;

    public JobPost() {
        // Default constructor required for calls to DataSnapshot.getValue(JobPost.class)
    }

    public JobPost(String jobId, String companyName, String batch, String companyMarket, String jobDescription, String employmentType,
                   String jobRole, String jobLocation, String hiringProcess, String probationPeriod, String salaryDuringProbation,
                   String salaryAfterProbation, String bond, String workingDaysPerWeek, String messageForStudents,
                   String twelfthPercentage, String graduationPercentage, String backlogs) {
        this.jobId = jobId;
        this.companyName = companyName;
        this.batch = batch;
        this.companyMarket = companyMarket;
        this.jobDescription = jobDescription;
        this.employmentType = employmentType;
        this.jobRole = jobRole;
        this.jobLocation = jobLocation;
        this.hiringProcess = hiringProcess;
        this.probationPeriod = probationPeriod;
        this.salaryDuringProbation = salaryDuringProbation;
        this.salaryAfterProbation = salaryAfterProbation;
        this.bond = bond;
        this.workingDaysPerWeek = workingDaysPerWeek;
        this.messageForStudents = messageForStudents;
        this.twelfthPercentage = twelfthPercentage;
        this.graduationPercentage = graduationPercentage;
        this.backlogs = backlogs;
    }

    // Getters and setters
    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getCompanyMarket() {
        return companyMarket;
    }

    public void setCompanyMarket(String companyMarket) {
        this.companyMarket = companyMarket;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public String getHiringProcess() {
        return hiringProcess;
    }

    public void setHiringProcess(String hiringProcess) {
        this.hiringProcess = hiringProcess;
    }

    public String getProbationPeriod() {
        return probationPeriod;
    }

    public void setProbationPeriod(String probationPeriod) {
        this.probationPeriod = probationPeriod;
    }

    public String getSalaryDuringProbation() {
        return salaryDuringProbation;
    }

    public void setSalaryDuringProbation(String salaryDuringProbation) {
        this.salaryDuringProbation = salaryDuringProbation;
    }

    public String getSalaryAfterProbation() {
        return salaryAfterProbation;
    }

    public void setSalaryAfterProbation(String salaryAfterProbation) {
        this.salaryAfterProbation = salaryAfterProbation;
    }

    public String getBond() {
        return bond;
    }

    public void setBond(String bond) {
        this.bond = bond;
    }

    public String getWorkingDaysPerWeek() {
        return workingDaysPerWeek;
    }

    public void setWorkingDaysPerWeek(String workingDaysPerWeek) {
        this.workingDaysPerWeek = workingDaysPerWeek;
    }

    public String getMessageForStudents() {
        return messageForStudents;
    }

    public void setMessageForStudents(String messageForStudents) {
        this.messageForStudents = messageForStudents;
    }

    public String getTwelfthPercentage() {
        return twelfthPercentage;
    }

    public void setTwelfthPercentage(String twelfthPercentage) {
        this.twelfthPercentage = twelfthPercentage;
    }

    public String getGraduationPercentage() {
        return graduationPercentage;
    }

    public void setGraduationPercentage(String graduationPercentage) {
        this.graduationPercentage = graduationPercentage;
    }

    public String getBacklogs() {
        return backlogs;
    }

    public void setBacklogs(String backlogs) {
        this.backlogs = backlogs;
    }
}
