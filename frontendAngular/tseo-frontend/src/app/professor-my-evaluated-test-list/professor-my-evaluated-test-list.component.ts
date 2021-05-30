import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProfessorService } from '../professor.service';
import { UserTest } from '../user-test';

@Component({
  selector: 'app-professor-my-evaluated-test-list',
  templateUrl: './professor-my-evaluated-test-list.component.html',
  styleUrls: ['./professor-my-evaluated-test-list.component.css']
})
export class ProfessorMyEvaluatedTestListComponent implements OnInit {

  myEvaluatedUserTests: UserTest[];
  constructor(private professorService: ProfessorService, private router: Router) { }

  ngOnInit(): void {
    this.getMyEvaluatedUserTests();
  }

  getMyEvaluatedUserTests(){
    this.professorService.getMyEvaluatedTestList().subscribe(data =>{
      this.myEvaluatedUserTests = data;
    });
  }

  goToProfessorEvaluateTest(userTestid: number){
    this.router.navigate(['professor-evaluate-user-test', userTestid]);
  }

}
