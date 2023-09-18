import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Login } from '../Class/Login'

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private httpclient:HttpClient) { }

  login(user:Login):Observable<any>{
    return this.httpclient.post("http://localhost:8080/login",user);
  }
}
