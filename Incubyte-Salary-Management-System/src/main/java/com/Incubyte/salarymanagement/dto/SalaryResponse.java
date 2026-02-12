package com.Incubyte.salarymanagement.dto;

public class SalaryResponse {

    private Double grossSalary;
    private Double deductions;
    private Double netSalary;

    public SalaryResponse(Double grossSalary, Double deductions, Double netSalary) {
        this.grossSalary = grossSalary;
        this.deductions = deductions;
        this.netSalary = netSalary;
    }

    public Double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(Double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public Double getDeductions() {
        return deductions;
    }

    public void setDeductions(Double deductions) {
        this.deductions = deductions;
    }

    public Double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(Double netSalary) {
        this.netSalary = netSalary;
    }
}
