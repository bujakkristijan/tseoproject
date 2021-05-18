import { LoginService } from './login.service';
import { Component, OnInit } from '@angular/core';
import { User } from './user';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  loggedUser: User;
  ngOnInit(): void {
    //this.getLoggedUser();
    this.loggedUser = new User();
    this.loggedUser.email = "NEKI EMAIL";
  }
  constructor(private loginService: LoginService){}
  title = 'E-nastava';

  getLoggedUser(){
    this.loginService.getLoggedUser().subscribe(data =>{
      this.loggedUser = data;
    });
  }
}
