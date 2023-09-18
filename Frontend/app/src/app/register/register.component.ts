import { Router } from '@angular/router';
import { Component } from '@angular/core';
import { Registration } from '../Class/Registration';
import { RegistrationserviceService } from '../Services/registration.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  user : Registration  =new Registration(
    "",
    "",
    "",
    "",
    "",
    "",
   ""
  )

  constructor(private http: HttpClient, private backendRegister : RegistrationserviceService, private Router: Router){}

  userRegistration(){
    this.backendRegister.userRegister(this.user).subscribe({
      next:(data)=>{
        console.log(data)
        console.log('hello')
      },
      error:(err)=>{
        console.log(err)
      }
    })
  }
}
