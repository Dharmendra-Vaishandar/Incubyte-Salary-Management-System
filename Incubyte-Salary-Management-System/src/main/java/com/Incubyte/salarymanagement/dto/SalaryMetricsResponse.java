package com.Incubyte.salarymanagement.dto;

public class SalaryMetricsResponse {

    private Double minimumSalary;
    private Double maximumSalary;
    private Double averageSalary;

    public SalaryMetricsResponse(Double minimumSalary,
                                 Double maximumSalary,
                                 Double averageSalary) {
        this.minimumSalary = minimumSalary;
        this.maximumSalary = maximumSalary;
        this.averageSalary = averageSalary;
    }
}
