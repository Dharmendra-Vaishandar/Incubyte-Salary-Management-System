package com.Incubyte.salarymanagement.dto;

public class EmployeeResponse {
    private Long id;
    private String fullName;
    private String jobTitle;
    private String country;
    private Double salary;

    public EmployeeResponse(Long id, String fullName, String jobTitle,
                            String country, Double salary) {
        this.id = id;
        this.fullName = fullName;
        this.jobTitle = jobTitle;
        this.country = country;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
