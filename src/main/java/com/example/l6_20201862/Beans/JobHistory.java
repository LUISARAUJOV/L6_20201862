package com.example.l6_20201862.Beans;

import java.util.Date;

public class JobHistory {
    private Employees employeeId;
    private Date startDate;
    private Date endDate;
    private Jobs jobId;
    private Departments departmentId;

    public JobHistory() {}

    public JobHistory(Employees employeeId, Date startDate, Date endDate, Jobs jobId, Departments departmentId) {
        this.employeeId = employeeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.jobId = jobId;
        this.departmentId = departmentId;
    }

    public Employees getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employees employeeId) {
        this.employeeId = employeeId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Jobs getJobId() {
        return jobId;
    }

    public void setJobId(Jobs jobId) {
        this.jobId = jobId;
    }

    public Departments getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Departments departmentId) {
        this.departmentId = departmentId;
    }
}