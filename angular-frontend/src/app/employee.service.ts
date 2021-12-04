import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable, throwError  } from 'rxjs';
import { Employee } from './employee';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseURL = "http://127.0.0.1:8080/api/v1/employees";

  constructor(private httpClient: HttpClient) { }
  
  getEmployeesList(params:any): Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(`${this.baseURL}`, { params });
  }

  createEmployee(employee: Employee): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, employee).pipe( catchError((err) => {
          console.log('error caught in service')
          console.error(err.error);
 
          //Handle the error here
 
          return throwError(err);
          })
      )
  }

  getEmployeeById(id: number): Observable<Employee>{
    return this.httpClient.get<Employee>(`${this.baseURL}/${id}`);
  }

  updateEmployee(id: number, employee: Employee): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`, employee);
  }

  deleteEmployee(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }
}
