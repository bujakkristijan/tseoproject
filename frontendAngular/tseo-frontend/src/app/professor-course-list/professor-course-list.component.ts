import { ProfessorCourseService } from './../professor-course.service';
import { UserCourse } from './../user-course';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-professor-course-list',
  templateUrl: './professor-course-list.component.html',
  styleUrls: ['./professor-course-list.component.css']
})
export class ProfessorCourseListComponent implements OnInit {

  professorCourses: UserCourse[];
  constructor(private professorCourseService: ProfessorCourseService, private router: Router) { }

  ngOnInit(): void {
    this.getProfessorCourses();
    console.log(this.professorCourses);
  }

  private getProfessorCourses(){
    this.professorCourseService.getProfessorCourseList().subscribe(data =>{
      this.professorCourses = data;
    });
  }

  goToCreateProfessorCourse(){
    this.router.navigate(['create-professor-course']);
  }

  deleteProfessorCourse(id: number){
    this.professorCourseService.deleteProfessorCourse(id).subscribe(data =>{
      this.getProfessorCourses();
    });

  }


}
