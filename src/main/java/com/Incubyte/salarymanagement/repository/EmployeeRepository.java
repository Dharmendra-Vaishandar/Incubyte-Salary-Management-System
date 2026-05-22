package com.Incubyte.salarymanagement.repository;

import com.Incubyte.salarymanagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByCountryIgnoreCase(String country);

    List<Employee> findByJobTitleIgnoreCase(String jobTitle);
}
