import { Role } from './role.enum';
import { LoginService } from './login.service';
import { Component, OnInit } from '@angular/core';
import { User } from './user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  loggedUser: User;
  RoleTypeAdmin: Role;

  ngOnInit(): void {
    //this.getLoggedUser();
    this.loggedUser = new User();
    this.RoleTypeAdmin = Role.ADMIN;
    //this.loggedUser.email = "NEKI EMAIL";
    //this.getLoggedUser();


  }
  constructor(private loginService: LoginService, private router: Router){}
  title = 'E-nastava';

  getLoggedUser(){
    this.loginService.getLoggedUser().subscribe(data =>{
      this.loggedUser = data;
    });
  }

  signOut(){
    this.loggedUser = new User();
    this.loggedUser.role = "SignOutRole";
    this.router.navigate(['login']);
  }
}
