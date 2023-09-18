import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { LoginService } from '../Services/login.service';
import { Router } from '@angular/router';
import { Login } from '../Class/Login';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  user:Login = new Login("","","");
  router: any;
  

  constructor(private http: HttpClient,private loginService:LoginService, private Router: Router) {}
  ngOnInit(): void {
      this.loginService.login(this.user).subscribe({
          next:(value) =>{
            console.log("user",value);
            if (this.user.userName === 'Admin') {
              this.Router.navigate(['AdminDash'])
            }else{
              this.Router.navigate(['CustomerDash'])
            } 
          },
        error(err){
          console.log(err);
        },
      }
    );
  }
}
