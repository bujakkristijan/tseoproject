import { CourseService } from './../course.service';
import { Component, OnInit } from '@angular/core';
import { Course } from '../course';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-course',
  templateUrl: './update-course.component.html',
  styleUrls: ['./update-course.component.css']
})
export class UpdateCourseComponent implements OnInit {

  id: number;
  course: Course = new Course();
  constructor(private courseService: CourseService, private router: Router,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.courseService.getCourseById(this.id).subscribe(data =>{
      this.course = data;
    })
  }

  onSubmit(){
    this.courseService.updateCourse(this.course).subscribe(data =>{
      this.goToCourseList();
    })
  }

  goToCourseList(){
    this.router.navigate(['/courses']);
  }

}
