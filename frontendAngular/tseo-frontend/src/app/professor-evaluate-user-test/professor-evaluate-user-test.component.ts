import { ProfessorService } from './../professor.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { UserTest } from '../user-test';

@Component({
  selector: 'app-professor-evaluate-user-test',
  templateUrl: './professor-evaluate-user-test.component.html',
  styleUrls: ['./professor-evaluate-user-test.component.css']
})
export class ProfessorEvaluateUserTestComponent implements OnInit {

  userTestId: number;
  userTest: UserTest = new UserTest();
  constructor(private route: ActivatedRoute, private router: Router, private professorService: ProfessorService) { }

  ngOnInit(): void {
    this.getSelectedUserTest();
  }

  getSelectedUserTest(){
    this.userTestId = this.route.snapshot.params['id'];
    this.professorService.getUserTestById(this.userTestId).subscribe(data =>{
      this.userTest = data;
    });

  }

  onSubmit(){
    this.professorService.updateUserTest(this.userTest).subscribe(data =>{
      this.goToMySignedUpTestList();
    })
  }

  goToMySignedUpTestList(){
    this.router.navigate(['professor-signed-up-test-list', this.userTest.test.id]); // da ga vrati na listu signed up testova za isti test
  }

}
