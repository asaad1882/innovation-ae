import { Component, OnInit } from '@angular/core';
import { Department } from '../department';
import { DepartmentService } from '../department.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-department',
  templateUrl: './create-department.component.html',
  styleUrls: ['./create-department.component.css']
})
export class CreateDepartmentComponent implements OnInit {
 department: Department = new Department();
 error: any;
  constructor(
    private router: Router, private departmentService: DepartmentService) { }

  ngOnInit(): void {
  }
  saveDepartment(){
   
    this.departmentService.addReference(this.department).subscribe( data =>{
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
    console.log(this.department);
    this.saveDepartment();
  } 

}
