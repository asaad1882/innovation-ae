package com.innovationae.employees.service;

import java.util.List;

import com.innovationae.employees.dto.DepartmentDTO;
import com.innovationae.employees.exception.ResourceNotFoundException;


public interface IDepartmentService {
    public List<DepartmentDTO> getAllDepartments();
    public DepartmentDTO getDepartmentById(Long departmentId)
            throws ResourceNotFoundException;
    public DepartmentDTO createDepartment(DepartmentDTO department);
    public DepartmentDTO updateDepartment(Long departmentId,
             DepartmentDTO departmentDetails) throws ResourceNotFoundException;

}
