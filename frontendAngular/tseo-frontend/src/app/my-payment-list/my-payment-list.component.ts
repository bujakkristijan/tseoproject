import { StudentService } from './../student.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Payment } from '../payment';

@Component({
  selector: 'app-my-payment-list',
  templateUrl: './my-payment-list.component.html',
  styleUrls: ['./my-payment-list.component.css']
})
export class MyPaymentListComponent implements OnInit {

  myPayments: Payment[];
  constructor(private studentService: StudentService, private router: Router) { }

  ngOnInit(): void {
    this.getMyPayments();
  }

  private getMyPayments(){
    this.studentService.getMyPaymentList().subscribe(data => {
      this.myPayments = data;
    });
  }

  goToCreatePayment(){ // ne znam zasto more public da stoji, nece kad je private
    //this.router.navigate(['create-professor']);
  }

}
