package com.example.prog4.repository;

import com.example.prog4.model.core.entity.management.Employee;

import java.util.List;

public interface EmployeRepository {
    Employee findById(String id);
    List<Employee> findAll();
    Employee save(Employee employee);
}
