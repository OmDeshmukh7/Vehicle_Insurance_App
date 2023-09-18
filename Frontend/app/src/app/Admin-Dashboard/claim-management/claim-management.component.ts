import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Claim } from 'src/app/Class/Claim';
import { AdminClaimsService } from 'src/app/Services/admin-claims.service';

@Component({
  selector: 'app-claim-management',
  templateUrl: './claim-management.component.html',
  styleUrls: ['./claim-management.component.css']
})
export class ClaimManagementComponent {
  claim: Claim[]=[];

  constructor(private backendClaimService: AdminClaimsService, private httpClient: HttpClient) {}

  ngOnInit(): void{
    this.viewAllClaim()
  }
  
  viewAllClaim(){
    this.backendClaimService.getAllClaims().subscribe(
      {
        next:(data)=>{
          console.log(data)
          this.claim = data
        },
        error:(err)=>{
          console.log(err);
        }
      }
    )
  }

  approveClaim(claim: any) {
    const id = claim.claimId; 
    this.httpClient.put('http://localhost:8080/claim/status/'+id,Response).subscribe();
    console.log(`Approving claim for ID: ${claim.claimId}`);
  }

  rejectClaim(claim: any) {
    const id = claim.claimId; 
    this.httpClient.put('http://localhost:8080/claim/reject/'+id,Response).subscribe();
    console.log(`Rejecting claim for ID: ${claim.endUserId}`);
  }
}
