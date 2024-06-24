package com.shvmsJobs.model;

import java.util.List;

public class AdditionalInformation {

    private String username;

    private List<Qualification> qualificationList;;

    private JobSpecificProblem jobSpecificProblem;

    public AdditionalInformation(String username, List<Qualification> qualificationList, JobSpecificProblem jobSpecificProblem) {
        this.username = username;
        this.qualificationList = qualificationList;
        this.jobSpecificProblem = jobSpecificProblem;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Qualification> getQualificationList() {
        return qualificationList;
    }

    public void setQualificationList(List<Qualification> qualificationList) {
        this.qualificationList = qualificationList;
    }

    public JobSpecificProblem getJobSpecificProblem() {
        return jobSpecificProblem;
    }

    public void setJobSpecificProblem(JobSpecificProblem jobSpecificProblem) {
        this.jobSpecificProblem = jobSpecificProblem;
    }

    @Override
    public String toString() {
        return "AdditionalInformation{" +
                "username='" + username + '\'' +
                ", qualificationList=" + qualificationList +
                ", jobSpecificProblem=" + jobSpecificProblem +
                '}';
    }
}
