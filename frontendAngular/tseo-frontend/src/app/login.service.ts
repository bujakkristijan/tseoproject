import { Login } from './login';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private httpClient: HttpClient) { }

  loginSendParams(loginInput: Login): Observable<Object>{
    return this.httpClient.post("http://localhost:8080/login/loginCheck", loginInput);
  }

  getLoggedUser():Observable<User>{
    return this.httpClient.get<User>("http://localhost:8080/login/getCurrentUserLoggedIn");
  }
}
