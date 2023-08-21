package com.example.prog4.repository;

import com.example.prog4.model.core.entity.management.Employee;
import com.example.prog4.model.core.exception.NotFoundException;
import com.example.prog4.repository.cnaps.CnapsEmployeeJpaRepository;
import com.example.prog4.repository.model.EmployeeConnector;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class CnapsEmployeeConnectorRepository implements EmployeeConnectorRepository {
  private final CnapsEmployeeJpaRepository jpaRepository;

  @Override
  public EmployeeConnector findById(String id) {
    return null;
  }

  @Override
  public EmployeeConnector findByE2EId(String e2eId) {
    return jpaRepository.findByEndToEndId(e2eId)
        .map(employee ->
            EmployeeConnector.builder()
                .endToEndId(employee.getEndToEndId())
                .cnaps(employee.getCnaps())
                .id(employee.getId())
                .build()
        )
        .orElseThrow(() -> new NotFoundException("CnapsEmployee(e2eId=" + e2eId + " not found)"));
  }

  @Override
  public EmployeeConnector save(Employee employee) {
    return null;
  }
}
