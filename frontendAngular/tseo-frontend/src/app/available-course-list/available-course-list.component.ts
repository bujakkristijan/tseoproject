import { CourseService } from './../course.service';
import { Component, OnInit } from '@angular/core';
import { Course } from '../course';

@Component({
  selector: 'app-available-course-list',
  templateUrl: './available-course-list.component.html',
  styleUrls: ['./available-course-list.component.css']
})
export class AvailableCourseListComponent implements OnInit {

  courses: Course[];
  constructor(private courseService: CourseService) { }

  ngOnInit(): void {
    this.getAllAvailableCourses();
  }

  getAllAvailableCourses(){
    this.courseService.getCoursesList().subscribe(data =>{
      this.courses = data;
    });
  }

}
