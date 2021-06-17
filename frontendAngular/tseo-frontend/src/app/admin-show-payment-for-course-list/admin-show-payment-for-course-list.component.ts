import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Payment } from '../payment';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-admin-show-payment-for-course-list',
  templateUrl: './admin-show-payment-for-course-list.component.html',
  styleUrls: ['./admin-show-payment-for-course-list.component.css']
})
export class AdminShowPaymentForCourseListComponent implements OnInit {

  selectedCourseId: number;
  paymentsForCourse: Payment[];
  constructor(private route: ActivatedRoute, private studentService: StudentService) { }

  ngOnInit(): void {
    this.getPaymentsForCourse();
  }

  getPaymentsForCourse(){
    this.selectedCourseId = this.route.snapshot.params['id'];
    this.studentService.getPaymentsByCourseId(this.selectedCourseId).subscribe(data =>{
      this.paymentsForCourse = data;
    });
  }

}
