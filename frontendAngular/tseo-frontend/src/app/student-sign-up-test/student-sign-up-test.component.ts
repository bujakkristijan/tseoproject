import { StudentService } from './../student.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Test } from '../test';

@Component({
  selector: 'app-student-sign-up-test',
  templateUrl: './student-sign-up-test.component.html',
  styleUrls: ['./student-sign-up-test.component.css']
})
export class StudentSignUpTestComponent implements OnInit {

  testId: number;
  test: Test = new Test();
  constructor(private route: ActivatedRoute, private router: Router, private studentService: StudentService) { }

  ngOnInit(): void {
    this.getTestIdFromRoute();
    this.getTest();
  }

  getTestIdFromRoute(){
    this.testId = this.route.snapshot.params['id'];
  }
  getTest(){
    this.studentService.getTestById(this.testId).subscribe(data =>{
      this.test = data;
    });
  }

  onSubmit(){
    this.studentService.createUserTest(this.test).subscribe(data =>{
      this.goToMyAvailableTestList();
    });
  }

  goToMyAvailableTestList(){
    this.router.navigate(['my-available-test-list-for-course', this.test.course.id]);
  }

}
