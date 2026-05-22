package com.Incubyte.salarymanagement.controller;

import com.Incubyte.salarymanagement.dto.SalaryMetricsResponse;
import com.Incubyte.salarymanagement.service.SalaryMetricsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metrics")
public class SalaryMetricsController {

    private final SalaryMetricsService service;

    public SalaryMetricsController(SalaryMetricsService service) {
        this.service = service;
    }

    @GetMapping("/country/{country}")
    public SalaryMetricsResponse byCountry(@PathVariable String country) {
        return service.byCountry(country);
    }

    @GetMapping("/job-title/{jobTitle}")
    public double byJobTitle(@PathVariable String jobTitle) {
        return service.averageByJobTitle(jobTitle);
    }
}
