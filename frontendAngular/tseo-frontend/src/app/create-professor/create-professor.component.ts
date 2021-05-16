import { ProfessorService } from './../professor.service';
import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { Role } from '../role.enum';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-professor',
  templateUrl: './create-professor.component.html',
  styleUrls: ['./create-professor.component.css']
})
export class CreateProfessorComponent implements OnInit {

  professor: User = new User();
  constructor(private professorService: ProfessorService, private router: Router) { }

  ngOnInit(): void {
    this.professor.role = Role.PROFESSOR; // postavlja ulogu na default da bude profesor kada ga dodajem, da ne bude prazno posto je null
  }

  saveProfessor(){

    //this.professor.role = Role.PROFESSOR;
    this.professorService.createProfessor(this.professor).subscribe(data =>{
      console.log(data);
      this.goToProfessorList();
    },
    error => console.log(error));
  }

  goToProfessorList(){
    this.router.navigate(['/professors']);
  }

  onSubmit(){
    console.log(this.professor);
    this.saveProfessor();
  }

}
