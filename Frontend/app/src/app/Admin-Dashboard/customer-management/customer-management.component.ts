import { Component } from '@angular/core';
import { Customer } from 'src/app/Class/Customer';
import { AdminCustomerService } from 'src/app/Services/admin-customer.service';

@Component({
  selector: 'app-customer-management',
  templateUrl: './customer-management.component.html',
  styleUrls: ['./customer-management.component.css']
})
export class CustomerManagementComponent {
  Customer: Customer[]=[];

  constructor(private adminService:AdminCustomerService){

  }
  ngOnInit():void{
this.VievAllCustomers()
  }
  VievAllCustomers(){
    this.adminService.getAllcustomers().subscribe({
      next:(data)=>{
        console.log(data)
        this.Customer=data
      },
      error:(err)=>{
console.log(err);
      }
    })
  }
}
