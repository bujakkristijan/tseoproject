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
  //loginInput: Login;
  constructor(private loginService: LoginService, private router: Router, private appComponent: AppComponent) { }

  ngOnInit(): void {
  }

  onSubmit(){
    this.loginService.loginSendParams(this.loginInput).subscribe(data =>{

      this.goToStudentList();

    });
    //this.appComponent.getLoggedUser();
  }

  goToStudentList(){
    this.router.navigate(['/students']);
  }

}
