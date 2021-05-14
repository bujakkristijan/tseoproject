import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../user';
import { StudentService } from './../student.service';
@Component({
  selector: 'app-update-student',
  templateUrl: './update-student.component.html',
  styleUrls: ['./update-student.component.css']
})
export class UpdateStudentComponent implements OnInit {
  id: number;
  student: User = new User();
  constructor(private studentService: StudentService, private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id']; /**uzimam id iz route */
    this.studentService.getStudentById(this.id).subscribe( data =>{
      this.student = data;
    })
  }

  onSubmit(){
    this.studentService.updateStudent(this.student).subscribe(data =>{
      this.goToStudentList();
    })
  }

  goToStudentList(){
    this.router.navigate(['/students']);
  }
}
