import { UserCourse } from './../user-course';
import { ActivatedRoute } from '@angular/router';
import { StudentService } from './../student.service';
import { Component, OnInit } from '@angular/core';
import { Course } from '../course';
import { CourseService } from '../course.service';

@Component({
  selector: 'app-admin-show-student-on-course-list',
  templateUrl: './admin-show-student-on-course-list.component.html',
  styleUrls: ['./admin-show-student-on-course-list.component.css']
})
export class AdminShowStudentOnCourseListComponent implements OnInit {

  studentsOnCourse: UserCourse[];
  course: Course = new Course();
  selectedCourseId: number;

  constructor(private studentService: StudentService, private courseService: CourseService, private route: ActivatedRoute) { }

  ngOnInit(): void {

    this.getStudentsOnCourse();
  }

  deleteStudentCourse(){

  }

  getSelectedCourse(){
    this.selectedCourseId = this.route.snapshot.params['id']; // uzimam id iz rute
    this.courseService.getCourseById(this.selectedCourseId).subscribe(data =>{
      this.course = data;

    });
  }

    getStudentsOnCourse(){

      this.selectedCourseId = this.route.snapshot.params['id'];
      this.studentService.getUserCoursesByCourseId(this.selectedCourseId).subscribe(data =>{
        this.studentsOnCourse = data;
      });
    }

  }




