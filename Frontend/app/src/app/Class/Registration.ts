export class Registration {
    name?:string;
    mobile?:string;
    email?:string;
    address?:string;
    userName?:string;
    password?:string;
    role :string = "User";
 
    constructor(name:string,mobile:string,email:string,address:string,userName:string,password:string,role:string){
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
        this.password = password;
        this.userName = userName;
        this.role = role;
    }
}