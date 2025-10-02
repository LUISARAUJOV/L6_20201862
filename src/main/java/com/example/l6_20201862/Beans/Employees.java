package com.example.l6_20201862.Beans;

import java.util.ArrayList;
import java.util.Date;

public class Employees {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private Jobs jobId;
    private double salary;
    private double commissionPct;
    private Employees managerId;
    private Departments departmentId;

    private ArrayList<Employees> subordinates;
    private ArrayList<JobHistory> jobHistories;

    public Employees() {}

    public Employees(int employeeId, String firstName, String lastName, String email, String phoneNumber, Date hireDate, Jobs jobId, double salary, double commissionPct, Employees managerId, Departments departmentId) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.jobId = jobId;
        this.salary = salary;
        this.commissionPct = commissionPct;
        this.managerId = managerId;
        this.departmentId = departmentId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Jobs getJobId() {
        return jobId;
    }

    public void setJobId(Jobs jobId) {
        this.jobId = jobId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(double commissionPct) {
        this.commissionPct = commissionPct;
    }

    public Employees getManagerId() {
        return managerId;
    }

    public void setManagerId(Employees managerId) {
        this.managerId = managerId;
    }

    public Departments getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Departments departmentId) {
        this.departmentId = departmentId;
    }

    public ArrayList<Employees> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(ArrayList<Employees> subordinates) {
        this.subordinates = subordinates;
    }

    public ArrayList<JobHistory> getJobHistories() {
        return jobHistories;
    }

    public void setJobHistories(ArrayList<JobHistory> jobHistories) {
        this.jobHistories = jobHistories;
    }
}
