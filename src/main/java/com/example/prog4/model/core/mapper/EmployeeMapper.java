package com.example.prog4.model.core.mapper;

import com.example.prog4.model.core.entity.management.Employee;
import com.example.prog4.repository.model.EmployeeConnector;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EmployeeMapper {
  public EmployeeConnector toConnector(Employee domain) {
    return EmployeeConnector.builder()
        .id(domain.getId())
        .endToEndId(domain.getId())
        .cnaps(domain.getCnaps())
        .build();
  }

  public EmployeeConnector toConnector(com.example.prog4.model.core.entity.cnaps.Employee domain, String e2eId) {
    return EmployeeConnector.builder()
        .id(domain.getId())
        .endToEndId(e2eId)
        .cnaps(domain.getCnaps())
        .build();
  }
}
