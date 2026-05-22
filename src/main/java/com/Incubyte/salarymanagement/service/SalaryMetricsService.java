package com.Incubyte.salarymanagement.service;

import com.Incubyte.salarymanagement.dto.SalaryMetricsResponse;
import com.Incubyte.salarymanagement.model.Employee;
import com.Incubyte.salarymanagement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
public class SalaryMetricsService {

    private final EmployeeRepository repository;

    public SalaryMetricsService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public SalaryMetricsResponse byCountry(String country) {
        List<Employee> employees = repository.findByCountryIgnoreCase(country);

        DoubleSummaryStatistics stats = employees.stream()
                .mapToDouble(Employee::getSalary)
                .summaryStatistics();

        return new SalaryMetricsResponse(
                stats.getMin(),
                stats.getMax(),
                stats.getAverage()
        );
    }

    public double averageByJobTitle(String jobTitle) {
        return repository.findByJobTitleIgnoreCase(jobTitle)
                .stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
    }
}

