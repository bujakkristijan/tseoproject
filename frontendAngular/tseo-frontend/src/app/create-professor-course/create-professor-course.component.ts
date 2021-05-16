import { ProfessorCourseService } from './../professor-course.service';
import { Component, OnInit } from '@angular/core';
import { UserCourse } from '../user-course';
import { Router } from '@angular/router';
import { User } from '../user';
import { Course } from '../course';
import { ProfessorService } from '../professor.service';
import { CourseService } from '../course.service';

@Component({
  selector: 'app-create-professor-course',
  templateUrl: './create-professor-course.component.html',
  styleUrls: ['./create-professor-course.component.css']
})
export class CreateProfessorCourseComponent implements OnInit {

  professorCourse: UserCourse = new UserCourse();
  professors: User[];
  courses: Course[];

  constructor(private professorCourseService: ProfessorCourseService,
    private courseService: CourseService, private professorService: ProfessorService, private router: Router) { }

  ngOnInit(): void {
    this.getCourses();
    this.getProfessors();
    console.log(this.professors);
    console.log(this.courses);
  }

  saveProfessorCourse(){
    this.professorCourseService.createProfessorCourse(this.professorCourse).subscribe(data =>{
      this.goToProfessorCourseList();
    })
  }

  onSubmit(){
    this.saveProfessorCourse();
  }

  goToProfessorCourseList(){
    this.router.navigate(['/professor-courses']);
  }

  getProfessors(){
    this.professorService.getProfessorsList().subscribe(data =>{
      this.professors = data;
    })
  }

  getCourses(){
    this.courseService.getCoursesList().subscribe(data =>{
      this.courses = data;
    })
  }

}
