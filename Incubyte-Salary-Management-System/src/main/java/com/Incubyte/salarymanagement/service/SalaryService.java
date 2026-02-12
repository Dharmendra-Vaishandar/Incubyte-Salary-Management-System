package com.Incubyte.salarymanagement.service;

import com.Incubyte.salarymanagement.dto.SalaryResponse;
import com.Incubyte.salarymanagement.exception.EmployeeNotFoundException;
import com.Incubyte.salarymanagement.model.Employee;
import com.Incubyte.salarymanagement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class SalaryService {

    private final EmployeeRepository repository;

    public SalaryService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public SalaryResponse calculateSalary(Long employeeId) {
        Employee emp = repository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException(employeeId));

        double deductionRate = switch (emp.getCountry().toLowerCase()) {
            case "india" -> 0.10;
            case "united states" -> 0.12;
            default -> 0.0;
        };

        double deductions = emp.getSalary() * deductionRate;
        double netSalary = emp.getSalary() - deductions;

        return new SalaryResponse(emp.getSalary(), deductions, netSalary);
    }
}
