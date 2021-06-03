import { User } from './../user';
import { AppComponent } from './../app.component';
import { LoginService } from './../login.service';
import { Component, OnInit } from '@angular/core';
import { Login } from '../login';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginInput: Login = new Login();
  loggedUser: User;
  role: String;
  //loginInput: Login;
  constructor(private loginService: LoginService, private router: Router, private appComponent: AppComponent) { }

  ngOnInit(): void {
  }

  onSubmit(){
    this.loginService.loginSendParams(this.loginInput).subscribe(data =>{

      this.loginService.getLoggedUser().subscribe(data =>{

        this.appComponent.getLoggedUser(); // da bi mi u navbaru ispisivalo jer je u app componenti
        this.loggedUser = data;
        this.routeDependingOnRole();

        //this.roleCheck();

      });


      console.log(this.role);
      //this.goToStudentList();

    });
    //this.appComponent.getLoggedUser();
  }

  goToStudentList(){
    this.router.navigate(['/students']);
  }

  logout(){
    this.loginService.logout().subscribe(data =>{
     // this.appComponent.signOut();
    });
  }
  routeDependingOnRole(){
    if(this.loggedUser.role == "STUDENT"){
      this.router.navigate(['available-course-list']);
       }
       if(this.loggedUser.role == "PROFESSOR" || this.loggedUser.role == "TEACHING_ASSISTANT" || this.loggedUser.role == "DEMONSTRATOR"){
        this.router.navigate(['professor-my-course-list']);

      }
      if(this.loggedUser.role == "ADMIN"){
        this.router.navigate(['students']);

      }
  }
}
