import { CourseService } from './../course.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Course } from '../course';
import { Payment } from '../payment';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-create-payment',
  templateUrl: './create-payment.component.html',
  styleUrls: ['./create-payment.component.css']
})
export class CreatePaymentComponent implements OnInit {

  payment: Payment = new Payment();
  courses: Course[];
  constructor(private courseService: CourseService, private studentService: StudentService, private router: Router) { }

  ngOnInit(): void {
    this.getCourses();
    console.log(this.courses);

  }

  getCourses(){
    this.courseService.getCoursesList().subscribe(data =>{
      this.courses = data;
    });
  }

  onSubmit(){
    this.studentService.createPayment(this.payment).subscribe(data =>{
      this.goToMyPayments();
    });
  }

  goToMyPayments(){
    this.router.navigate(['my-payment-list']);
  }

}
