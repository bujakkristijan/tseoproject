import { ActivatedRoute, Router } from '@angular/router';
import { Test } from './../test';
import { Component, OnInit } from '@angular/core';
import { ProfessorService } from '../professor.service';

@Component({
  selector: 'app-professor-update-test',
  templateUrl: './professor-update-test.component.html',
  styleUrls: ['./professor-update-test.component.css']
})
export class ProfessorUpdateTestComponent implements OnInit {

  testId: number;
  test: Test;
  constructor(private professorService: ProfessorService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.getSelectedTest();
  }

  getSelectedTest(){
    this.testId = this.route.snapshot.params['id'];
    this.professorService.getTestById(this.testId).subscribe(data =>{
      this.test = data;
    });
  }

  onSubmit(){
    this.professorService.updateTest(this.test).subscribe(data =>{
      this.goToMyTestList();
    });
  }

  goToMyTestList(){
    this.router.navigate(['professor-my-test-list']);
  }

}
