package com.innovationae.employees.dto;

import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.innovationae.employees.utils.UniqueEmail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private long id;
    @NotBlank(message = "Please enter name")
    @Size(min=4, message = "Name should be atleast 4 characters")
    @Size(max=20, message = "Name should not be greater than 20 characters")
    private String firstName;
    @NotBlank(message = "Please enter name")
    @Size(min=4, message = "Name should be atleast 4 characters")
    @Size(max=20, message = "Name should not be greater than 20 characters")
    private String lastName;
    @Email(message = "Please enter valid email", regexp="^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}")
    @NotNull(message = "Please enter email") 
    @UniqueEmail
    private String emailId;
    @NotBlank(message = "Please enter Phone number")   
    @Size(max=20, message = "Phone number should not be greater than 20 characters")
    private String phoneNumber;
    private Date hireDate;
    @NotNull(message = "Please enter salary")
    @Min(value=1000, message = "Salary must be atleast 1000.00")
    @Max(value=10000, message = "Salary should not be greater than 10000.00")
    private double salary;
    private long managerId;
    
    private DepartmentDTO department;
}
