import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private baseUrl = "http://localhost:8080/api/admin/getStudents";
  constructor(private httpClient: HttpClient) { }

  getStudentsList(): Observable<User[]>{
    return this.httpClient.get<User[]>(`${this.baseUrl}`);
  }
}
