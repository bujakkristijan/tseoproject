import { AppComponent } from './../app.component';
import { ProfessorService } from './../professor.service';
import { CourseService } from './../course.service';
import { Component, OnInit } from '@angular/core';
import { Course } from '../course';
import { ActivatedRoute, Router } from '@angular/router';
import { Test } from '../test';

@Component({
  selector: 'app-professor-create-test',
  templateUrl: './professor-create-test.component.html',
  styleUrls: ['./professor-create-test.component.css']
})
export class ProfessorCreateTestComponent implements OnInit {

  id: number;
  course: Course;
  test: Test = new Test();
  constructor(private courseService: CourseService, private professorService: ProfessorService,
    private router: Router, private route: ActivatedRoute, private appComponent: AppComponent) { }

  ngOnInit(): void {
    this.getSelectedCourse();
    //this.test.course = this.course; // setujem kurs za test koji prvo dobijem sa backa OVO JE BIO PROBLEM STO SALJE NULL NA BACK NZM STOOO!!!!
    this.test.user = this.appComponent.loggedUser;
    console.log(this.test.user);
    //console.log(this.test.course);
  }

  getSelectedCourse(){
    this.course = new Course();
    this.id = this.route.snapshot.params['id'];
    this.courseService.getCourseById(this.id).subscribe(data =>{
      this.course = data;
      //console.log(this.course);
      this.test.course = this.course;

      console.log(this.test.course);
    });
  }

  onSubmit(){
    this.professorService.createTest(this.test).subscribe(data =>{
      this.goToProfessorCourseList();
    });
  }
  goToProfessorCourseList(){
    this.router.navigate(['professor-my-course-list']);
  }

}
