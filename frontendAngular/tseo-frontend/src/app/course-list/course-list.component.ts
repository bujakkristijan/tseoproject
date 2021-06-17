import { CourseService } from './../course.service';
import { Component, OnInit } from '@angular/core';
import { Course } from '../course';
import { Router } from '@angular/router';

@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.css']
})
export class CourseListComponent implements OnInit {

  courses: Course[];
  constructor(private courseService: CourseService, private router: Router) { }

  ngOnInit(): void {
    this.getCourses();
  }

  private getCourses(){
    this.courseService.getCoursesList().subscribe(data =>{
      this.courses = data;
    })

  }

  updateCourse(id: number){
    this.router.navigate(['update-course', id]);

  }

  goToCreateCourse(){
    this.router.navigate(['create-course']);
  }

  deleteCourse(id: number){
    this.courseService.deleteCourse(id).subscribe(data =>{
      this.getCourses();
    })
  }

  goToStudentsOnCourse(id: number){
    this.router.navigate(['admin-show-student-on-course-list', id]);
  }

  goToProfessorsOnCourse(id: number){
    this.router.navigate(['admin-show-professor-on-course-list', id]);
  }

  goToPaymentsForCourse(id: number){
    this.router.navigate(['admin-show-payment-for-course-list', id]);
  }

}
