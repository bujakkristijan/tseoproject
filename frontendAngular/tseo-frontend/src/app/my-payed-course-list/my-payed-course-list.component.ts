import { StudentService } from './../student.service';
import { CourseService } from './../course.service';
import { Component, OnInit } from '@angular/core';
import { Course } from '../course';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-my-payed-course-list',
  templateUrl: './my-payed-course-list.component.html',
  styleUrls: ['./my-payed-course-list.component.css']
})
export class MyPayedCourseListComponent implements OnInit {

  myPayedCourses: Course[];
  constructor(private courseService: CourseService, private router: Router, private studentService: StudentService) { }

  ngOnInit(): void {
    this.getMyPayedCourses();
  }


  getMyPayedCourses(){
    this.courseService.getMyPayedCoursesList().subscribe(data =>{
      this.myPayedCourses = data;
    });
  }

  goToCreateStudentCourse(id: number){
    this.router.navigate(['create-student-course', id]);
  }

}
