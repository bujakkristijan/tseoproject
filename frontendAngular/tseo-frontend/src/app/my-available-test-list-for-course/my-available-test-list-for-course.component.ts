import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { CourseService } from '../course.service';
import { Test } from '../test';
import { Course } from '../course';
import { StudentService } from '../student.service';
import { UserTest } from '../user-test';

@Component({
  selector: 'app-my-available-test-list-for-course',
  templateUrl: './my-available-test-list-for-course.component.html',
  styleUrls: ['./my-available-test-list-for-course.component.css']
})
export class MyAvailableTestListForCourseComponent implements OnInit {

  myAvailableTestsForCourse: Test[];
  courseId: number;
  testId: number;
  myUserTests: UserTest[];

  course: Course = new Course();
  constructor(private courseService: CourseService,
    private router: Router, private studentService: StudentService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.getSelectedCourse();
    this.getMyUserTests();
    //this.getAvailableTestListForCourse(); // kad odavde pozivam metodu, za course salje null na back
  }

  getSelectedCourse(){
    this.courseId = this.route.snapshot.params['id'];
    this.courseService.getCourseById(this.courseId).subscribe(data =>{
      this.course = data;
      this.getAvailableTestListForCourse(); // jedino kad odavde zovem servis iz metode salje course
    });
  }

  getAvailableTestListForCourse(){
    this.studentService.getTestsForCourse(this.course).subscribe(data =>{
      this.myAvailableTestsForCourse = data;
    });
  }

  goToSignUpForTest(testId: number){
    this.router.navigate(['student-sign-up-test', testId]);
  }

  getMyUserTests(){
    this.studentService.getMyUserTestsNotGraded().subscribe(data =>{
      this.myUserTests = data;
    });
  }

}
