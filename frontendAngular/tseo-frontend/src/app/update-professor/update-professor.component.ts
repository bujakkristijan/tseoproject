import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProfessorService } from '../professor.service';
import { User } from '../user';

@Component({
  selector: 'app-update-professor',
  templateUrl: './update-professor.component.html',
  styleUrls: ['./update-professor.component.css']
})
export class UpdateProfessorComponent implements OnInit {

  id: number;
  professor: User = new User();

  constructor(private professorService: ProfessorService, private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {

    this.id = this.route.snapshot.params['id'];
    this.professorService.getProfessorById(this.id).subscribe(data =>{
      this.professor = data;
      console.log(this.professor);
    })
  }

  onSubmit(){
    this.professorService.updateProfessor(this.professor).subscribe(data =>{
      this.goToProfessorList();
    })
  }

  goToProfessorList(){
    this.router.navigate(['/professors']);
  }

}
