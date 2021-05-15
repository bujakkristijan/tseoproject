import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Course } from './course';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  private baseUrl = "http://localhost:8080/course/getCourses";
  private dataBaseUrl = "http://localhost:8080/course";

  constructor(private httpClient: HttpClient) { }

  getCoursesList(){
    return this.httpClient.get<Course[]>(`${this.baseUrl}`);
  }

  getCourseById(id: number):Observable<Course>{
    return this.httpClient.get<Course>(`${this.dataBaseUrl}/${id}`);
  }

  updateCourse(course: Course):Observable<Object>{
    return this.httpClient.put("http://localhost:8080/course/edit", course);
  }

  createCourse(course: Course):Observable<Object>{
    return this.httpClient.post("http://localhost:8080/course/addCourse", course);
  }

  deleteCourse(id: number):Observable<Object>{
    return this.httpClient.delete("http://localhost:8080/course/delete/"+id);
  }
}
