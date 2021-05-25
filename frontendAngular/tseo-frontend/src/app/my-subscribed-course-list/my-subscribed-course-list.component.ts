import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Course } from '../course';
import { CourseService } from '../course.service';

@Component({
  selector: 'app-my-subscribed-course-list',
  templateUrl: './my-subscribed-course-list.component.html',
  styleUrls: ['./my-subscribed-course-list.component.css']
})
export class MySubscribedCourseListComponent implements OnInit {

  mySubscribedCourses: Course[];
  constructor(private courseService: CourseService, private router: Router) { }

  ngOnInit(): void {
    this.getMySubscribedCourses();
  }

  getMySubscribedCourses(){
    this.courseService.getMySubscribedCourseList().subscribe(data =>{
      this.mySubscribedCourses = data;
    });
  }

  goToShowAvailableTests(id: number){
    this.router.navigate(["my-available-test-list-for-course", id]);
  }
}
