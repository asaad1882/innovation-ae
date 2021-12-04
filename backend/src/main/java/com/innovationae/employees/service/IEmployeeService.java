package com.innovationae.employees.service;


import java.util.Map;

import com.innovationae.employees.dto.EmployeeDTO;
import com.innovationae.employees.exception.ResourceNotFoundException;


public interface IEmployeeService {
    public Map<String, Object> getAllEmployees( String firstName,
             int page,
            int size);
    public EmployeeDTO createEmployee(EmployeeDTO employee); 
    public EmployeeDTO updateEmployee(Long employeeId,
            EmployeeDTO employeeDetails)throws ResourceNotFoundException; 
    public Map<String, Boolean> deleteEmployee( Long employeeId)
            throws ResourceNotFoundException;
    public EmployeeDTO getEmployeeById(Long employeeId)
            throws ResourceNotFoundException;
}
