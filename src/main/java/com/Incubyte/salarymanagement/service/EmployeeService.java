package com.Incubyte.salarymanagement.service;

import com.Incubyte.salarymanagement.dto.EmployeeRequest;
import com.Incubyte.salarymanagement.dto.EmployeeResponse;
import com.Incubyte.salarymanagement.exception.EmployeeNotFoundException;
import com.Incubyte.salarymanagement.mapper.EmployeeMapper;
import com.Incubyte.salarymanagement.model.Employee;
import com.Incubyte.salarymanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // CREATE
    public EmployeeResponse createEmployee(EmployeeRequest requestDto) {
        Employee employee = EmployeeMapper.toEntity(requestDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.toDto(savedEmployee);
    }

    // READ BY ID
    public EmployeeResponse getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
        return EmployeeMapper.toDto(employee);
    }

    // READ ALL
    public List<EmployeeResponse> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(EmployeeMapper::toDto)
                .collect(Collectors.toList());
    }

    // UPDATE
    public EmployeeResponse updateEmployee(Long id, EmployeeRequest requestDto) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));

        existingEmployee.setFullName(requestDto.getFullName());
        existingEmployee.setJobTitle(requestDto.getJobTitle());
        existingEmployee.setCountry(requestDto.getCountry());
        existingEmployee.setSalary(requestDto.getSalary());

        Employee updatedEmployee = employeeRepository.save(existingEmployee);
        return EmployeeMapper.toDto(updatedEmployee);
    }

    // DELETE
    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException(id);
        }
        employeeRepository.deleteById(id);
    }
}

