import { CourseService } from './../course.service';
import { Component, OnInit } from '@angular/core';
import { Course } from '../course';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-professor-my-course-list',
  templateUrl: './professor-my-course-list.component.html',
  styleUrls: ['./professor-my-course-list.component.css']
})
export class ProfessorMyCourseListComponent implements OnInit {

  myCourses: Course[];
  constructor(private courseService: CourseService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.getMyCourses();
  }

  getMyCourses(){
    this.courseService.getMyCourseList().subscribe(data =>{
      this.myCourses = data;
    });
  }

  updateCourse(id: number){

    this.router.navigate(['update-course', id]);

  }

  createTest(id: number){
    this.router.navigate(['professor-create-test', id]);
  }

}
