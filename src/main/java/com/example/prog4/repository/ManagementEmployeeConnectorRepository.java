package com.example.prog4.repository;

import com.example.prog4.model.core.entity.management.Employee;
import com.example.prog4.model.core.exception.NotFoundException;
import com.example.prog4.repository.management.ManagementEmployeeJpaRepository;
import com.example.prog4.repository.model.EmployeeConnector;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ManagementEmployeeConnectorRepository implements EmployeeConnectorRepository {
  private final ManagementEmployeeJpaRepository jpaRepository;

  @Override
  public EmployeeConnector findById(String id) {
    return jpaRepository.findById(id)
        .map(employee ->
            EmployeeConnector.builder()
                .endToEndId(employee.getId())
                .id(null)
                .build()
        )
        .orElseThrow(() -> new NotFoundException("ManagementEmployee(id=" + id + " not found)"));
  }

  @Override
  public EmployeeConnector findByE2EId(String e2eId) {
    return null;
  }

  @Override
  public EmployeeConnector save(Employee employee) {
    var saved = jpaRepository.save(employee);
    return EmployeeConnector.builder().endToEndId(saved.getId()).build();
  }
}
