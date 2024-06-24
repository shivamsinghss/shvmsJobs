package com.shvmsJobs.model;

public class Qualification {

    private String degreeName;

    private String institutionName;

    private String yearOfPassing;

    private String percentage;

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getYearOfPassing() {
        return yearOfPassing;
    }

    public void setYearOfPassing(String yearOfPassing) {
        this.yearOfPassing = yearOfPassing;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Qualification{" +
                "degreeName='" + degreeName + '\'' +
                ", institutionName='" + institutionName + '\'' +
                ", yearOfPassing='" + yearOfPassing + '\'' +
                ", percentage='" + percentage + '\'' +
                '}';
    }
}
