import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { StudentService } from './../student.service';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {

  students: User[];

  constructor(private StudentService: StudentService) { }

  ngOnInit(): void {
    this.getStudents();
  }
    private getStudents(){
      this.StudentService.getStudentsList().subscribe(data => {
        this.students = data;
      })
    }


}
