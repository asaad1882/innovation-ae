package com.innovationae.employees.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.innovationae.employees.dto.EmployeeDTO;
import com.innovationae.employees.exception.ResourceNotFoundException;
import com.innovationae.employees.model.Employee;
import com.innovationae.employees.repository.EmployeeRepository;
import com.innovationae.employees.utils.ObjectMapperUtils;

@Service
public class EmployeeService implements IEmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;

    }

    @Override
    public Map<String, Object> getAllEmployees(String firstName, int page, int size) {

        Pageable paging = PageRequest.of(page, size);
        Page<Employee> pageEmps;
        if (firstName == null) {
            pageEmps = employeeRepository.findAll(paging);
        } else {
            pageEmps = employeeRepository.findByFirstNameContaining(firstName, paging);
        }
        List<Employee> employees = pageEmps.getContent();

        Map<String, Object> response = new HashMap<>();
        response.put("employees", ObjectMapperUtils.mapAll(employees, EmployeeDTO.class));
        response.put("currentPage", pageEmps.getNumber());
        response.put("totalItems", pageEmps.getTotalElements());
        response.put("totalPages", pageEmps.getTotalPages());

        return response;
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = ObjectMapperUtils.map(employeeDTO, Employee.class);
        Employee createdEmployee = employeeRepository.save(employee);
        return ObjectMapperUtils.map(createdEmployee, EmployeeDTO.class);

    }

    @Override
    public EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO employeeDetails) throws ResourceNotFoundException{
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employee.setEmailId(employeeDetails.getEmailId());
        employee.setLastName(employeeDetails.getLastName());
        employee.setFirstName(employeeDetails.getFirstName());
        final Employee updatedEmployee = employeeRepository.save(employee);
        return ObjectMapperUtils.map(updatedEmployee, EmployeeDTO.class);
    }

    @Override
    public Map<String, Boolean> deleteEmployee(Long employeeId) throws ResourceNotFoundException {
            Employee employee = employeeRepository.findById(employeeId)
                            .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

            employeeRepository.delete(employee);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
        return response;
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        return ObjectMapperUtils.map(employee, EmployeeDTO.class);
    }

}
