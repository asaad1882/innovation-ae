import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';
import { ActivatedRoute, Router } from '@angular/router';
import { Department } from '../department';
import { DepartmentService } from '../department.service';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {

  id: number;
  employee: Employee = new Employee();
  departments: Department[]=[];
   error: any;
  constructor(private employeeService: EmployeeService,
    private route: ActivatedRoute,
    private router: Router, private  departmentService: DepartmentService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.employeeService.getEmployeeById(this.id).subscribe(data => {
      this.employee = data;
    }, error => console.log(error));
     this.departmentService.getAllDepartments().subscribe(data=>{
       console.log(data);
      this.departments=data
    },
    error => console.log(error));

  }

  onSubmit(){
    this.employeeService.updateEmployee(this.id, this.employee).subscribe( data =>{
      this.goToEmployeeList();
    }
     , error => {console.log(error)
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
}
