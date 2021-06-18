import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Course } from '../course';
import { CourseService } from '../course.service';
import { ProfessorService } from '../professor.service';
import { UserCourse } from '../user-course';

@Component({
  selector: 'app-admin-show-professor-on-course-list',
  templateUrl: './admin-show-professor-on-course-list.component.html',
  styleUrls: ['./admin-show-professor-on-course-list.component.css']
})
export class AdminShowProfessorOnCourseListComponent implements OnInit {

  professorsOnCourse: UserCourse[];
  course: Course = new Course();
  selectedCourseId: number;

  constructor(private professorService: ProfessorService, private route: ActivatedRoute) { }

  ngOnInit(): void {

    this.getProfessorsOnCourse();
  }

  deleteProfessorCourse(professorCourseId: number){
    this.professorService.deleteProfessorCourse(professorCourseId).subscribe(data =>{
      this.getProfessorsOnCourse();
    });

  }

  getProfessorsOnCourse(){

    this.selectedCourseId = this.route.snapshot.params['id']; // uzimam id kursa iz rute
    this.professorService.getUserCoursesByCourseId(this.selectedCourseId).subscribe(data =>{
      this.professorsOnCourse = data;
    });
  }
  }
