package com.Incubyte.salarymanagement.controller;

import com.Incubyte.salarymanagement.dto.EmployeeRequest;
import com.Incubyte.salarymanagement.dto.EmployeeResponse;
import com.Incubyte.salarymanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public EmployeeResponse createEmployee(@RequestBody EmployeeRequest employee) {
        return service.createEmployee(employee);
    }

    @GetMapping("/{id}")
    public EmployeeResponse getEmployeeById(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    @GetMapping
    public List<EmployeeResponse> getAllEmployees() {
        return service.getAllEmployees();
    }

    @PutMapping("/{id}")
    public EmployeeResponse updateEmployee(@PathVariable Long id, @RequestBody EmployeeRequest employee) {
        return service.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
    }
}
