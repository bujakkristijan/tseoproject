import { ProfessorService } from './../professor.service';
import { Component, OnInit } from '@angular/core';
import { Test } from '../test';
import { Router } from '@angular/router';

@Component({
  selector: 'app-professor-my-test-list',
  templateUrl: './professor-my-test-list.component.html',
  styleUrls: ['./professor-my-test-list.component.css']
})
export class ProfessorMyTestListComponent implements OnInit {


  myTests: Test[];
  constructor(private professorService: ProfessorService, private router: Router) { }

  ngOnInit(): void {
    this.getMyTestList();

  }

  getMyTestList(){
    this.professorService.getMyTestList().subscribe(data =>{
      this.myTests = data;
    });
  }

  goToSignedUpTests(id: number){
    this.router.navigate(['professor-signed-up-test-list', id]);
  }

}
