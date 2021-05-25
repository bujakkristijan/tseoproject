import { StudentService } from './../student.service';
import { Component, OnInit } from '@angular/core';
import { UserTest } from '../user-test';

@Component({
  selector: 'app-my-signed-up-test-list',
  templateUrl: './my-signed-up-test-list.component.html',
  styleUrls: ['./my-signed-up-test-list.component.css']
})
export class MySignedUpTestListComponent implements OnInit {

  myUserTestsNotGraded: UserTest[];
  constructor(private studentService: StudentService) { }

  ngOnInit(): void {
    this.getMyUserTestsNotGraded();
  }

  getMyUserTestsNotGraded(){
    this.studentService.getMyUserTestsNotGraded().subscribe(data =>{
      this.myUserTestsNotGraded = data;
    });
  }

}
