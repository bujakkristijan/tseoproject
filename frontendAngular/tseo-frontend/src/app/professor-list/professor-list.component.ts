import { ProfessorService } from './../professor.service';
import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-professor-list',
  templateUrl: './professor-list.component.html',
  styleUrls: ['./professor-list.component.css']
})
export class ProfessorListComponent implements OnInit {

  professors: User[];
  constructor(private professorService: ProfessorService, private router: Router) { }

  ngOnInit(): void {
    this.getProfessors();
  }

  private getProfessors(){
    this.professorService.getProfessorsList().subscribe(data => {
      this.professors = data;
    })
  }

  goToCreateProfessor(){ // ne znam zasto more public da stoji, nece kad je private
    this.router.navigate(['create-professor']);
  }

  updateProfessor(id: number){
    this.router.navigate(['update-professor', id]);
  }

  deleteProfessor(id: number){
    this.professorService.deleteProfessor(id).subscribe(data =>{
      this.getProfessors();
    });
    this.getProfessors();
  }



}
