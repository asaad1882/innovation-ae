import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


import { Department } from './department';

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {
  private baseUrlRef='http://127.0.0.1:8080/api/v1/department';
  constructor(private http:HttpClient) { }

getAllDepartments():Observable<Department[]>{
 return this.http.get<Department[]>(this.baseUrlRef);
 
}

 addReference(reference:Department):Observable<any>{
   return this.http.post(`${this.baseUrlRef}`,reference,{responseType: 'text'});
 }
 updateDepartment(id:number,reference:Department):Observable<any>{
   return this.http.put(`${this.baseUrlRef}/${id}`,reference,{responseType: 'text'});
 }
 removeDepartment(id:number):Observable<any>{
   return this.http.delete(`${this.baseUrlRef}/${id}`,{responseType: 'text'});
 }
 getDepartmentById(id:number):Observable<Department>{
   return this.http.get<Department>(`${this.baseUrlRef}/${id}`);
 }
}


