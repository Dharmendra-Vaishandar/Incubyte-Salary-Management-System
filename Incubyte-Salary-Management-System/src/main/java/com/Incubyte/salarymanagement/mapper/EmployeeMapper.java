package com.Incubyte.salarymanagement.mapper;

import com.Incubyte.salarymanagement.dto.EmployeeRequest;
import com.Incubyte.salarymanagement.dto.EmployeeResponse;
import com.Incubyte.salarymanagement.model.Employee;

public class EmployeeMapper {

    public static Employee toEntity(EmployeeRequest dto) {
        Employee employee = new Employee();
        employee.setFullName(dto.getFullName());
        employee.setJobTitle(dto.getJobTitle());
        employee.setCountry(dto.getCountry());
        employee.setSalary(dto.getSalary());
        return employee;
    }

    public static EmployeeResponse toDto(Employee employee) {
        return new EmployeeResponse(
                employee.getId(),
                employee.getFullName(),
                employee.getJobTitle(),
                employee.getCountry(),
                employee.getSalary()
        );
    }
}
