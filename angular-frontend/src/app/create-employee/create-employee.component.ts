import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { DepartmentService } from '../department.service';
import { Router } from '@angular/router';
import { Department } from '../department';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

  employee: Employee = new Employee();
  departments: Department[]=[];
  response: any;
  error: any;
  
  constructor(private employeeService: EmployeeService,
    private router: Router, private departmentService: DepartmentService) { }

  ngOnInit(): void {
    this.error=null;
    this.departmentService.getAllDepartments().subscribe(data=>{
       console.log(data);
      this.departments=data
    },
    error => {console.log(error);
      this.error=error;
    });
      
    
  }

  saveEmployee(){
    this.error=null;
    this.employeeService.createEmployee(this.employee).subscribe( data =>{
      console.log(data);
      this.goToEmployeeList();
    },
    error => {console.log(error)
      if(error.error && error.error.errors){
        var errorList=error.error.errors;
       this.error="<ul>\n" +
        errorList.toString().replace(/\b\d+\.\s+(.+?)\s*(?=\b\d+\. |\s*$)/g, "<li> $1 </li>\n") +
        "</ul>\n";;
      }
    });
  }

  goToEmployeeList(){
    this.router.navigate(['/employees']);
  }
  
  onSubmit(){
    console.log(this.employee);
    this.saveEmployee();
  }
}
