package com.example.prog4.repository;

import com.example.prog4.model.core.entity.management.Employee;
import com.example.prog4.model.core.exception.NotFoundException;
import com.example.prog4.repository.jpa.cnaps.CnapsEmployeeJpaRepository;
import com.example.prog4.repository.jpa.management.ManagementEmployeeJpaRepository;

import java.util.List;
import java.util.Optional;

public class RepositoryImpl implements EmployeRepository{
    private ManagementEmployeeJpaRepository managementEmployeeJpaRepository;
    private CnapsEmployeeJpaRepository cnapsEmployeeJpaRepositoryRepository;

    @Override
    public Employee findById(String id) {
        Employee employee = managementEmployeeJpaRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found id=" + id));
        Optional<String> cnapsEmployee = cnapsEmployeeJpaRepositoryRepository.findCnapsNumberByEndToEndId(employee.getId());
        employee.setCnaps(cnapsEmployee.orElse(null));

        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        return managementEmployeeJpaRepository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return managementEmployeeJpaRepository.findAll();
    }
}
