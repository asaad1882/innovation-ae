package com.innovationae.employees.repository;
import org.springframework.stereotype.Repository;

import com.innovationae.employees.model.Employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    Employee findByEmailId(String emailId);
    Page<Employee> findByFirstNameContaining(String firstName, Pageable pageable);
}

