import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DoctorsRoutingModule } from './doctors-routing.module';
import { DoctorsDashboardComponent } from './doctors-dashboard/doctors-dashboard.component';
import { AdddetailComponent } from './adddetail/adddetail.component';
import { AvailabilitycheckComponent } from './availabilitycheck/availabilitycheck.component';
import { DocprofileComponent } from './docprofile/docprofile.component';


@NgModule({
  declarations: [
    DoctorsDashboardComponent,
    AdddetailComponent,
    AvailabilitycheckComponent,
    DocprofileComponent
  ],
  imports: [
    CommonModule,
    DoctorsRoutingModule
  ]
})
export class DoctorsModule { }
