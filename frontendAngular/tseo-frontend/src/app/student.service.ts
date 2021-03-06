import { Payment } from './payment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './user';
import { UserCourse } from './user-course';
import { Course } from './course';
import { Test } from './test';
import { UserTest } from './user-test';

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

  createPayment(payment: Payment):Observable<Object>{
    return this.httpClient.post("http://localhost:8080/payment/addPayment", payment);
  }

  //createStudentCourse(studentCourse: UserCourse): Observable<Object>{
  //  return this.httpClient.post("http://localhost:8080/userCourse/addUserCourse", studentCourse);
  //}

  createStudentCourse(course: Course): Observable<Object>{
      return this.httpClient.post("http://localhost:8080/userCourse/addStudentCourse", course);
    }

    getTestsForCourse(courseDTO: Course):Observable<any>{
      return this.httpClient.post("http://localhost:8080/test/getTestsForCourseNotSignedUp", courseDTO);
    }

    getMyUserTestsNotGraded():Observable<UserTest[]>{
      return this.httpClient.get<UserTest[]>("http://localhost:8080/userTest/getMyUserTestsNotGraded");
     }

     getTestById(id: number):Observable<Test>{

      return this.httpClient.get<Test>(`http://localhost:8080/test/${id}`);
    }

    createUserTest(test: Test):Observable<Object>{
      return this.httpClient.post("http://localhost:8080/userTest/addUserTest", test);
    }

    getMyEvaluatedTestList():Observable<UserTest[]>{
      return this.httpClient.get<UserTest[]>("http://localhost:8080/userTest/getMyEvaluatedUserTestsStudent");
    }
    // za admina
    getUserCoursesByCourseId(courseId: number):Observable<UserCourse[]>{
      return this.httpClient.get<UserCourse[]>(`http://localhost:8080/userCourse/students/${courseId}`);
    }

    getPaymentsByCourseId(courseId: number):Observable<Payment[]>{
      return this.httpClient.get<Payment[]>(`http://localhost:8080/payment/payments/${courseId}`)
    }

    deleteStudentCourse(studentCourseId: number):Observable<Object>{
      return this.httpClient.delete("http://localhost:8080/userCourse/delete/"+ studentCourseId);
    }
}
