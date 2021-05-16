import { UserCourse } from './user-course';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProfessorCourseService {

  //private baseUrl = "http://localhost:8080/api/admin/getProfessors";
  //private dataBaseUrl = "http://localhost:8080/api/admin";

  constructor(private httpClient: HttpClient) { }

  getProfessorCourseList(): Observable<UserCourse[]>{
    return this.httpClient.get<UserCourse[]>("http://localhost:8080/userCourse/getProfessorsOnCourses");
  }

  createProfessorCourse(professorCourse: UserCourse): Observable<Object>{
    return this.httpClient.post("http://localhost:8080/userCourse/addUserCourse", professorCourse);
  }

  deleteProfessorCourse(id: number){
    return this.httpClient.delete("http://localhost:8080/userCourse/delete/"+id);

    }

}
