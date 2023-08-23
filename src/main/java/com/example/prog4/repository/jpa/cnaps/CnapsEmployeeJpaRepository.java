package com.example.prog4.repository.jpa.cnaps;

import com.example.prog4.model.core.entity.cnaps.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CnapsEmployeeJpaRepository extends JpaRepository<Employee, String> {
    @Query(value = "SELECT * FROM employee WHERE end_to_end_id = :id")
    Optional<String> findCnapsNumberByEndToEndId(String id);
}
