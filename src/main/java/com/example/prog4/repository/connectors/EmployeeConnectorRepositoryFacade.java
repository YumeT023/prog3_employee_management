package com.example.prog4.repository.connectors;

import com.example.prog4.model.core.entity.management.Employee;
import com.example.prog4.repository.model.EmployeeConnector;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
@AllArgsConstructor
public class EmployeeConnectorRepositoryFacade implements EmployeeConnectorRepository {
  private final CnapsEmployeeConnectorRepository cnapsConnectorRepository;
  private final ManagementEmployeeConnectorRepository managementConnectorRepository;

  @Override
  public EmployeeConnector findById(String id) {
    return managementConnectorRepository.findById(id);
  }

  @Override
  public EmployeeConnector findByE2EId(String e2eId) {
    return cnapsConnectorRepository.findByE2EId(e2eId);
  }

  @Override
  public EmployeeConnector save(Employee employee) {
    return managementConnectorRepository.save(employee);
  }
}
