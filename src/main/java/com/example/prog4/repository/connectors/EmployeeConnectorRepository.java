package com.example.prog4.repository.connectors;

import com.example.prog4.model.core.entity.management.Employee;
import com.example.prog4.repository.model.EmployeeConnector;

public interface EmployeeConnectorRepository {
  EmployeeConnector findById(String id);

  EmployeeConnector findByE2EId(String e2eId);

  EmployeeConnector save(Employee employee);
}
