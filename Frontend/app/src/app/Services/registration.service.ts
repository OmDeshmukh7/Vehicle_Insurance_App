import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Registration } from '../Class/Registration';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegistrationserviceService {

  constructor(private httpclient:HttpClient) { }

  userRegister(user:Registration):Observable<any>{
    return this.httpclient.post("http://localhost:8080/User/new/", user);
  }
}