package com.Incubyte.salarymanagement.controller;

import com.Incubyte.salarymanagement.dto.SalaryResponse;
import com.Incubyte.salarymanagement.service.SalaryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/salary")
public class SalaryController {

    private final SalaryService service;

    public SalaryController(SalaryService service) {
        this.service = service;
    }

    @GetMapping("/{employeeId}")
    public SalaryResponse calculate(@PathVariable Long employeeId) {
        return service.calculateSalary(employeeId);
    }
}
