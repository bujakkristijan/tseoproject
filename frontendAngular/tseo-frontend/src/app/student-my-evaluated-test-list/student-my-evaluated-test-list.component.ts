import { Component, OnInit } from '@angular/core';
import { StudentService } from '../student.service';
import { UserTest } from '../user-test';

@Component({
  selector: 'app-student-my-evaluated-test-list',
  templateUrl: './student-my-evaluated-test-list.component.html',
  styleUrls: ['./student-my-evaluated-test-list.component.css']
})
export class StudentMyEvaluatedTestListComponent implements OnInit {

  myEvaluatedUserTests: UserTest[];
  constructor(private studentService: StudentService) { }

  ngOnInit(): void {
    this.getMyEvaluatedUserTests();
  }

  getMyEvaluatedUserTests(){
    this.studentService.getMyEvaluatedTestList().subscribe(data =>{
      this.myEvaluatedUserTests = data;
    });
  }

}
