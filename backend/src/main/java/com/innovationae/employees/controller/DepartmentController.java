package com.innovationae.employees.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innovationae.employees.dto.DepartmentDTO;
import com.innovationae.employees.exception.ResourceNotFoundException;
import com.innovationae.employees.service.IDepartmentService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {
    
    private IDepartmentService departmentService;
    @Autowired
    public DepartmentController(IDepartmentService departmentService) {
        this.departmentService=departmentService;
    }
    @GetMapping()
    public List<DepartmentDTO> getAllDepartments() {
            return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable(value = "id") Long departmentId)
                    throws ResourceNotFoundException {
        
            return ResponseEntity.ok().body(departmentService.getDepartmentById(departmentId));
    }

    @PostMapping()
    public DepartmentDTO createDepartment(@Valid @RequestBody DepartmentDTO department) {
            return departmentService.createDepartment(department);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDTO> updateDepartment(@PathVariable(value = "id") Long departmentId,
                    @Valid @RequestBody DepartmentDTO departmentDetails) throws ResourceNotFoundException {
          
            return ResponseEntity.ok(departmentService.updateDepartment(departmentId, departmentDetails));
    }

    

}
