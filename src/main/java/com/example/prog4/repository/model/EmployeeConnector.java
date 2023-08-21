package com.example.prog4.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Builder
@EqualsAndHashCode
@Data
public class EmployeeConnector {
  private String id;
  private String cnaps;
  private String endToEndId;
}
