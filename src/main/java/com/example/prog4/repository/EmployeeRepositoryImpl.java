package com.example.prog4.repository;

import com.example.prog4.model.core.entity.management.Employee;
import com.example.prog4.repository.management.ManagementEmployeeJpaRepository;
import java.util.List;
import java.util.Optional;
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
    saved.setCnaps(connectorRepository.findByE2EId(saved.getId()).getCnaps());
    return saved;
  }

  @Override
  public Optional<Employee> findById(String id) {
    var connector = connectorRepository.findByE2EId(id);
    log.info("connector {}", connector);
    return jpaRepository.findById(connector.getEndToEndId()).map(employee -> {
      employee.setCnaps(connector.getCnaps());
      return employee;
    });
  }

  @Override
  public List<Employee> findAll() {
    return jpaRepository.findAll()
        .stream().peek(employee -> {
          var cnapsEmployee = connectorRepository.findByE2EId(employee.getId());
          employee.setCnaps(cnapsEmployee.getCnaps());
        }).toList();
  }
}
