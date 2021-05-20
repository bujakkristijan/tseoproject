import { StudentService } from './../student.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Course } from '../course';
import { CourseService } from '../course.service';

@Component({
  selector: 'app-create-student-course',
  templateUrl: './create-student-course.component.html',
  styleUrls: ['./create-student-course.component.css']
})
export class CreateStudentCourseComponent implements OnInit {

  id: number;
  course: Course;
  constructor(private route: ActivatedRoute, private courseService: CourseService, private studentService: StudentService,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.course = new Course();
    this.courseService.getCourseById(this.id).subscribe(data =>{
      this.course = data;
    });
  }

  onSubmit(){
    this.studentService.createStudentCourse(this.course).subscribe(data =>{
      this.goToMyPayedCourseList();
    });
  }

  goToMyPayedCourseList(){
    this.router.navigate(['my-payed-course-list']);
  }

}
