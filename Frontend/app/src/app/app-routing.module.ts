import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { CustomerDashComponent } from './Customer-Dashboard/customer-dash/customer-dash.component';
import { AdminDashComponent } from './Admin-Dashboard/admin-dash/admin-dash.component';
import { RegisterComponent } from './register/register.component';
import { ClaimManagementComponent } from './Admin-Dashboard/claim-management/claim-management.component';
import { InspectionManagementComponent } from './Admin-Dashboard/inspection-management/inspection-management.component';
import { InsuranceManagementComponent } from './Admin-Dashboard/insurance-management/insurance-management.component';
import { CustomerManagementComponent } from './Admin-Dashboard/customer-management/customer-management.component';


const routes: Routes = [
  {path:'',component:LandingPageComponent},
  {path:'Landing',component:LandingPageComponent},
  {path:'Login',component:LoginComponent},
  {path:'Register/Login',component:LoginComponent},
  {path:'Register',component:RegisterComponent},
  {path:'CustomerDash',component:CustomerDashComponent},
  {path:'AdminDash',component:AdminDashComponent},
  {path:'AdminDash/AdminClaim',component:ClaimManagementComponent},
  {path:'AdminDash/AdminInspection',component:InspectionManagementComponent},
  {path:'AdminDash/AdminInsurance',component:InsuranceManagementComponent},
  {path:'AdminDash/AdminCustomer',component:CustomerManagementComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
