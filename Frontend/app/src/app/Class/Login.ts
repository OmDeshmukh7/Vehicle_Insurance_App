export class Login{
    userName?:string;
    password?:string;
    role:string='User';

    constructor(userName:string,password:string,role:string){
        this.password = password;
        this.userName = userName;
        this.role = role;
    }
}