package com.innovationae.employees.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovationae.employees.dto.DepartmentDTO;
import com.innovationae.employees.exception.ResourceNotFoundException;
import com.innovationae.employees.model.Department;
import com.innovationae.employees.repository.DepartmentRepository;
import com.innovationae.employees.utils.ObjectMapperUtils;

@Service
public class DepartmentService implements IDepartmentService {

    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {

        return ObjectMapperUtils.mapAll(departmentRepository.findAll(), DepartmentDTO.class);
    }

    @Override
    public DepartmentDTO getDepartmentById(Long departmentId) throws ResourceNotFoundException {
        Department department = departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Department not found for this id :: " + departmentId));
        return ObjectMapperUtils.map(department, DepartmentDTO.class);
    }

    @Override
    public DepartmentDTO createDepartment(DepartmentDTO department) {
        Department createdDepartment = departmentRepository.save(ObjectMapperUtils.map(department, Department.class));
        return ObjectMapperUtils.map(createdDepartment, DepartmentDTO.class);
    }

    @Override
    public DepartmentDTO updateDepartment(Long departmentId, DepartmentDTO departmentDetails)
            throws ResourceNotFoundException {
        Department department = departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("department not found for this id :: " + departmentId));

        department.setDepartmentName(departmentDetails.getDepartmentName());

        final Department updatedDepartment = departmentRepository.save(department);
        return ObjectMapperUtils.map(updatedDepartment, DepartmentDTO.class);
    }

}
