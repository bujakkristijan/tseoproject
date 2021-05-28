import { ProfessorService } from './../professor.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Test } from '../test';
import { UserTest } from '../user-test';

@Component({
  selector: 'app-professor-signed-up-test-list',
  templateUrl: './professor-signed-up-test-list.component.html',
  styleUrls: ['./professor-signed-up-test-list.component.css']
})
export class ProfessorSignedUpTestListComponent implements OnInit {
  testId: number;
  test: Test = new Test();
  myUserTests: UserTest[];
  constructor(private route: ActivatedRoute, private router: Router, private professorService: ProfessorService) { }

  ngOnInit(): void {
    this.getSelectedTest();
    //this.getMyUserTests();
  }

  getSelectedTest(){
    this.testId = this.route.snapshot.params['id'];
    this.professorService.getTestById(this.testId).subscribe(data =>{
      this.test = data;
      this.getMyUserTests(); // mora ovde da se zove jer ne salje test na back
    });
  }

  getMyUserTests(){
    this.professorService.getUserTestsForTest(this.test).subscribe(data =>{
     this.myUserTests = data;
    });
  }

  goToProfessorEvaluateTest(id: number){
    this.router.navigate(['professor-evaluate-user-test', id]);
  }



}
