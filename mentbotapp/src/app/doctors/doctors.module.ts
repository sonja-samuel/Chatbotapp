import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DoctorsRoutingModule } from './doctors-routing.module';
import { DoctorsDashboardComponent } from './doctors-dashboard/doctors-dashboard.component';
import { AdddetailComponent } from './adddetail/adddetail.component';
import { AvailabilitycheckComponent } from './availabilitycheck/availabilitycheck.component';
import { DocprofileComponent } from './docprofile/docprofile.component';
import { AddspecialityComponent } from './addspeciality/addspeciality.component';
// import {NgxMaterialTimepickerModule} from 'ngx-material-timepicker';
import { TimepickerModule, } from 'ngx-bootstrap/timepicker';
import { NgbTimepicker , NgbTimepickerModule ,NgbModule,NgbTimeAdapter} from '@ng-bootstrap/ng-bootstrap'
import { FormsModule } from '@angular/forms';
import {MatCheckboxModule} from '@angular/material/checkbox';



@NgModule({
  declarations: [
    DoctorsDashboardComponent,
    AdddetailComponent,
    AvailabilitycheckComponent,
    DocprofileComponent,
    AddspecialityComponent
  ],
  imports: [
    CommonModule,
    DoctorsRoutingModule,
    // NgxMaterialTimepickerModule,
    TimepickerModule.forRoot(),
    // NgbTimepickerModule,
    // NgbTimepicker,
    NgbModule,
    FormsModule,
    MatCheckboxModule,
    
    
  ]
})
export class DoctorsModule { }
