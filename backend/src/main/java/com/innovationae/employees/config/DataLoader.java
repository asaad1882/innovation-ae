package com.innovationae.employees.config;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.innovationae.employees.model.Department;
import com.innovationae.employees.model.Employee;
import com.innovationae.employees.repository.DepartmentRepository;
import com.innovationae.employees.repository.EmployeeRepository;

@Component
public class DataLoader implements ApplicationRunner {

    private DepartmentRepository departmentRepository;
    private EmployeeRepository employeeRepository;

    @Autowired
    public DataLoader(DepartmentRepository departmentRepository,EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository=employeeRepository;
    }

    public void run(ApplicationArguments args) {
        departmentRepository.deleteAll();
        employeeRepository.deleteAll();
        departmentRepository.save(new Department(1,"IT",1));
        departmentRepository.save(new Department(2,"HR",1));
        departmentRepository.save(new Department(3,"Finical",1));
        departmentRepository.save(new Department(4,"Marketing",1));
        employeeRepository.save(new Employee(1, "Test","Test","t@t.com","12345",new Date(2021, 12, 4),1000.00,1L, new Department(1,"Test",1)));
        employeeRepository.save(new Employee(2, "Test","Test","t1@t.com","12345",new Date(2021, 12, 4),1000.00,1L, new Department(1,"Test",1)));
        employeeRepository.save(new Employee(3, "Test","Test","t2@t.com","12345",new Date(2021, 12, 4),1000.00,1L, new Department(1,"Test",1)));
        employeeRepository.save(new Employee(4, "Test","Test","t3@t.com","12345",new Date(2021, 12, 4),1000.00,1L, new Department(1,"Test",1)));
        employeeRepository.save(new Employee(5, "Test","Test","t4@t.com","12345",new Date(2021, 12, 4),1000.00,1L, new Department(1,"Test",1)));
        employeeRepository.save(new Employee(6, "Test","Test","t5@t.com","12345",new Date(2021, 12, 4),1000.00,1L, new Department(1,"Test",1)));
    }
}