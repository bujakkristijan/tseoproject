import { ProfessorService } from './../professor.service';
import { Component, OnInit } from '@angular/core';
import { Test } from '../test';

@Component({
  selector: 'app-professor-my-test-list',
  templateUrl: './professor-my-test-list.component.html',
  styleUrls: ['./professor-my-test-list.component.css']
})
export class ProfessorMyTestListComponent implements OnInit {

  myTests: Test[];
  constructor(private professorService: ProfessorService) { }

  ngOnInit(): void {
    this.getMyTestList();

  }

  getMyTestList(){
    this.professorService.getMyTestList().subscribe(data =>{
      this.myTests = data;
    });
  }

}
