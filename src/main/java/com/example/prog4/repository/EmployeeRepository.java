package com.example.prog4.repository;

import com.example.prog4.model.core.entity.management.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
  Employee save(Employee employee);

  Employee findById(String id);

  List<Employee> findAll();
}
