import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../user';
import { StudentService } from './../student.service';
import { Role } from '../role.enum';

@Component({
  selector: 'app-create-student',
  templateUrl: './create-student.component.html',
  styleUrls: ['./create-student.component.css']
})
export class CreateStudentComponent implements OnInit {

  student: User = new User();
  constructor(private studentService: StudentService, private router: Router) { }

  ngOnInit(): void {
  }

  saveStudent(){

    this.student.role = "STUDENT";
    this.studentService.createStudent(this.student).subscribe(data =>{
      console.log(data);
      this.goToStudentList();
    },
    error => console.log(error));
  }

  goToStudentList(){
    this.router.navigate(['/students']);
  }

  onSubmit(){
    console.log(this.student);
    this.saveStudent();
  }



}
