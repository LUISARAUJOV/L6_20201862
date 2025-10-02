package com.example.l6_20201862.Beans;

import java.util.ArrayList;

public class Departments {
    private int departmentId;
    private String departmentName;
    private Employees managerId;
    private Locations locationId;

    private ArrayList<Employees> employees;
    private ArrayList<JobHistory> jobHistories;

    public Departments() {}

    public Departments(int departmentId, String departmentName, Employees managerId, Locations locationId) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.managerId = managerId;
        this.locationId = locationId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Employees getManagerId() {
        return managerId;
    }

    public void setManagerId(Employees managerId) {
        this.managerId = managerId;
    }

    public Locations getLocationId() {
        return locationId;
    }

    public void setLocationId(Locations locationId) {
        this.locationId = locationId;
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