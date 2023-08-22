package com.example.prog4.repository.jpa.management;

import com.example.prog4.model.core.entity.management.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagementEmployeeJpaRepository extends JpaRepository<Employee, String> {
}
