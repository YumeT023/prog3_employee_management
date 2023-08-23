package com.example.prog4.repository.implementation;

import com.example.prog4.model.core.entity.management.Employee;
import com.example.prog4.model.core.exception.NotFoundException;
import com.example.prog4.repository.EmployeeRepository;
import com.example.prog4.repository.jpa.cnaps.CnapsEmployeeJpaRepository;
import com.example.prog4.repository.jpa.management.ManagementEmployeeJpaRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {
  private final ManagementEmployeeJpaRepository managementJpaRepository;
  private final CnapsEmployeeJpaRepository cnapsJpaRepository;

  @Override
  public Employee findById(String id) {
    var employee = managementJpaRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("ManagementEmployee(id=" + id + ") not found"));
    return combineEmployee(employee);
  }

  @Override
  public Employee save(Employee employee) {
    return managementJpaRepository.save(employee);
  }

  @Override
  public List<Employee> findAll() {
    return managementJpaRepository.findAll()
        .stream().map(this::combineEmployee)
        .toList();
  }

  private Employee combineEmployee(Employee employee) {
    var cnapsNumber = cnapsJpaRepository.findByEndToEndId(employee.getId())
        .map(com.example.prog4.model.core.entity.cnaps.Employee::getEndToEndId)
        .orElse(null);
    employee.setCnaps(cnapsNumber);
    return employee;
  }
}
