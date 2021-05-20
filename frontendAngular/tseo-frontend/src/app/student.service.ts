import { Payment } from './payment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private baseUrl = "http://localhost:8080/api/admin/getStudents";
  private dataBaseUrl = "http://localhost:8080/api/admin";

  constructor(private httpClient: HttpClient) { }

  getStudentsList(): Observable<User[]>{
    return this.httpClient.get<User[]>(`${this.baseUrl}`);
  }

  createStudent(student: User): Observable<Object>{
    return this.httpClient.post("http://localhost:8080/api/admin/addUser", student);
  }

  getStudentById(id: number):Observable<User>{

    return this.httpClient.get<User>(`${this.dataBaseUrl}/${id}`);
  }

  updateStudent(student: User):Observable<Object>{
    return this.httpClient.put("http://localhost:8080/api/admin/edit", student);
  }

  deleteStudent(id: number): Observable<Object>{
    return this.httpClient.delete("http://localhost:8080/api/admin/delete/"+id);
  }

  getMyPaymentList():Observable<Payment[]>{
    return this.httpClient.get<Payment[]>("http://localhost:8080/payment/getMyPayments");
  }
}
