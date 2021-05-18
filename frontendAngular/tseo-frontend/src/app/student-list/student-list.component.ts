import { AppComponent } from './../app.component';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../user';
import { StudentService } from './../student.service';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {

  students: User[];
  logginUser: User;

  constructor(private loginService: LoginService, private StudentService: StudentService, private router: Router, private appComponent: AppComponent) { }

  ngOnInit(): void {
    this.getStudents();
    this.loginService.getLoggedUser().subscribe(data =>{
      this.logginUser = data;
    });
    //this.appComponent.getLoggedUser();
  }

  private getStudents(){
    this.StudentService.getStudentsList().subscribe(data => {
      this.students = data;
    })
  }
  updateStudent(id: number){
    this.router.navigate(['update-student', id]);
  }

  deleteStudent(id: number){
    this.StudentService.deleteStudent(id).subscribe(data =>{
      console.log(data);
      this.getStudents(); /**kad obrise studenta ide na student list component i ucitava ponovo podatke */
    })
  }

  studentDetails(id: number){
    this.router.navigate(['student-details', id]);
  }

}
