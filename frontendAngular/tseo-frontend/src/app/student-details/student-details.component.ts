import { StudentService } from './../student.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { User } from '../user';

@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrls: ['./student-details.component.css']
})
export class StudentDetailsComponent implements OnInit {

  id: number;
  student: User;
  constructor(private route: ActivatedRoute, private studentService: StudentService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.student = new User();
    this.studentService.getStudentById(this.id).subscribe(data =>{
      this.student = data;
    })
  }

}
