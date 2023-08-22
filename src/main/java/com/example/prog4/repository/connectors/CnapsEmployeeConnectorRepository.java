package com.example.prog4.repository.connectors;

import com.example.prog4.model.core.entity.management.Employee;
import com.example.prog4.model.core.exception.NotFoundException;
import com.example.prog4.model.core.mapper.EmployeeMapper;
import com.example.prog4.repository.jpa.cnaps.CnapsEmployeeJpaRepository;
import com.example.prog4.repository.model.EmployeeConnector;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
@Slf4j
public class CnapsEmployeeConnectorRepository implements EmployeeConnectorRepository {
  private final CnapsEmployeeJpaRepository jpaRepository;
  private final EmployeeMapper mapper;
  private final static String NOT_IMPLEMENTED = "NotImplemented: only 'findByE2E_Id' is";

  @Override
  public EmployeeConnector findById(String id) {
    throw new NotImplementedException(NOT_IMPLEMENTED);
  }

  @Override
  public EmployeeConnector findByE2EId(String e2eId) {
    return jpaRepository.findByEndToEndId(e2eId)
        .map(employee -> mapper.toConnector(employee, e2eId))
        .orElse(null);
  }

  @Override
  public EmployeeConnector save(Employee employee) {
    throw new NotImplementedException(NOT_IMPLEMENTED);
  }
}
