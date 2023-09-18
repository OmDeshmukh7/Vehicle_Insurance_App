import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClaimManagementComponent } from './Admin-Dashboard/claim-management/claim-management.component';
import { InsuranceManagementComponent } from './Admin-Dashboard/insurance-management/insurance-management.component';
import { CustomerManagementComponent } from './Admin-Dashboard/customer-management/customer-management.component';
import { VehicleManagementComponent } from './Customer-Dashboard/vehicle-management/vehicle-management.component';
import { PaymentsComponent } from './Customer-Dashboard/payments/payments.component';
import { DocumentManagementComponent } from './Customer-Dashboard/document-management/document-management.component';
import { LoginComponent } from './login/login.component';
import { PremiumCalculatorComponent } from './Customer-Dashboard/premium-calculator/premium-calculator.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { CustomerDashComponent } from './Customer-Dashboard/customer-dash/customer-dash.component';
import { AdminDashComponent } from './Admin-Dashboard/admin-dash/admin-dash.component';
import { RegisterComponent } from './register/register.component';
import { HttpClientModule } from '@angular/common/http';
import { InspectionManagementComponent } from './Admin-Dashboard/inspection-management/inspection-management.component';

@NgModule({
  declarations: [
    AppComponent,
    ClaimManagementComponent,
    InsuranceManagementComponent,
    CustomerManagementComponent,
    VehicleManagementComponent,
    PaymentsComponent,
    DocumentManagementComponent,
    LoginComponent,
    PremiumCalculatorComponent,
    LandingPageComponent,
    CustomerDashComponent,
    AdminDashComponent,
    RegisterComponent,
    InspectionManagementComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
