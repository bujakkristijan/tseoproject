import { UserCourse } from './user-course';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Course } from './course';
import { Test } from './test';
import { User } from './user';
import { UserTest } from './user-test';

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

  createTest(test: Test): Observable<Object>{
    return this.httpClient.post("http://localhost:8080/test/addTest", test);
  }

  getMyTestList():Observable<Test[]>{
    return this.httpClient.get<Test[]>("http://localhost:8080/test/getMyTests");
  }

  getTestById(id: number):Observable<Test>{

    return this.httpClient.get<Test>(`http://localhost:8080/test/${id}`);
  }

  getUserTestsForTest(test: Test):Observable<any>{ // mora any, buni se u ts fajlu komponente
    return this.httpClient.post("http://localhost:8080/userTest/getUserTestsProfessor", test)
  }

  getUserTestById(id: number):Observable<UserTest>{

    return this.httpClient.get<UserTest>(`http://localhost:8080/userTest/${id}`);
  }

  updateUserTest(userTest: UserTest): Observable<Object>{
    return this.httpClient.put("http://localhost:8080/userTest/evaluate", userTest);
  }

  getMyEvaluatedTestList():Observable<UserTest[]>{
    return this.httpClient.get<UserTest[]>("http://localhost:8080/userTest/getAllEvaluatedUserTests");
  }

  getUserCoursesByCourseId(courseId: number):Observable<UserCourse[]>{
    return this.httpClient.get<UserCourse[]>(`http://localhost:8080/userCourse/professors/${courseId}`); // pored 1 znak mora
  }

  deleteProfessorCourse(professorCourseId: number):Observable<Object>{
    return this.httpClient.delete("http://localhost:8080/userCourse/delete/"+ professorCourseId);
  }



}
