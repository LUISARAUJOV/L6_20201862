package com.example.l6_20201862.Beans;

import java.util.ArrayList;

public class Jobs {
    private String jobId;
    private String jobTitle;
    private int minSalary;
    private int maxSalary;

    private ArrayList<Employees> employees;
    private ArrayList<JobHistory> jobHistories;

    public Jobs() {}

    public Jobs(String jobId, String jobTitle, int minSalary, int maxSalary) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public ArrayList<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employees> employees) {
        this.employees = employees;
    }

    public ArrayList<JobHistory> getJobHistories() {
        return jobHistories;
    }

    public void setJobHistories(ArrayList<JobHistory> jobHistories) {
        this.jobHistories = jobHistories;
    }
}
