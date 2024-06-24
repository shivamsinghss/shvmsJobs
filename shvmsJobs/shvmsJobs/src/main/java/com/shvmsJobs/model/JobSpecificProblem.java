package com.shvmsJobs.model;

public class JobSpecificProblem {

    private String JobTitle;
    private String preferredLocation;
    private String salary ;

    public JobSpecificProblem(String jobTitle, String preferredLocation, String salary) {
        JobTitle = jobTitle;
        this.preferredLocation = preferredLocation;
        this.salary = salary;
    }

    public String getJobTitle() {
        return JobTitle;
    }

    public void setJobTitle(String jobTitle) {
        JobTitle = jobTitle;
    }

    public String getPreferredLocation() {
        return preferredLocation;
    }

    public void setPreferredLocation(String preferredLocation) {
        this.preferredLocation = preferredLocation;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "JobSpecificProblem{" +
                "JobTitle='" + JobTitle + '\'' +
                ", preferredLocation='" + preferredLocation + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
