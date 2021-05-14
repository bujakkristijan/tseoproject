import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class ProfessorService {

  private baseUrl = "http://localhost:8080/api/admin/getProfessors";
  private dataBaseUrl = "http://localhost:8080/api/admin";

  constructor(private httpClient: HttpClient) { }

  getProfessorsList(): Observable<User[]>{
    return this.httpClient.get<User[]>(`${this.baseUrl}`);
  }

  createProfessor(professor: User): Observable<Object>{
    return this.httpClient.post("http://localhost:8080/api/admin/addUser", professor);
  }

  getProfessorById(id: number):Observable<User>{

    return this.httpClient.get<User>(`${this.dataBaseUrl}/${id}`);
  }

  updateProfessor(professor: User):Observable<Object>{
    return this.httpClient.put("http://localhost:8080/api/admin/edit", professor);
  }

  deleteProfessor(id: number): Observable<Object>{
    return this.httpClient.delete("http://localhost:8080/api/admin/delete/"+id);
  }
}
