package com.innovationae.employees.dto;



import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    private long id;
    @NotBlank(message = "Please enter name")
    @Size(min=2, message = "Name should be atleast 4 characters")
    @Size(max=20, message = "Name should not be greater than 20 characters")
    private String departmentName;
    private long managerId;
    
}
