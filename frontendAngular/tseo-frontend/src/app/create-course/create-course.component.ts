import { CourseService } from './../course.service';
import { Component, OnInit } from '@angular/core';
import { Course } from '../course';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-course',
  templateUrl: './create-course.component.html',
  styleUrls: ['./create-course.component.css']
})
export class CreateCourseComponent implements OnInit {

  course: Course = new Course();
  constructor(private courseService: CourseService, private router: Router ) { }

  ngOnInit(): void {
  }

  saveCourse(){
    this.courseService.createCourse(this.course).subscribe(data =>{
      this.goToCourseList();
    })
  }

  goToCourseList(){
    this.router.navigate(['/courses']);
  }

  onSubmit(){
    this.saveCourse();
  }

}
