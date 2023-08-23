package com.example.prog4.repository.jpa.cnaps;

import com.example.prog4.model.core.entity.cnaps.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface CnapsEmployeeJpaRepository extends JpaRepository<Employee, String> {
  Optional<Employee> findByEndToEndId(String endToEndId);
}
