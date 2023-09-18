import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Insurance } from 'src/app/Class/Insurance';

import { AdminInsuranceService } from 'src/app/Services/admin-insurance.service';

@Component({
  selector: 'app-insurance-management',
  templateUrl: './insurance-management.component.html',
  styleUrls: ['./insurance-management.component.css']
})
export class InsuranceManagementComponent {
  insurance: Insurance[] = [];

  constructor(private service:AdminInsuranceService, private httpClient: HttpClient){}

  ngOnInit():void{
    this.viewAllInsurance()
  }

  viewAllInsurance(){
    this.service.getAllInsurances().subscribe(
      {
        next:(data)=>{
          console.log(data)
          this.insurance = data
        },
        error:(err)=>{
          console.log(err);
        }
      }
    )
  }

 approveInsurance(insurance:any){
  const id = insurance.insuranceId;
  this.httpClient.put('http://localhost:8080/insurance/status/'+id,Response).subscribe();
  console.log(`Approving insurance for ID: ${insurance.insuranceId}`)
 }

  rejectInsurance(insurance:any){
    const id = insurance.insuranceId;
    this.httpClient.put('http://localhost:8080/insurance/reject/'+id,Response).subscribe();
    console.log(`Rejecting claim for ID: ${insurance.insuranceId}`);
  }
}
