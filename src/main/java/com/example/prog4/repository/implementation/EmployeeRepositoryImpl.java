package com.example.prog4.repository.implementation;

import com.example.prog4.model.core.entity.management.Employee;
import com.example.prog4.model.core.exception.NotFoundException;
import com.example.prog4.repository.connectors.EmployeeConnectorRepository;
import com.example.prog4.repository.EmployeeRepository;
import com.example.prog4.repository.jpa.management.ManagementEmployeeJpaRepository;
import com.example.prog4.repository.model.EmployeeConnector;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
@Slf4j
public class EmployeeRepositoryImpl implements EmployeeRepository {
  private final EmployeeConnectorRepository connectorRepository;
  private final ManagementEmployeeJpaRepository jpaRepository;

  @Override
  public Employee save(Employee employee) {
    var saved = jpaRepository.save(employee);
    return combineConnector(connectorRepository.findByE2EId(saved.getId()), saved);
  }

  @Override
  public Employee findById(String id) {
    var employee = connectorRepository.findById(id);
    return convertConnector(connectorRepository.findByE2EId(employee.getId()));
  }

  @Override
  public List<Employee> findAll() {
    return jpaRepository.findAll()
        .stream()
        .map(employee -> combineConnector(connectorRepository.findByE2EId(employee.getId()), employee))
        .toList();
  }

  private Employee convertConnector(EmployeeConnector connector) {
    return jpaRepository.findById(connector.getEndToEndId())
        .map(employee -> combineConnector(connector, employee))
        .orElseThrow(() -> new NotFoundException("ManagementEmployee(id=" +
            connector.getEndToEndId() + ") not found"));
  }

  private Employee combineConnector(EmployeeConnector connector, Employee employee) {
    return employee.toBuilder()
        .cnaps(connector.getCnaps())
        .build();
  }
}
