package com.innovationae.employees.controller;

import java.util.Map;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.innovationae.employees.dto.EmployeeDTO;
import com.innovationae.employees.exception.ResourceNotFoundException;
import com.innovationae.employees.service.IEmployeeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    private IEmployeeService employeeService;

    @Autowired
    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<Map<String, Object>> getAllEmployees(@RequestParam(required = false)  String firstName,
            @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size) {
        return new ResponseEntity<>(employeeService.getAllEmployees(firstName, page, size), HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {

        return ResponseEntity.ok().body(employeeService.getEmployeeById(employeeId));
    }

    @PostMapping("/employees")
    public EmployeeDTO createEmployee(@Valid @RequestBody EmployeeDTO employee) {
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable(value = "id") Long employeeId,
            @Valid @RequestBody EmployeeDTO employeeDetails) throws ResourceNotFoundException {
       
        return ResponseEntity.ok(employeeService.updateEmployee(employeeId, employeeDetails));
    }

    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
       
        return employeeService.deleteEmployee(employeeId);
    }
}
