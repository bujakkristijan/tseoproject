import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../user';
import { StudentService } from './../student.service';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {

  students: User[];

  constructor(private StudentService: StudentService, private router: Router) { }

  ngOnInit(): void {
    this.getStudents();
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
